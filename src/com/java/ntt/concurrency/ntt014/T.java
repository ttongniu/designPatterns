package com.java.ntt.concurrency.ntt014;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T
 * @Description
 *
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {

  Object o = new Object();

  protected    void m1() {

    synchronized (o){
      System.out.println(Thread.currentThread().getName()+"m1 start...");
      while (true){


      }
    }

  }



  /**
   *
   * @param args
   */
  public static void main(String[] args) {
      T t = new T();
      new Thread(t::m1,"ntt1").start();

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
     Thread t2 =  new Thread(t::m1,"ntt2");
     t.o =new Object(); //锁对象发生改变，线程t2获得执行  若注释掉这句话 线程t2将永远得不到执行

     t2.start();

  }

}


