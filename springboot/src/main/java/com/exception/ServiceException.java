package com.exception;

/**
 * @ClassName ServiceException
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2022/12/4 19:15
 * @Version 1.0
 */

public class ServiceException extends RuntimeException{

    private String code;

    public String getCode() {
        return code;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }

}
