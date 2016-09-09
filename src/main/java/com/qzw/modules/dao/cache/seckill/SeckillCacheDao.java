package com.qzw.modules.dao.cache.seckill;

import com.qzw.modules.model.apartment.seckill.ApartmentSeckill;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by guozheng on 2016/6/27.
 */
public class SeckillCacheDao {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    private JedisPool jedisPool;

    private RuntimeSchema<ApartmentSeckill> schema = RuntimeSchema.createFrom(ApartmentSeckill.class);

    public SeckillCacheDao(String ip , int port){
        jedisPool = new JedisPool(ip,port);
    }
    public ApartmentSeckill getSeckill(long seckillId){
        //redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:"+seckillId;
                //并没有实现内部序列化操作
                //get - > byte[] ->反序列化 ->Ob
                //采用自定义序列化
                //protostuff :pojo.java
                byte[] bytes = jedis.get(key.getBytes());
                //缓存重获取到
                if(bytes != null){
                    //空对象
                    ApartmentSeckill apartmentSeckill = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes,apartmentSeckill,schema);
                    //seckill 反序列化
                    return apartmentSeckill;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return  null;
    }

    public String putApartmentSeckill(ApartmentSeckill apartmentSeckill){
        //set Object (seckill) ->-> 序列化 -byte[]
        try{
            Jedis jedis = jedisPool.getResource();
            try {
             String key = "seckill:"+apartmentSeckill.getApartmentId();
             byte[] bytes = ProtostuffIOUtil.toByteArray(apartmentSeckill,schema,
                     LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //超时缓存
                int timeout = 60 * 60;//一小时
                String rseult = jedis.setex(key.getBytes(),timeout,bytes);
                return rseult;

            }finally {
                jedis.close();
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

        return  null;
    }
}
