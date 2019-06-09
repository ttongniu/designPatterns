package com.java.ntt.designPatterns.AbstractFactory;

/**
 * @ClassName Client
 * @Description
 * @Author niutongtong
 * @Date 2019-06-09 11:18
 * @Version V1.0
 **/
public class Client {

    public static void main(String[] args) {
      AbstractFactory abstractFactory = new ConcreteFactory1();
      AbstractProductA productA = abstractFactory.createProductA();
      AbstractProductB productB = abstractFactory.createProductB();
      // do something with productA and productB
    }


}
