package com.java.ntt.designPatterns.FactoryMethed;

/**
 * @ClassName Factory
 * @Description  定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化操作推迟到子类。
 * @Author niutongtong
 * @Date 2019-06-02 21:13
 * @Version V1.0
 **/
public abstract   class Factory {
   abstract public Product factoryMethod();
   public  void  dosomething(){
     Product product=factoryMethod();
     //
   }
}
