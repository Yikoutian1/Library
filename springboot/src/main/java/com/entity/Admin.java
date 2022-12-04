package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2022/12/3 19:46
 * @Version 1.0
 */
@Data
public class Admin {
    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String password;
    /**处理数据格式*/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updatetime;
}
