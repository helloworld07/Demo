package com.demeboot.shiro.entity;

import lombok.Data;

import java.util.List;

/**
 * @author: George
 * @date: 2020/8/4
 * @description:
 */
@Data
public class Role {
    private Long id;
    private String roleName;
    private User user;
    private List<Permission> permissions;
}