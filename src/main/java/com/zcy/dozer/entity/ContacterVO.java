package com.zcy.dozer.entity;


import lombok.Data;

@Data
public class ContacterVO {
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别（0，女；1，男）
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age ;

    /**
     * 电话
     */
    private  String phone;

    /**
     * 地址
     */
    private String location;
}
