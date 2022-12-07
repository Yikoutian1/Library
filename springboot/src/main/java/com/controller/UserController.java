package com.controller;

import com.common.Result;
import com.controller.request.UserPageRequest;
import com.entity.User;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * post请求接口，新增会员
     * JSON转User对象
     */
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    /**
     * update by id
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success();
    }

    /**
     * delete by id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        userService.deleteById(id);
        return Result.success();
    }
    /**
     * 查询list 通过ID
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }
    /**
     * 查询所有list
     * @return
     */
    @GetMapping("/list")
    public Result list() {
        List<User> users = userService.list();
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

    /**
     * account
     * @param user
     * @return
     */
    @PostMapping("/account")
    public Result account(@RequestBody User user) {
        userService.handleAccount(user);
        return Result.success();
    }
}
