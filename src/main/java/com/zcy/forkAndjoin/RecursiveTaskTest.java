package com.zcy.forkAndjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

/**
 * @author: George
 * @date: 2019/9/24
 * @description: 累加计算1至100的值，有返回值RecursiveTask
 */
public class RecursiveTaskTest {
    // 定义最小区间为10
    private final static int MAX_THRESHOLD = 10;

    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        long currentTimeMillis = System.currentTimeMillis();
        //submit是异步执行，只有在Future调用get的时候会阻塞
        ForkJoinTask<Integer> future = forkJoinPool.submit(new CalculateRecursiveTask(1, 11));
        System.out.println(System.currentTimeMillis()-currentTimeMillis);
        long currentTimeMillis1 = System.currentTimeMillis();
        //invoke是同步执行，调用之后需要等待任务完成，才能执行后面的代码
        Integer invoke = forkJoinPool.invoke(new CalculateRecursiveTask(1, 11));
        System.out.println(System.currentTimeMillis()-currentTimeMillis1);
        try {
            Integer result = future.get();
            System.out.println(result);
            System.out.println(invoke);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static class CalculateRecursiveTask extends RecursiveTask<Integer> {
        // 起始
        private int start;
        // 结束
        private int end;

        public CalculateRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            // 如果起始和结束范围小于我们定义的区间范围，则直接计算
            if ((end - start) <= MAX_THRESHOLD) {
                return IntStream.rangeClosed(start, end).sum();
            } else {
                // 否则，将范围一分为二，分成两个子任务
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int middle = (start + end) / 2;
                CalculateRecursiveTask leftTask = new CalculateRecursiveTask(start, middle);
                CalculateRecursiveTask rightTask = new CalculateRecursiveTask(middle + 1, end);
                // 执行子任务
//                leftTask.fork();
//                rightTask.fork();
                invokeAll(leftTask,rightTask);

                // 汇总子任务
                return leftTask.join() + rightTask.join();
            }
        }
    }
}