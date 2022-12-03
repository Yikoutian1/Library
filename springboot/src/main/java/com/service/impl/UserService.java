package com.service.impl;

import com.Mapper.UserMapper;
import com.controller.request.UserPageRequest;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description 实现IUserService
 * @Author QiuLiHang
 * @DATE 2022/12/3 19:54
 * @Version 1.0
 */
@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> listUsers() {
        /**
         * 有可能会出问题try catch
         */
        return userMapper.list();
    }
    /**
     * 模糊查询
     * @return
     */
    @Override
    public Object page(UserPageRequest userPageRequest) {
        // 分页插件
        PageHelper.startPage(userPageRequest.getPageNum(),userPageRequest.getPageSize());
        /**
         * 获取name和page信息
         */
        //String name = userPageRequest.getName();
        //String phone = userPageRequest.getPhone();
        List<User> users = userMapper.listByCondition(userPageRequest);
        return new PageInfo(users);
    }

}
