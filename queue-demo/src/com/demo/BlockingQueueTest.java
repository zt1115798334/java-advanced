package com.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2019/7/18 14:13
 * description:
 */
public class BlockingQueueTest {

    public static class Basket {

        BlockingQueue<String> basket = new ArrayBlockingQueue<>(3);

        public void produce() throws InterruptedException {
            basket.put("An apple");
        }

        public String consume() throws InterruptedException {
            return basket.take();
        }


        public int getAppleSize() {
            return basket.size();
        }

    }

    public static void TestBasket() {


        final Basket basket = new Basket();

        class Produce implements Runnable {

            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("生产者准备生产苹果：" + System.currentTimeMillis());
                        basket.produce();

                        System.out.println("生产者生产苹果完毕：" + System.currentTimeMillis());
                        System.out.println("生产完后有苹果：" + basket.getAppleSize() + "个");
                        // 休眠300ms
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        class Consumer implements Runnable {

            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("消费者开始消费苹果：" + System.currentTimeMillis());
                        basket.consume();
                        System.out.println("消费者消费苹果完毕：" + System.currentTimeMillis());
                        System.out.println("消费完的有苹果" + basket.getAppleSize() + "个");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        Produce produce = new Produce();
        Consumer consumer = new Consumer();
        executorService.submit(produce);
        executorService.submit(consumer);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }

    public static void main(String[] args) {
        BlockingQueueTest.TestBasket();
    }
}
