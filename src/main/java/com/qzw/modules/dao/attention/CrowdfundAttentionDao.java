package com.qzw.modules.dao.attention;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.attention.CrowdfundAttention;
import com.qzw.modules.webservice.attention.vo.CrowdfundAttentionRequestVo;
import com.qzw.modules.webservice.attention.vo.CrowdfundAttentionResponseVo;
import org.apache.ibatis.annotations.Param;

import javax.ws.rs.PathParam;
import java.util.List;

@MyBatisDao
public interface CrowdfundAttentionDao {
    /**
     * 添加我关注的项目
     * @param crowdfundAttention
     */
    void insert(CrowdfundAttention crowdfundAttention);
    /**
     * 获取我关注的列表信息
     * @param crowdfundAttentionRequestVo
     * @return
     */
    List<CrowdfundAttentionResponseVo> getList(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo);
    /**
     * 获取我关注的总数
     * @param crowdfundAttentionRequestVo
     * @return
     */
    Long countList(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo);
    /**
     * 获取关注人数
     * @param crowdfundAttentionResponseVo
     * @return
     */
    Long countNumber(Integer crowdfundAttentionResponseVo);
/*    *//**
     * 取消关注
     * @param crowdfundAttentionRequestVo
     *//*
    void deleteById(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo);*/
    /**
     * 取消关注
     * @param crowdfundAttention
     */
    void updateById(CrowdfundAttention crowdfundAttention);

    /**
     * 是否关注
     * @param userId
     * @return
     */
    int checkAttionByUserId(@Param("aparId") Long aparId, @Param("userId")String userId);
    /**
     * 查询数据库有没有这条数据
     * @return
     */
    CrowdfundAttentionResponseVo select(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo);
}