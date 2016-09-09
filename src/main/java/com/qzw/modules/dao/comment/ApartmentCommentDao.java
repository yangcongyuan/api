package com.qzw.modules.dao.comment;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.cemment.ApartmentComment;


@MyBatisDao
public interface ApartmentCommentDao {
    /**
     * 添加评论
     * @param record
     * @return
     */
    int insert(ApartmentComment record);

    ApartmentComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApartmentComment record);

    int updateByPrimaryKey(ApartmentComment record);
}