package com.java.ntt.concurrency.ntt004;

/**
 * @ClassName T
 * @Description  synchronized 关键字
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {
  private static int count = 10;

  public synchronized  static void m() {  // synchronized (T.class)
      count--;
      System.out.println(Thread.currentThread().getName() + "Count =" + count);
  }

  public synchronized  static void mm() {  //  因为是static 无法用synchronized (this) 静态方法不用new  可用synchronized (T.class)
    synchronized (T.class){
      count--;
      System.out.println(Thread.currentThread().getName() + "Count =" + count);
    }
  }


}
