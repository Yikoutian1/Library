package com.service;

import com.controller.request.BaseRequest;
import com.entity.User;

import java.util.List;

public interface IUserService {
    List<User> list();

    Object page(BaseRequest userPageRequest);

    /**
     * add
     */
    void save(User user);

    User getById(Integer id);

    void update(User user);

    void deleteById(Integer id);

    void handleAccount(User user);
}
