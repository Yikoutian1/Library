package com.controller.request;

import lombok.Data;

/**
 * @ClassName LoginRequest
 * @Description 用来放Admin Login的属性
 * @Author QiuLiHang
 * @DATE 2022/12/4 16:56
 * @Version 1.0
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
}
