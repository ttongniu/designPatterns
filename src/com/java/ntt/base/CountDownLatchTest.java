package com.java.ntt.base;
import	java.util.concurrent.TimeUnit;
import	java.util.Random;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(3);
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                int time = random.nextInt(5);
                System.out.println(Thread.currentThread().getName() + "在路上耗时" + time + "秒");
                try {
                    TimeUnit.SECONDS.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "到达车站了");
                count.countDown();
            }).start();

        }
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("老司机，发车");
    }

}
