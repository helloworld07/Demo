package com.zcy.Guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Set;

/**
 * @author: George
 * @date: 2019/9/4
 * @description: table一个简单的三值表
 */
public class TableTest {
    public static void main(String[] args) {
        HashBasedTable<String, String, Integer> table = HashBasedTable.create();
        table.put("jack", "mid", 100);
        table.put("tony", "mid", 60);
        table.put("tony", "carry", 80);
        table.put("cindy", "support", 90);
        System.out.println(table);
        Set<Table.Cell<String, String, Integer>> cells = table.cellSet();
        for (Table.Cell<String, String, Integer> cell : cells) {
            System.out.println(cell.getColumnKey() + cell.getRowKey() + cell.getValue());
        }
        System.out.println(table.row("tony"));
        System.out.println(table.values());
        System.out.println(table.rowKeySet());
        System.out.println(table.columnKeySet());
    }
}