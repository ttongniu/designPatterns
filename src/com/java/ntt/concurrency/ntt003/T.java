package com.java.ntt.concurrency.ntt003;

/**
 * @ClassName T
 * @Description  synchronized 关键字
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {
  private int count = 10;

  public synchronized void m() {  // synchronized (this)
      count--;
      System.out.println(Thread.currentThread().getName() + "Count =" + count);
  }
}
