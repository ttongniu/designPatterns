package com.java.ntt.designPatterns.FactoryMethed;

/**
 * @ClassName ConcreteProduct1
 * @Description
 * @Author niutongtong
 * @Date 2019-06-02 19:06
 * @Version V1.0
 **/
public class ConcreteProduct1 implements Product {
  @Override
  public void getName() {
    System.out.println("ConcreteProduct1");
  }
}
