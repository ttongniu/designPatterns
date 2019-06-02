package com.java.ntt.designPatterns.Singleton;

/**
 * @ClassName Singleton04
 * @Description  Ⅴ 静态内部类实现
 *
 *当 Singleton 类加载时，静态内部类 SingletonHolder 没有被加载进内存。只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时 SingletonHolder 才会被加载，此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。
 *
 * 这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
 *
 * @Author niutongtong
 * @Date 2019-06-02 18:34
 * @Version V1.0
 **/
public class Singleton04 {
   //私有化构造器
  private Singleton04(){

  }
  private static class SingletonHolder{
    private static final  Singleton04 INSTANCE = new Singleton04();
  }

  public static  Singleton04 getUniqueInstance(){
    return  SingletonHolder.INSTANCE;
  }

}
