package com.java.ntt.concurrency.ntt009;

/**
 * @ClassName T
 * @Description  一个同步方法可以调用另一个同步方法 ，一个线程已经拥有了某个对象的锁，再次申请的时候仍然可以得到该对象的锁
 *
 * synchronized 获锁是可以重入的
 * 这里是继承中有可能发生的情景，子类调用父类的同步方法
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {
  private  int count = 10;

  protected synchronized   void m1() {
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
   TT tt=new TT();
   new Thread(tt::m2).start();
  }

}


class TT extends T{

    public synchronized void m2(){
      System.out.println("TT stat");
      super.m1();
      System.out.println("TT send");
    }

  }