package com.zcy;

import com.zcy.ApacheCommons.Person;
import lombok.SneakyThrows;

import java.util.TreeMap;
import java.util.concurrent.*;

/**
 * @author: George
 * @date: 2019/10/10
 * @description:
 */
public class Test {
    @SneakyThrows //lombok注解，抛出异常
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.HOURS, new LinkedBlockingQueue(), new ThreadPoolExecutor.CallerRunsPolicy());
        CompletionService<String> service = new ExecutorCompletionService<>(executor);
        CompletionService<String> service1 = new ExecutorCompletionService<>(threadPoolExecutor);
        for (int i = 0; i < 5; i++) {
            int seqNo = i;
            service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "HelloWorld-" + seqNo + "-" + Thread.currentThread().getName();
                }
            });
        }
        for (int j = 0; j < 5; j++) {
            System.out.println(service.take().get());
        }
    }

}