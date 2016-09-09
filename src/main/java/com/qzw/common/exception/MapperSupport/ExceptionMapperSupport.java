package com.qzw.common.exception.MapperSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by admin on 2016/6/24.
 */
@Provider
public class ExceptionMapperSupport implements ExceptionMapper<Throwable>{

    Log logger = LogFactory.getLog(ExceptionMapperSupport.class);

    @Override
    public Response toResponse(Throwable exception) {
//        log.info(exception.getMessage());
//        exception.printStackTrace();
//        AbstractException exception1= (AbstractException) exception;
//       // return Response.status(500).entity("{exceptionMsg:\""+exception1.getUserDefindExType()+".\"}").type("application/json").build();
//        return Response.status(500).entity("[{message:\""+exception1.getUserDefindExType()+".\"}]").type("application/json").build();

        logger.info(exception.getMessage());
        exception.printStackTrace();
        if(logger.isDebugEnabled())
        {

            exception.printStackTrace();
        }
        if(exception instanceof AbstractException ) {
            AbstractException exception1 = (AbstractException) exception;
            return Response.status(500).entity("[{message:\""+exception1.getUserDefindExType()+".\"}]").type("application/json").build();
        }
        return Response.status(500).entity("[{message:\""+"系统异常"+".\"}]").type("application/json").build();

    }
}

