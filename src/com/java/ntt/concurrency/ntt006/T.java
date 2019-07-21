package com.java.ntt.concurrency.ntt006;

/**
 * @ClassName T
 * @Description  synchronized 关键字  m1加上锁（你蹲坑） m2未加锁（打扫阿姨） 当m1被锁住时（锁门蹲坑时） m2可以执行（打扫阿姨可以打扫卫生）
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T  {
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
  }

  private  void m2() {
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
   * m1m1 start...
   * m2m2 start...
   * m2m2 end...
   * m1Count =9
   * m1m1 end...
   * @param args
   */
  public static void main(String[] args) {
   T t=new T();
   new Thread(t::m1,"m1").start();
   new Thread(t::m2,"m2").start();
  }

}
