package com.qzw.modules.exception;

/**
 * 秒杀相关业务异常
 * Created by LJ on 2016/6/21.
 */
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
