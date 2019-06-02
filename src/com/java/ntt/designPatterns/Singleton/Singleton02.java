package com.java.ntt.designPatterns.Singleton;

/**
 * @ClassName Singleton02
 * @Description  Ⅱ 饿汉式-线程安全
 *
 *只需要对 getUniqueInstance() 方法加锁，那么在一个时间点只能有一个线程能够进入该方法，从而避免了实例化多次 uniqueInstance。
 *
 * 但是当一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，即使 uniqueInstance 已经被实例化了。这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用。
 *
 * @Author niutongtong
 * @Date 2019-06-02 18:22
 * @Version V1.0
 **/
public class Singleton02 {
  //私有构造器
  private  Singleton02(){

  }
  //私有静态变量
  private static  Singleton02 uniqueInstance=new Singleton02();


  //公有静态函数
  public static synchronized Singleton02 getUniqueInstance(){
    if(uniqueInstance==null) {
      uniqueInstance = new Singleton02();
    }
      return  uniqueInstance;
  }
}
