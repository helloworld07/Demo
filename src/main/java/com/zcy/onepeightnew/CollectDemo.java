package com.zcy.onepeightnew;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @author: George
 * @date: 2019/9/26
 * @description:
 */
public class CollectDemo {
    public static void main(String[] args) {
        List<Dish> list = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        //输出卡路里最大值
        list.stream().max(Comparator.comparingInt(Dish::getCalories))
                .ifPresent(System.out::println);
        //汇总卡路里
        int sum = list.stream().collect(summingInt(Dish::getCalories));
        System.out.println(sum);
        //平均卡路里
        Double collect = list.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(collect);
        //返回汇总
        IntSummaryStatistics iss = list.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(iss);
        //拼接
        String collect1 = list.stream().map(Dish::getName).collect(joining("/"));
        System.out.println(collect1);
        //最大值
        Integer collect2 = list.stream().collect(reducing(0, Dish::getCalories, Integer::max));
        System.out.println(collect2);
        //分组
        Map<Dish.Type, List<Dish>> dishesByType = list.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
        //自定义分组
        Map<Dish.CaloricLevel, List<Dish>> dishesByCalories = list.stream().collect(
                groupingBy(d -> {
                    if (d.getCalories() <= 400) {
                        return Dish.CaloricLevel.DIET;
                    } else if (d.getCalories() <= 700) {
                        return Dish.CaloricLevel.NORMAL;
                    } else {
                        return Dish.CaloricLevel.FAT;
                    }
                })
        );
        System.out.println(dishesByCalories);
        //分区
        Map<Boolean, List<Dish>> map = list.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(map);
        //多重分区
        Map<Boolean, Map<Dish.Type, List<Dish>>> map1 = list.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(map1);
    }
}