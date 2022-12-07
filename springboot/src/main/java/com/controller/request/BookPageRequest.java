package com.controller.request;

import lombok.Data;

/**
 * @ClassName BookPageRequest
 * @Description 书状态
 * @Author QiuLiHang
 * @DATE 2022/12/5 23:31
 * @Version 1.0
 */
@Data
public class BookPageRequest extends BaseRequest{
    /**
     * 书是否被借
     */
    private String booKno;
    /**
     * 书名
     */
    private String name;
}
