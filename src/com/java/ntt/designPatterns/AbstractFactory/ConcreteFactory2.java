package com.java.ntt.designPatterns.AbstractFactory;

/**
 * @ClassName ConcreteFactory2
 * @Description
 * @Author niutongtong
 * @Date 2019-06-09 11:07
 * @Version V1.0
 **/
public class ConcreteFactory2 extends  AbstractFactory{


  @Override
  AbstractProductA createProductA() {
    return new ProductA2();
  }

  @Override
  AbstractProductB createProductB() {
    return new ProductB2();
  }
}
