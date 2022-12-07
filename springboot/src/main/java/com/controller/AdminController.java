package com.controller;

import com.common.Result;
import com.controller.dto.LoginDTO;
import com.controller.request.AdminPageRequest;
import com.controller.request.LoginRequest;
import com.controller.request.PasswordRequest;
import com.entity.Admin;
import com.service.IAdminService;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;

    /**
     * login
     * @return
     * TIPS:去掉了@RequestBody就不会出现400问题(@RequestBody LoginRequest request)->(LoginRequest request)
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        LoginDTO loginDTO = adminService.login(loginRequest);
        return Result.success(loginDTO);
    }
    /**
     * post请求接口，新增会员
     * JSON转User对象
     */
    @PostMapping("/save")
    public Result save(@RequestBody Admin obj){
        adminService.save(obj);
        return Result.success();
    }

    /**
     * update by id
     * @param obj
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Admin obj){
        adminService.update(obj);
        return Result.success();
    }

    /**
     * 密码
     * @param request
     * @return
     */
    @PutMapping("/password")
    public Result password(@RequestBody PasswordRequest request) {
        adminService.changePass(request);
        return Result.success();
    }
    /**
     * delete by id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        adminService.deleteById(id);
        return Result.success();
    }
    /**
     * select list by ID
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin obj = adminService.getById(id);
        return Result.success(obj);
    }
    /**
     * select all list
     * @return
     */
    @GetMapping("/list")
    public Result list() {
        List<Admin> users = adminService.list();
        return Result.success(users);
    }
    /**
     * 分页模糊查询
     */
    @GetMapping("/page")
    public Result page(AdminPageRequest adminPageRequest){
        /**
         * 通过adminServices.page返回的对象进行对象返回
         */
        return Result.success(adminService.page(adminPageRequest));
    }
}
