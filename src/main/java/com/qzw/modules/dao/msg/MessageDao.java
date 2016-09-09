package com.qzw.modules.dao.msg;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.msg.Message;
import com.qzw.modules.model.msg.MessageText;

@MyBatisDao
public interface MessageDao {

    /**
     * 添加收件人
     * @param record
     * @return
     */
    int insert(Message record);
    /**
     * 修改站内信状态
     * @param record
     */
    void updateById(Message record);
    /**
     * 删除站内信
     * @param record
     */
    void deleteById(Message record);
}