package com.java.ntt.designPatterns.AbstractFactory;

/**
 * @ClassName ConcreteFactory1
 * @Description
 * @Author niutongtong
 * @Date 2019-06-09 11:07
 * @Version V1.0
 **/
public class ConcreteFactory1 extends  AbstractFactory{
  @Override
  AbstractProductA createProductA() {
    return new ProductA1();
  }

  @Override
  AbstractProductB createProductB() {
    return new ProductB1();
  }
}
