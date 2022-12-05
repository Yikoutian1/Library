package com.Mapper;

import com.controller.request.BaseRequest;
import com.controller.request.LoginRequest;
import com.controller.request.PasswordRequest;
import com.entity.Admin;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2022/12/3 19:50
 * @Version 1.0
 */
@Mapper
public interface AdminMapper {
    /**
     * 可以通过注解写sql语句,或者去mybatis的mapper写原生sql
     * @return
     */
    List<Admin> list();
    /**多态**/
    List<Admin> listByCondition(BaseRequest userPageRequest);

    void save(Admin admin);

    Admin getById(Integer id);

    void updateById(Admin admin);

    void deleteById(Integer id);

//    Admin getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    Admin getByUsername(String username);


    Admin getByUsernameAndPassword(LoginRequest request);

    int updatePassword(PasswordRequest request);
}
