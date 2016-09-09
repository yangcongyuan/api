package com.qzw.modules.service.msg;

import com.qzw.common.utils.DateUtils;
import com.qzw.modules.dao.msg.MessageDao;
import com.qzw.modules.dao.msg.MessageTextDao;
import com.qzw.modules.model.msg.Message;
import com.qzw.modules.model.msg.MessageText;
import com.qzw.modules.webservice.msg.vo.MessageRequestVo;
import com.qzw.modules.webservice.msg.vo.MessageResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/8/16.
 */
@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private MessageTextDao messageTextDao;

    /**
     * 添加站内信
     * @param messageRequestVo
     */
    public void insert(MessageRequestVo messageRequestVo){
        MessageText messageText=new MessageText();
        messageText.setSendId(messageRequestVo.getSendId());
        messageText.setMessage(messageRequestVo.getMessage());
        messageText.setMessageType(1);
        messageText.setTitle(messageRequestVo.getTitle());
        messageText.setPostDate(new Date());
        messageText.setGroupId(0);
        messageTextDao.insert(messageText);

        Message message=new Message();
        message.setRecId(messageRequestVo.getRecId());
        message.setMessageId(messageText.getId());
        message.setStatue(0);
        messageDao.insert(message);
    }

    /**
     * 修改站内信状态
     * @param messageRequestVo
     */
    public void updateById(MessageRequestVo messageRequestVo){
        Message message=new Message();
        message.setId(messageRequestVo.getId());
        message.setStatue(messageRequestVo.getStatue());
        messageDao.updateById(message);
    }

    /**
     * 获取站内信列表
     * @param messageRequestVo
     * @return
     */
    public List<MessageResponseVo> statueList(MessageRequestVo messageRequestVo){

        List<MessageResponseVo> list=messageTextDao.statueList(messageRequestVo);
        for (MessageResponseVo vo:list) {
            if(vo.getPostDate()!=null){
                vo.setMessageData(DateUtils.formatDate(vo.getPostDate(),null));
            }
        }
        return list;
    }

    /**
     * 获取站内信的数量
     * @param messageRequestVo
     * @return
     */
    public Long countStatue(MessageRequestVo messageRequestVo){
        return messageTextDao.countStatue(messageRequestVo);
    }

    /**
     * 删除站内信
     * @param messageRequestVo
     */
    public void deleteById(MessageRequestVo messageRequestVo){
            Message message=new Message();
            message.setMessageId(messageRequestVo.getMessageId());
            messageDao.deleteById(message);
            MessageText messageText=new MessageText();
            messageText.setId(messageRequestVo.getMessageId());
            messageTextDao.deleteById(messageText);
    }
}
