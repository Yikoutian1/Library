package com.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    private String sex;
    private String phone;
    private String adress;

}
