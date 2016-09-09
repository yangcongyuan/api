package com.qzw.modules.dao.msg;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.msg.MessageText;
import com.qzw.modules.webservice.msg.vo.MessageRequestVo;
import com.qzw.modules.webservice.msg.vo.MessageResponseVo;

import java.util.List;

@MyBatisDao
public interface MessageTextDao {

    /**
     * 添加站内信
     * @param record
     * @return
     */
    int insert(MessageText record);
    /**
     * 获取站内信列表
     * @param messageRequestVo
     * @return
     */
    List<MessageResponseVo> statueList(MessageRequestVo messageRequestVo);
    /**
     * 获取站内信数量
     * @param messageRequestVo
     * @return
     */
    Long countStatue(MessageRequestVo messageRequestVo);
    /**
     * 删除站内信
     * @param record
     */
    void deleteById(MessageText record);


}