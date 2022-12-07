package com.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.Mapper.AdminMapper;
import com.controller.dto.LoginDTO;
import com.controller.request.BaseRequest;
import com.controller.request.LoginRequest;
import com.controller.request.PasswordRequest;
import com.entity.Admin;
import com.exception.ServiceException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.IAdminService;
import com.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    private static final String DEFAULT_PASS = "123";
    private static final String PASS_SALT = "qingge";

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
    public void save(Admin obj) {
        //Date date = new Date();
        // 转卡号处理,通过 hutol工具
        // IdUtil.fastSimpleUUID():英文+数字 hashCode()转数字,再abs
        //obj.setUsername(DateUtil.format(date, "yyyyMMdd") + Math.abs(IdUtil.fastSimpleUUID().hashCode()));
        //adminMapper.save(obj);
        // 默认密码 123
        if (StrUtil.isBlank(obj.getPassword())) {
            obj.setPassword(DEFAULT_PASS);
        }
        // 设置md5加密，加盐
        obj.setPassword(securePass(obj.getPassword()));
        try {
            adminMapper.save(obj);
        } catch (DuplicateKeyException e) {
            log.error("数据插入失败， username:{}", obj.getUsername(), e);
            throw new ServiceException("用户名重复");
        }
    }

    /**
     * by id
     * @param id
     * @return
     */
    @Override
    public Admin getById(Integer id) {
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
        Admin admin = null;
        try {
            admin = adminMapper.getByUsername(request.getUsername());
        } catch (Exception e) {
            log.error("根据用户名{} 查询出错", request.getUsername());
            throw new ServiceException("用户名错误");
        }
        if (admin == null) {
            throw new ServiceException("用户名或密码错误");
        }
        // 判断密码是否合法
        String securePass = securePass(request.getPassword());
        if (!securePass.equals(admin.getPassword())) {
            System.out.println(securePass.equals(admin.getPassword()));
            throw new ServiceException("用户名或密码错误");
        }
        if (!admin.isStatus()) {
            throw new ServiceException("当前用户处于禁用状态，请联系管理员");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin, loginDTO);

        // 生成token       -- copy --
        String token = TokenUtils.genToken(String.valueOf(admin.getId()), admin.getPassword());
        loginDTO.setToken(token);
        return loginDTO;
    }

    @Override
    public void changePass(PasswordRequest request) {
        // 注意 你要对新的密码进行加密
        request.setNewPass(securePass(request.getNewPass()));
        int count = adminMapper.updatePassword(request);
        if (count <= 0) {
            throw new ServiceException("修改密码失败");
        }
    }

    private String securePass(String password) {
        return SecureUtil.md5(password + PASS_SALT);
    }

}
