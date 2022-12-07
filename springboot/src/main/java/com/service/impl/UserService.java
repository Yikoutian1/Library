package com.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.Mapper.UserMapper;
import com.controller.request.BaseRequest;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<User> list() {
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
    public PageInfo<User> page(BaseRequest userPageRequest) {
        // 分页插件
        PageHelper.startPage(userPageRequest.getPageNum(),userPageRequest.getPageSize());
        /**
         * 获取name和page信息
         */
        // String name = userPageRequest.getName();
        // String phone = userPageRequest.getPhone();

        List<User> users = userMapper.listByCondition(userPageRequest);
        return new PageInfo<>(users);
    }

    /**
     * save
     */
    @Override
    public void save(User user) {
        Date date = new Date();
        // 转卡号处理,通过 hutol工具
        // IdUtil.fastSimpleUUID():英文+数字 hashCode()转数字,再abs
        user.setUsername(DateUtil.format(date,"yyyyMMdd") + Math.abs(IdUtil.fastSimpleUUID().hashCode()));
        userMapper.save(user);
    }

    /**
     * by id
     *
     * @param id
     * @return
     */
    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    /**
     * update by id
     * 以及附带修改时间
     * @param user
     */
    @Override
    public void update(User user) {
        user.setUpdatetime(new Date());
        userMapper.updateById(user);
    }

    /**
     * delete by id
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void handleAccount(User user) {
        Integer score = user.getScore();
        if (score == null) {
            return;
        }
        Integer id = user.getId();
        User dbUser = userMapper.getById(id);
        dbUser.setAccount(dbUser.getAccount() + score);
        userMapper.updateById(dbUser);
    }

}
