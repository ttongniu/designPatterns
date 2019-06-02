package com.java.ntt.designPatterns.Singleton;

/**
 * @ClassName Singleton03
 * @Description  Ⅳ 双重校验锁-线程安全
 *
 *uniqueInstance 只需要被实例化一次，之后就可以直接使用了。加锁操作只需要对实例化那部分的代码进行，只有当 uniqueInstance 没有被实例化时，才需要进行加锁。
 *
 * 双重校验锁先判断 uniqueInstance 是否已经被实例化，如果没有被实例化，那么才对实例化语句进行加锁。
 * 考虑下面的实现，也就是只使用了一个 if 语句。在 uniqueInstance == null 的情况下，如果两个线程都执行了 if 语句，那么两个线程都会进入 if 语句块内。虽然在 if 语句块内有加锁操作，但是两个线程都会执行 uniqueInstance = new Singleton(); 这条语句，只是先后的问题，那么就会进行两次实例化。因此必须使用双重校验锁，
 *
 *
 * uniqueInstance 采用 volatile 关键字修饰也是很有必要的， uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
 *
 * 为 uniqueInstance 分配内存空间
 * 初始化 uniqueInstance
 * 将 uniqueInstance 指向分配的内存地址
 * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
 *
 * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
 * @Author niutongtong
 * @Date 2019-06-02 18:27
 * @Version V1.0
 **/
public class Singleton03 {

  private Singleton03(){


  }

  private static volatile Singleton03 uniqueInstance = new Singleton03();

  public static Singleton03 getUniqueInstance(){
     if(uniqueInstance == null){
         synchronized (Singleton03.class){
           if(uniqueInstance == null){
             uniqueInstance = new Singleton03();
           }
         }
     }
     return  uniqueInstance;
  }

}
