package com.java.ntt.designPatterns.FactoryMethed;

/**
 * @ClassName ConcreteFactory2
 * @Description
 * @Author niutongtong
 * @Date 2019-06-02 21:21
 * @Version V1.0
 **/
public class ConcreteFactory2 extends  Factory {
  @Override
  public Product factoryMethod() {
    return new ConcreteProduct2();
  }
}
