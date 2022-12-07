package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2022/12/3 19:46
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String username;
    private Integer age;
    private Integer account;
    private Integer score;
    private String sex;
    private String phone;
    private String address;
    /**处理数据格式*/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updatetime;
    private boolean status;
}
