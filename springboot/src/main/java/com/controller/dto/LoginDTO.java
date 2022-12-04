package com.controller.dto;

import lombok.Data;

/**
 * @ClassName LoginDTO
 * @Description Login数据返回类
 * @Author QiuLiHang
 * @DATE 2022/12/4 16:59
 * @Version 1.0
 */
@Data
public class LoginDTO {
    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String token;
}
