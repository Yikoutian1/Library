package com.service;

import com.controller.request.BaseRequest;
import com.controller.request.UserPageRequest;
import com.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserService {
    List<User> list();

    Object page(BaseRequest userPageRequest);

    /**
     * add
     */
    void save(User user);

    PageInfo<User> getById(Integer id);

    void update(User user);

    void deleteById(Integer id);

}
