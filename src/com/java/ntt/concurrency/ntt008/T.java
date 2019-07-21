package com.java.ntt.concurrency.ntt008;

/**
 * @ClassName T
 * @Description  一个同步方法可以调用另一个同步方法 ，一个线程已经拥有了某个对象的锁，再次申请的时候仍然可以得到该对象的锁
 *
 * synchronized 获锁是可以重入的
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {
  private  int count = 10;

  private synchronized   void m1() {
    System.out.println(Thread.currentThread().getName()+"m1 start...");
      count--;
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + "Count =" + count);
    System.out.println(Thread.currentThread().getName()+"m1 end...");
    m2();
  }

  private synchronized void m2() {
    System.out.println(Thread.currentThread().getName()+"m2 start...");
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName()+"m2 end...");
  }


  /**
   * 结果：
   Thread-0m1 start...
   Thread-0Count =9
   Thread-0m1 end...
   Thread-0m2 start...
   Thread-0m2 end...
   * @param args
   */
  public static void main(String[] args) {
   T t=new T();
   new Thread(t::m1).start();
  }

}
