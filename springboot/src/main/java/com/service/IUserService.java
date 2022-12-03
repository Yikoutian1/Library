package com.service;

import com.controller.request.UserPageRequest;
import com.entity.User;

import java.util.List;

public interface IUserService {
    List<User> listUsers();

    Object page(UserPageRequest userPageRequest);
}
