package com.qzw.modules.service.comment;

import com.mysql.fabric.xmlrpc.base.Data;
import com.qzw.modules.dao.comment.ApartmentCommentDao;
import com.qzw.modules.model.cemment.ApartmentComment;
import com.qzw.modules.webservice.comment.vo.ApartmentCommentRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2016/8/19.
 */
@Service
@Transactional
public class ApartmentCommentService {

    @Autowired
    private ApartmentCommentDao apartmentCommentDao;

    /**
     *添加评论
     * @param apartmentCommentRequestVo
     */
    public void insert(ApartmentCommentRequestVo apartmentCommentRequestVo){

        ApartmentComment apartmentComment=new ApartmentComment();
        apartmentComment.setTopicId(apartmentCommentRequestVo.getTopicId());
        apartmentComment.setContent(apartmentCommentRequestVo.getContent());
        apartmentComment.setFromUid(apartmentCommentRequestVo.getFromUid());
        apartmentComment.setCommentDate(apartmentCommentRequestVo.getCommentDate());
        apartmentCommentDao.insert(apartmentComment);

    }
}
