package com.Mapper;

import com.controller.request.BaseRequest;
import com.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2022/12/3 19:50
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    /**
     * 可以通过注解写sql语句,或者去mybatis的mapper写原生sql
     * @return
     */
//    @Select("select * from user")
    List<User> list();
//    @Select("select * from user where name like concat('%',#{ name },'%') and phone like concat('%',#{ phone },'%')")
    List<User> listByCondition(BaseRequest userPageRequest);

    void save(User user);

    User getById(Integer id);

    void updateById(User user);

    void deleteById(Integer id);

    User getByUsername(String userNo);
}
