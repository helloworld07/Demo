package com.zcy.hutool;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: George
 * @date: 2019/5/6
 * @description:
 */
public class ExcelTest {
    private static RowHandler createRowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowlist) {
                //输出每一行
                Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
            }
        };
    }

    public static void main(String[] args) {
//        ExcelUtil.read07BySax("C:/Users/adminis/Desktop/19年二季度项目计划.xlsx", 0, createRowHandler());

        Excel07SaxReader reader = new Excel07SaxReader(createRowHandler());
        Excel07SaxReader read = reader.read("C:/Users/adminis/Desktop/19年二季度项目计划.xlsx", 0);
        System.out.println(read);

    }
}