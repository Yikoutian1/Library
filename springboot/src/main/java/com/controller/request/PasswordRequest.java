package com.controller.request;

import lombok.Data;

/**
 * @ClassName PasswordRequest
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2022/12/5 20:34
 * @Version 1.0
 */
@Data
public class PasswordRequest {
    private String username;
    private String password;
    /**new password*/
    private String newPass;
}
