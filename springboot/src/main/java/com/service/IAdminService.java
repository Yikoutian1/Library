package com.service;

import com.controller.dto.LoginDTO;
import com.controller.request.BaseRequest;
import com.controller.request.LoginRequest;
import com.controller.request.PasswordRequest;
import com.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAdminService {
    List<Admin> list();

    PageInfo<Admin> page(BaseRequest userPageRequest);

    /**
     * add
     */
    void save(Admin admin);

    /**
     * by id
     * @param id
     * @return
     */
    Admin getById(Integer id);

    void update(Admin admin);

    void deleteById(Integer id);

    LoginDTO login(LoginRequest request);

    void changePass(PasswordRequest request);
}
