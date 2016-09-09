package com.qzw.modules.webservice.comment;

import com.qzw.modules.service.comment.ApartmentCommentService;
import com.qzw.modules.webservice.comment.vo.ApartmentCommentRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2016/8/19.
 */

@Component
@Path(value = "/comment")
public class ApartmentCommentController {

    @Autowired
    private ApartmentCommentService apartmentCommentService;

    /**
     * 添加评论
     */
    @POST
    @Path("/insertComment")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(ApartmentCommentRequestVo apartmentCommentRequestVo){
        apartmentCommentService.insert(apartmentCommentRequestVo);
    }

}
