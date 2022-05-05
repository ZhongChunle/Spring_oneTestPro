package com.zcl.dao;

import com.zcl.domain.Role;

import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：dao层的接口
 *
 * @author zhong
 * @date 2022-05-02 23:18
 */
public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
