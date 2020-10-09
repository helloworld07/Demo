package com.zcy.funcMethod;

import java.util.Date;

public class FuncMethodTest {
    public static void main(String[] args) {
        QueryPojo queryPojo = new QueryPojo();
        queryPojo.setStartDate(new Date(1577873124));
        queryPojo.setEndDate(new Date());
        CommonForeachExecute commonForeachExecute = ((pojo)->{
            System.out.println(pojo.getStartDate());
            System.out.println(pojo.getEndDate());
        });
        commonForeachExecute.foreachExecutor(queryPojo);
    }
}
