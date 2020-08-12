package com.demeboot.shiro.entity;

import lombok.Data;

import java.util.List;

/**
 * @author: George
 * @date: 2020/8/4
 * @description:
 */


@Data
public class User {

    private Long id;
    private String name;
    private String password;
    private List<Role> roles;

}