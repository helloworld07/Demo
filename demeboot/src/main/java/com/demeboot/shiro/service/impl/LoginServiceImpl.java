package com.demeboot.shiro.service.impl;

import com.demeboot.shiro.entity.Role;
import com.demeboot.shiro.dao.BaseDao;
import com.demeboot.shiro.entity.Permission;
import com.demeboot.shiro.entity.User;
import com.demeboot.shiro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: George
 * @date: 2020/8/4
 * @description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public User addUser(User user) {
        baseDao.saveUser(user);
        return user;
    }

    @Override
    public Role addRole(Role role) {
        User user = baseDao.findByName(role.getUser().getName());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setPermission("create");
        permission1.setRole(role);
        Permission permission2 = new Permission();
        permission2.setPermission("update");
        permission2.setRole(role);
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
        baseDao.saveRole(role);
        return role;
    }

    @Override
    public User findByName(String name) {
        return baseDao.findByName(name);
    }
}