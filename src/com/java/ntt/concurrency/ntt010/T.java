package com.java.ntt.concurrency.ntt010;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T
 * @Description
 *  synchronized 抛异常会释放锁 要注意异常的处理
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {
  private  int count = 0;

  protected synchronized   void m1() {
    System.out.println(Thread.currentThread().getName()+"m1 start...");
    while (true){
      count++;
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if(count==5){
        int i= 1/0;  //此处抛异常 锁会被释放  要想不被释放可以进行catch然后让循环继续
      }
      System.out.println(Thread.currentThread().getName() + "Count =" + count);
      System.out.println(Thread.currentThread().getName()+"m1 end...");
    }

  }



  /**
   * 结果：
   TT stat
   Thread-0m1 start...
   Thread-0Count =9
   Thread-0m1 end...
   TT send
   * @param args
   */
  public static void main(String[] args) {
     T t=new T();

       new Thread(t::m1,"ntt").start();
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    new Thread(t::m1,"ntt2").start();
  }

}


