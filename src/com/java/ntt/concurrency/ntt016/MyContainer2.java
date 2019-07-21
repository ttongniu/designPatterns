package com.java.ntt.concurrency.ntt016;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyContainer1
 * @Description
 *   wait 释放锁  notify notifyALL 不会释放锁
 * @Author niutongtong
 * @Date 2019-07-21 17:23
 * @Version V1.0
 **/
public class MyContainer2 {

  List list = new ArrayList<>();

  public   void add(Object o){
    list.add(o);
  }

   public synchronized int size(){
    return  list.size();
   }

  public static void main(String[] args) {
     MyContainer2 myContainer1=new MyContainer2();
     Object lock =new Object();

    new Thread(() -> {
      System.out.println("t2 start!");
      synchronized (lock) {
        while (myContainer1.size() != 5) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("t2 end");
          lock.notifyAll();
        }

      }
    },"T2").start();

     new Thread(()->{
       synchronized (lock){
         System.out.println("t1 start");

         for(int i=0;i<10;i++){
           myContainer1.add(new Object());
           System.out.println("add"+i);
           try {
             TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
             e.printStackTrace();
           }
           if(i==4){
             lock.notifyAll();
             try {
               lock.wait();
             } catch (InterruptedException e) {
               e.printStackTrace();
             }
           }
         }
       }

     },"T1").start();


  }

}
