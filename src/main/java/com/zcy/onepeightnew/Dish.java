package com.zcy.onepeightnew;

import lombok.Data;

/**
 * @author: George
 * @date: 2019/9/26
 * @description:
 */
@Data
public class Dish {
    public enum Type {MEAT, FISH, OTHER}
    public enum CaloricLevel { DIET, NORMAL, FAT }

    /** 食物名称 */
    private final String name;
    /** 是否是素食 */
    private final boolean vegetarian;
    /** 卡路里 */
    private final int calories;
    /** 类型：肉，海鲜，其他 */
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}