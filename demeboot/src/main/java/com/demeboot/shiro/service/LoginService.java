package com.demeboot.shiro.service;

import com.demeboot.shiro.entity.Role;
import com.demeboot.shiro.entity.User;

/**
 * @author: George
 * @date: 2020/8/4
 * @description:
 */
public interface LoginService {
    User addUser(User user);

    Role addRole(Role role);

    User findByName(String name);
}
