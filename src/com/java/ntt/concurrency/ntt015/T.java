package com.java.ntt.concurrency.ntt015;


/**
 * @ClassName T
 * @Description
 不要以字符串常量作为锁定对象
  在下面的例子中，s1 s2 其实锁定的是同一对象
 *
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {

   String s1 = "hello";
   String s2 = "hello";

  protected    void m1() {

    synchronized (s1){
      System.out.println(Thread.currentThread().getName()+"m1 start...");
      while (true){


      }
    }


  }

  protected    void m2() {

    synchronized (s2){
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

      new Thread(t::m2,"ntt2").start();
  }

}


