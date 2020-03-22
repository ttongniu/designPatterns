package com.java.ntt.base;
import java.util.concurrent.BrokenBarrierException;
import	java.util.concurrent.TimeUnit;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("发车了 老司机");
        });

        Random random = new Random();
        for(int i=0;i<3;i++){
            new Thread(()->{
                int time = random.nextInt(5);
                System.out.println(Thread.currentThread().getName() +"在路上耗时"+time+"秒");
                try {
                    TimeUnit.SECONDS.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"到达车站了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
