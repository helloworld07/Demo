package com.demeboot.shiro.entity;

import lombok.Data;

/**
 * @author: George
 * @date: 2020/8/4
 * @description:
 */
@Data
public class Permission {
    private Long id;
    private String permission;
    private Role role;
}