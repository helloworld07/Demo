package com.demeboot.shiro.dao;

import com.demeboot.shiro.entity.Role;
import com.demeboot.shiro.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: George
 * @date: 2020/8/4
 * @description:
 */
@Repository
public interface BaseDao {

    User findByName(@Param("name") String name);

    void saveRole(Role role);

    void saveUser(User user);
}
