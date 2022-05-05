package com.zcl.dao;

import com.zcl.domain.User;

import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：
 *
 * @author zhong
 * @date 2022-05-03 9:16
 */
public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRolel(Long id, Long[] roleIds);

    void delUserRole(Long userId);

    void del(Long userId);
}
