package com.java.ntt.designPatterns.FactoryMethed;

/**
 * @ClassName ConcreteFactory
 * @Description
 * @Author niutongtong
 * @Date 2019-06-02 21:19
 * @Version V1.0
 **/
public class ConcreteFactory extends Factory {
  @Override
  public Product factoryMethod() {
    return new ConcreteProduct();
  }
}
