package com.controller;

import com.common.Result;
import com.controller.request.UserPageRequest;
import com.entity.User;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName controller
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2022/12/3 19:40
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 查询所有list
     * @return
     */
    @GetMapping("/list")
    public Result list() {
        List<User> users = userService.listUsers();
        return Result.success(users);
    }
    /**
     * 分页模糊查询
     */
    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest){
        /**
         * 通过userServices.page返回的对象进行对象返回
         */
        return Result.success(userService.page(userPageRequest));
    }
}
