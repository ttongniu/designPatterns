package com.java.ntt.designPatterns.FactoryMethed;

/**
 * @ClassName ConcreteFactory1
 * @Description
 * @Author niutongtong
 * @Date 2019-06-02 21:20
 * @Version V1.0
 **/
public class ConcreteFactory1 extends  Factory{
  @Override
  public Product factoryMethod() {
    return new ConcreteProduct1();
  }
}
