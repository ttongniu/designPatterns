package com.java.ntt.concurrency.ntt012;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName T
 * @Description
 *volatile 关键字 使一个变量在多个线程之间可见
 *AB线程 都用到了一个变量，Java 默认A 线程中保留一份copy ，B线程中修改了该变量，则A线程中未必知道。
 * 使用volatile 关键字会让所有线程都会读到变量的修改值。
 *
 *使用volatile 保证可见性 但是不保证原子性
 *
 * synchronized 保证可见性 也保证原子性
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T {

       volatile   int count=0;

    protected synchronized    void m1() {
    System.out.println(Thread.currentThread().getName()+"m1 start...");
     for (int i = 0;i<10000;i++){
       count ++;
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


