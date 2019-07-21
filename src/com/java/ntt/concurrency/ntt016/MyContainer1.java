package com.java.ntt.concurrency.ntt016;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyContainer1
 * @Description
 *
 * @Author niutongtong
 * @Date 2019-07-21 17:23
 * @Version V1.0
 **/
public class MyContainer1 {

 volatile List list = new ArrayList<>();

  public   void add(Object o){
    list.add(o);
  }

   public synchronized int size(){
    return  list.size();
   }

  public static void main(String[] args) {
     MyContainer1 myContainer1=new MyContainer1();

     new Thread(()->{
        for(int i=0;i<10;i++){
          myContainer1.add(new Object());
          System.out.println("add"+i);
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
     }).start();

     new Thread(() -> {
      while (true){
       if(myContainer1.size()==5) {
         break;
       }
      }
     }).start();
  }

}
