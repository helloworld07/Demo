package com.zcy.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.zcy.disruptor.entity.LongEvent;

import java.util.concurrent.ThreadFactory;

/**
 * @author: George
 * @date: 2019/9/27
 * @description:
 */
public class LongEventMain {
    public static void main(String[] args) throws Exception {
        // 1生产者的线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "simpleThread");
            }
        };

        // 2RingBuffer生产工厂,初始化RingBuffer的时候使用
        EventFactory<LongEvent> factory = new EventFactory<LongEvent>() {
            @Override
            public LongEvent newInstance() {
                return new LongEvent();
            }
        };


        // 3阻塞策略
        BlockingWaitStrategy strategy = new BlockingWaitStrategy();

        // 4指定RingBuffer的大小
        int bufferSize = 16;

        // 通过以上4点创建disruptor，采用单生产者模式
        Disruptor<LongEvent> disruptor = new Disruptor(factory, bufferSize, threadFactory, ProducerType.SINGLE, strategy);

        // 处理Event的handler(消费者？)
        EventHandler<LongEvent> handler = new EventHandler<LongEvent>() {
            @Override
            public void onEvent(LongEvent longevent, long sequence, boolean endOfBatch) {
                System.out.println("LongEvent: " + longevent.getValue());
            }
        };

        // 设置EventHandler
        disruptor.handleEventsWith(handler);


        // 启动disruptor的线程
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        //循环插入递增值
        for (int l = 0; true; l++) {
            // 获取下一个可用位置的下标
            long sequence = ringBuffer.next();
            try {
                // 返回可用位置的元素
                LongEvent event = ringBuffer.get(sequence);
                // 设置该位置元素的值
                event.setValue(l);
            } finally {
                ringBuffer.publish(sequence);
            }
//            Thread.sleep(10);
        }
    }
}