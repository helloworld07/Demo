package com.zcy.disruptor.entity;

import lombok.Data;

/**
 * @author: George
 * @date: 2019/9/29
 * @description: 事件(Event)就是通过 Disruptor 进行交换的数据类型
 */
@Data
public class LongEvent
{
    private int value;
}