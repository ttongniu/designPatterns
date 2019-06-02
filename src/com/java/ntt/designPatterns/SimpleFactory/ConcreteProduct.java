package com.java.ntt.designPatterns.SimpleFactory;

/**
 * @ClassName ConcreteProduct
 * @Description
 * @Author niutongtong
 * @Date 2019-06-02 19:04
 * @Version V1.0
 **/
public class ConcreteProduct implements  Product{
  @Override
  public void getName() {
    System.out.println("ConcreteProduct");
  }
}
