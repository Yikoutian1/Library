package com.controller.request;

import lombok.Data;

/**
 * @ClassName UserPageRequest
 * @Description TODO 查询类
 * @Author QiuLiHang
 * @DATE 2022/12/3 21:46
 * @Version 1.0
 */
@Data
public class AdminPageRequest extends BaseRequest{
    /**搜索名称*/
    private String username;
    /**搜索号码*/
    private String phone;
    /**email*/
    private String email;
}
