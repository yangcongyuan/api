package com.qzw.modules.service.attention;

import com.qzw.modules.dao.attention.CrowdfundAttentionDao;
import com.qzw.modules.model.attention.CrowdfundAttention;
import com.qzw.modules.webservice.attention.vo.CrowdfundAttentionRequestVo;
import com.qzw.modules.webservice.attention.vo.CrowdfundAttentionResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */

@Service
@Transactional
public class CrowdfundAttentionService {

    @Autowired
    private CrowdfundAttentionDao crowdfundAttentionDao;

    /**
     * 添加我关注的房源
     * @param crowdfundAttentionRequestVo
     */
    public void insert(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo){
            if (this.select(crowdfundAttentionRequestVo) != null){
                CrowdfundAttention crowdfundAttention=new CrowdfundAttention();
                crowdfundAttention.setUserId(crowdfundAttentionRequestVo.getUserId());
                crowdfundAttention.setAttentionNo(crowdfundAttentionRequestVo.getAttentionNo());
                crowdfundAttention.setAttentionType(0);
                crowdfundAttentionDao.updateById(crowdfundAttention);
            }else {
            CrowdfundAttention crowdfundAttention = new CrowdfundAttention();
            crowdfundAttention.setUserId(crowdfundAttentionRequestVo.getUserId());
            crowdfundAttention.setAttentionNo(crowdfundAttentionRequestVo.getAttentionNo());
            crowdfundAttention.setAttentionType(0);
            crowdfundAttention.setAttentionTime(new Date());
            crowdfundAttentionDao.insert(crowdfundAttention);
            }

    }

    /**
     * 获取我关注的列表信息
     * @param crowdfundAttentionRequestVo
     * @return
     */
    public List<CrowdfundAttentionResponseVo> getList(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo){
        List<CrowdfundAttentionResponseVo> list=crowdfundAttentionDao.getList(crowdfundAttentionRequestVo);
        for (CrowdfundAttentionResponseVo vo:list){
            vo.setNumber(this.countNember(vo.getAttentionNo()));
        }
        return list;
    }
    /**
     * 获取我关注的数量
     * @param crowdfundAttentionRequestVo
     * @return
     */
    public Long countList(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo){
        return crowdfundAttentionDao.countList(crowdfundAttentionRequestVo);
    }
    /**
     * 获取关注人数
     * @param crowdfundAttentionResponseVo
     * @return
     */
    public Long countNember(Integer crowdfundAttentionResponseVo){
        return crowdfundAttentionDao.countNumber(crowdfundAttentionResponseVo);
    }

    /**
     * 取消关注
     * @param crowdfundAttentionRequestVo
     */
    public void updateById(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo){
        CrowdfundAttention crowdfundAttention=new CrowdfundAttention();
        crowdfundAttention.setUserId(crowdfundAttentionRequestVo.getUserId());
        crowdfundAttention.setAttentionNo(crowdfundAttentionRequestVo.getAttentionNo());
        crowdfundAttention.setAttentionType(1);
        crowdfundAttentionDao.updateById(crowdfundAttention);
    }

    /**
     * 查询数据库有没有这条数据
     * @param crowdfundAttentionRequestVo
     * @return
     */
    public CrowdfundAttentionResponseVo select(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo){
        return crowdfundAttentionDao.select(crowdfundAttentionRequestVo);
    }
}
