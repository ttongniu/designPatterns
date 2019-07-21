package com.java.ntt.concurrency.ntt013;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @ClassName T
 * @Description
 *  解决同样的问题更加高效的方法是 Atom***类
 *  Atom***类本身方法都是原子性的 但是不能保证多个方法调用是原子性的
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {

      ///* volatile */  int count=0;
       AtomicInteger count=new AtomicInteger(0);
    protected /*synchronized */   void m1() {
    System.out.println(Thread.currentThread().getName()+"m1 start...");
     for (int i = 0;i<10000;i++){
      count.incrementAndGet();
      }

      System.out.println(Thread.currentThread().getName()+"m1 end...");
  }



  /**
   * 未加上 synchronize  out： 96510
   *
   * 加上 synchronize out：100000
   * @param args
   */
  public static void main(String[] args) {
    List<Thread>  list = new ArrayList<>();


      T t = new T();
    for(int i=0;i<10;i++){
      list.add(new Thread(t::m1,"ntt--"+i));
    }
    list.forEach(thread -> thread.start());

    list.forEach(thread ->{
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    System.out.println(t.count);
  }

}


