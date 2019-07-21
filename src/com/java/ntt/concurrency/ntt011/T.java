package com.java.ntt.concurrency.ntt011;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T
 * @Description
 *volatile 关键字 使一个变量在多个线程之间可见
 *AB线程 都用到了一个变量，Java 默认A 线程中保留一份copy ，B线程中修改了该变量，则A线程中未必知道。
 * 使用volatile 关键字会让所有线程都会读到变量的修改值。
 * 在下面代码中，flag是存放在堆内存的t对象中
 * 当线程t1开始运行的时候，会把flag值从内存中读取到t1线程工作区中。在运行过程中直接使用这个copy
 * 并不会每次去读取堆内存, 当主线程修改了flag值后。t1线程感知不到该值的变化。所以不会停止运行。
 *
 *使用volatile 会强制所有线程去堆内存中读取flag的值
 *
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {

     private  volatile boolean flag=true;

  protected synchronized   void m1() {
    System.out.println(Thread.currentThread().getName()+"m1 start...");
    while (flag){


    }
    System.out.println(Thread.currentThread().getName()+"m1 end...");
  }



  /**
   * 无volatile
   * 结果：
      nttm1 start...

   *有volatile
     结果：
    nttm1 start...
    nttm1 end...
   * @param args
   */
  public static void main(String[] args) {
      T t = new T();
      new Thread(t::m1,"ntt").start();

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
       t.flag=false;
  }

}


