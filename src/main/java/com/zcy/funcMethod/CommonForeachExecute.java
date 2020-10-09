package com.zcy.funcMethod;

import java.util.Date;

@FunctionalInterface
public interface CommonForeachExecute {
    /**
     * 执行方法
     *
     * @param pojo
     */
    void executor(QueryPojo pojo);

    /**
     * 默认执行方法通过pojo自定义的时间段来拉取数据
     *
     * @param pojo
     */
    default void foreachExecutor(QueryPojo pojo) {
        Date startDate = pojo.getStartDate();
        Date endDate = pojo.getEndDate();
        //增加时间 如果大于结束日期则等于结束日期
        Integer intervalTime = pojo.getIntervalTime();
        Date midDate;
        //遍历执行方法
        while (startDate.compareTo(endDate) <= 0) {
            //每次增加数据

            midDate = BiDateUtils.dateAddMinute(startDate, intervalTime);
            //中间时间
            pojo.setStartDate(startDate);
            //如果结束时间小于中间时间取结束时间
            pojo.setEndDate(midDate.compareTo(endDate) >= 0 ? endDate : midDate);
            //实际执行任务
            executor(pojo);
            //赋值给开始
            startDate = midDate;
        }
    }

}
