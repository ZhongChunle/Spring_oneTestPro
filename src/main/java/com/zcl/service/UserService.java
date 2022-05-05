package com.zcl.service;

import com.zcl.domain.User;

import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：
 *
 * @author zhong
 * @date 2022-05-03 9:14
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);
}
