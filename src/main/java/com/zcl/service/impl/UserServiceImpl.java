package com.zcl.service.impl;

import com.zcl.dao.RoleDao;
import com.zcl.dao.UserDao;
import com.zcl.domain.Role;
import com.zcl.domain.User;
import com.zcl.service.UserService;

import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：用户列表接口实现类
 *
 * @author zhong
 * @date 2022-05-03 9:15
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 用于查询多个角色列表
     * */
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        // 封装userList中的List<Role> roles角色数据
        for (User user : userList) {
            // 获得user.id数据
            Long id = user.getId();
            // 将id作为参数 查询当前的userId对应的Role集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    /**
     * com.zcl.service.impl.UserServiceImpl.save()
     * 用户信息新增
     *
     * @author zhong
     * @date 2022/5/4 8:08
     * @param  user
     * @param  roleIds
     * @return void
     */
    @Override
    public void save(User user, Long[] roleIds) {
        // 1、向sys_user表中存储数据
        Long userId = userDao.save(user);
        // 2、向sys_user_role关系表中存储多条数据
        userDao.saveUserRolel(userId,roleIds);
    }

    /**
     * com.zcl.service.impl.UserServiceImpl.del()
     * 根据用户id执行删除
     *
     * @author zhong
     * @date 2022/5/5 13:11
     * @param  userId
     * @return void
     */
    @Override
    public void del(Long userId) {
        // 1、根据id删除中间表
        userDao.delUserRole(userId);
        // 2、根据id删除用户信息
        userDao.del(userId);
    }
}
