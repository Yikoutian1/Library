package com.controller.request;

import lombok.Data;
/**
 * @ClassName BorrowPageRequest
 * @Description 借书
 * @Author QiuLiHang
 * @DATE 2022/12/5 23:31
 * @Version 1.0
 */
@Data
public class BorrowPageRequest extends BaseRequest{
    /**借的书名*/
    private String bookName;
    /**书是否被借*/
    private String bookNo;
    /**借的人*/
    private String userName;
}
