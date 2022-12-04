package com.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.Mapper.AdminMapper;
import com.common.Result;
import com.controller.dto.LoginDTO;
import com.controller.request.BaseRequest;
import com.controller.request.LoginRequest;
import com.entity.Admin;
import com.exception.ServiceException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.IAdminService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
@Slf4j
@Service
public class AdminService implements IAdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> list() {
        /**
         * 有可能会出问题try catch
         */
        return adminMapper.list();
    }

    /**
     * 模糊查询
     *
     * @return
     */
    @Override
    public PageInfo<Admin> page(BaseRequest adminPageRequest) {
        // 分页插件
        PageHelper.startPage(adminPageRequest.getPageNum(), adminPageRequest.getPageSize());
        /**
         * 获取name和page信息
         */
        // String name = adminPageRequest.getName();
        // String phone = adminPageRequest.getPhone();

        List<Admin> admin = adminMapper.listByCondition(adminPageRequest);
        return new PageInfo<>(admin);
    }

    /**
     * save
     */
    @Override
    public void save(Admin admin) {
        Date date = new Date();
        // 转卡号处理,通过 hutol工具
        // IdUtil.fastSimpleUUID():英文+数字 hashCode()转数字,再abs
        admin.setUsername(DateUtil.format(date, "yyyyMMdd") + Math.abs(IdUtil.fastSimpleUUID().hashCode()));
        adminMapper.save(admin);
    }

    /**
     * by id
     *
     * @param id
     * @return
     */
    @Override
    public PageInfo<Admin> getById(Integer id) {
        return adminMapper.getById(id);
    }

    /**
     * update by id
     * 以及附带修改时间
     *
     * @param admin
     */
    @Override
    public void update(Admin admin) {
        admin.setUpdatetime(new Date());
        adminMapper.updateById(admin);
    }

    /**
     * delete by id
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    /**
     * login
     *
     * @param request
     */
    @Override
    public LoginDTO login(LoginRequest request) {
        Admin admin = adminMapper.getByUsernameAndPassword(request);
        if(admin == null){
            throw new ServiceException("用户名或密码错误");
        }
        // admin 转 DTO(使用springboot自带的BeanUtils)
        LoginDTO loginDTO = new LoginDTO();
        // 仅仅复制名字相同的
        BeanUtils.copyProperties(admin, loginDTO);
        return loginDTO;
    }
}
