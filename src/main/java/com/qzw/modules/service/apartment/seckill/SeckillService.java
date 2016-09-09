package com.qzw.modules.service.apartment.seckill;

import com.qzw.modules.dao.apartment.ApartmentDao;
import com.qzw.modules.dao.apartment.seckill.ApartmentSeckillDao;
import com.qzw.modules.dao.apartment.seckill.SeckillSuccessDao;
import com.qzw.modules.dao.cache.seckill.SeckillCacheDao;
import com.qzw.modules.dto.Exposer;
import com.qzw.modules.dto.SeckillExecution;
import com.qzw.modules.enums.SeckillStateEnum;
import com.qzw.modules.model.apartment.seckill.ApartmentSeckill;
import com.qzw.modules.model.apartment.seckill.SeckillSuccess;
import com.qzw.modules.webservice.apartment.vo.ApartmentDetailVo;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/7/28.
 */
@Service
public class SeckillService {

    @Autowired
    private ApartmentDao apartmentDao;

    @Autowired
    private ApartmentSeckillDao apartmentSeckillDao;

    @Autowired
    private SeckillSuccessDao seckillResultDao;

    @Autowired
    private SeckillCacheDao seckillCacheDao;


    //MD5盐值字符串，用于混淆MD5
    private final String slat = "asdfdaesfdsaf!@@#@$fsdaf";

    public Exposer exportSeckillUrl(Long seckillId) {
        //通过redis缓存起来，缓存优化。
        //1:访问redis
        ApartmentSeckill apartmentSeckill = seckillCacheDao.getSeckill(seckillId);

        if (apartmentSeckill == null) {
            //2：访问数据库
            apartmentSeckill = new ApartmentSeckill();
            apartmentSeckill.setApartmentId(seckillId);
            apartmentSeckill = apartmentSeckillDao.get(apartmentSeckill);
            if (apartmentSeckill == null) {
                return new Exposer(false, seckillId);
            } else {
                //3:放入redis
                seckillCacheDao.putApartmentSeckill(apartmentSeckill);
            }
        }


        if (apartmentSeckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = apartmentSeckill.getStartTime();
        Date endTime = apartmentSeckill.getEndTime();
        //系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        //转化特定字符串的过程，不可逆
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    /**
     * 执行秒杀操作by存储过程
     * @param seckillId  秒杀单号
     * @param userId     秒杀用户
     * @param md5
     * @return
     */
    public SeckillExecution executeSeckillProcedure(Long seckillId, String userId, String md5) {
        ApartmentDetailVo vo = apartmentDao.getDetailById(seckillId);
        //作弊，如果在该房源已存在用户编号，只能此用户购买
        if(null != vo.getUserId() && !userId.equals(vo.getUserId().toString())){
            return new SeckillExecution(seckillId, SeckillStateEnum.END);
        }
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            return new SeckillExecution(seckillId, SeckillStateEnum.DATA_REWRITE);
        }
        Date killTime = new Date();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("seckillId", seckillId);
        map.put("userId", userId);
        map.put("killTime", killTime);
        map.put("result", null);
        //执行存储过程之后，result 被赋值
        try {
            apartmentSeckillDao.killByProcedure(map);
            //获取result
            int result = MapUtils.getInteger(map, "result", -2);
            if (result == 1) {
                SeckillSuccess sk = seckillResultDao.queryByIdWithSeckill(seckillId, userId);
                return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, sk);
            } else {
                return new SeckillExecution(seckillId, SeckillStateEnum.stateOf(result));
            }
        } catch (Exception e) {
            return new SeckillExecution(seckillId, SeckillStateEnum.INNER_ERROR);
        }

    }

    //生成md5
    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        //生成MD5工具类
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }


}
