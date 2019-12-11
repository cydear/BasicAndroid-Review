package com.basic.android.thread;

import java.util.PriorityQueue;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-11-21 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class BlockingQueueCode {
    private static int queueSize = 10;
    private static PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        try {
                            queue.wait();
                            System.out.println("队列满，等待有空余空间");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待有数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                }
            }
        }
    }
}
