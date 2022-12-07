package com.controller.request;

import lombok.Data;
/**
 * @ClassName CategoryPageRequest
 * @Description 种类
 * @Author QiuLiHang
 * @DATE 2022/12/5 23:31
 * @Version 1.0
 */
@Data
public class CategoryPageRequest extends BaseRequest{
    /**name*/
    private String name;
}
