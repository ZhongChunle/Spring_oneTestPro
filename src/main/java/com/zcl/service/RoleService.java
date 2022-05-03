package com.zcl.service;

import com.zcl.domain.Role;

import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：这是一个Service接口
 *
 * @author zhong
 * @date 2022-05-02 23:13
 */
public interface RoleService {
    /**
     * com.zcl.service.RoleService.list()
     * 角色查询列表
     *
     * @author zhong
     * @date 2022/5/3 8:44
     * @param
     * @return java.util.List<com.zcl.domain.Role>
     */
    public List<Role> list();

    /**
     * com.zcl.service.RoleService.save()
     * 角色新增接口
     *
     * @author zhong
     * @date 2022/5/3 8:45
     * @param  role
     * @return void
     */
    void save(Role role);
}
