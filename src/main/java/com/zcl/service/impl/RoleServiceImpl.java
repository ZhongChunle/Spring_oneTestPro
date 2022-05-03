package com.zcl.service.impl;

import com.zcl.dao.RoleDao;
import com.zcl.domain.Role;
import com.zcl.service.RoleService;

import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：实现RoleService接口的实现类
 *
 * @author zhong
 * @date 2022-05-02 23:14
 */
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * com.zcl.service.impl.RoleServiceImpl.list()
     * 重新接口方法，调用dao层的代码查询角色数据，返回列表集合
     *
     * @author zhong
     * @date 2022/5/2 23:17
     * @param
     * @return java.util.List<com.zcl.domain.Role>
     */
    @Override
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    /**
     * com.zcl.service.impl.RoleServiceImpl.save()
     * 新增角色方法实现
     *
     * @author zhong
     * @date 2022/5/3 8:37
     * @param  role
     * @return void
     */
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
