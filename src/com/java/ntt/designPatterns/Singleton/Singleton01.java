package com.java.ntt.designPatterns.Singleton;

/**
 * @ClassName Singleton01
 * @Description  Ⅰ 懒汉式-线程不安全
 *
 * 以下实现中，私有静态变量 uniqueInstance 被延迟实例化，这样做的好处是，如果没有用到该类，那么就不会实例化 uniqueInstance，从而节约资源。
 *
 * 这个实现在多线程环境下是不安全的，如果多个线程能够同时进入 if (uniqueInstance == null) ，并且此时 uniqueInstance 为 null，那么会有多个线程执行 uniqueInstance = new Singleton(); 语句，这将导致实例化多次 uniqueInstance。
 *
 *
 * @Author niutongtong
 * @Date 2019-06-02 18:14
 * @Version V1.0
 **/
public class Singleton01 {

  //私有构造函数
  private Singleton01 (){

  }
  //私有静态变量
  private static Singleton01 UniqueInstance;
  //公有静态函数
  public static Singleton01 getUniqueInstance(){
    if(UniqueInstance == null){
      UniqueInstance = new Singleton01();
    }
    return UniqueInstance;
  }
}
