package com.Mapper;

import com.controller.request.UserPageRequest;
import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
//    @Select("select * from user")
    List<User> list();
//    @Select("select * from user where name like concat('%',#{ name },'%') and phone like concat('%',#{ phone },'%')")
    List<User> listByCondition(UserPageRequest userPageRequest);
}
