package com.java.ntt.concurrency.ntt001;

/**
 * @ClassName T
 * @Description     synchronized  关键字   对某个对象进行加锁
 * @Author niutongtong
 * @Date 2019-07-20 15:40
 * @Version V1.0
 **/
public class T {

     private int count = 10;
     private Object o=new Object();

     public void m(){
       //任何线程要执行下面代码 必须先拿到o对象的锁
       synchronized (o){
         count--;
         System.out.println(Thread.currentThread().getName() +"Count =" +count);
       }

     }


}
