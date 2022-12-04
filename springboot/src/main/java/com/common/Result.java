package com.common;

import lombok.Data;

/**
 * @ClassName Result
 * @Description 统一后台返回数据结果包装
 * @Author QiuLiHang
 * @DATE 2022/12/3 21:19
 * @Version 1.0
 */
@Data
public class Result {
    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "-1";

    private String code;
    private Object data;
    private String msg;

    /**
     * 没有设置的返回
     * @param
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }

    /**
     * 有设置数据的返回
     * @param data
     * @return
     */
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    /**
     * error
     * @return
     */
    public static Result error(String msg, String message){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }
}
