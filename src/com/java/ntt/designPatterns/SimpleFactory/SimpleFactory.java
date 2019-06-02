package com.java.ntt.designPatterns.SimpleFactory;

/**
 * @ClassName SimpleFactory
 * @Description
 *在创建一个对象时不向客户暴露内部细节，并提供一个创建对象的通用接口。
 * 简单工厂把实例化的操作单独放到一个类中，这个类就成为简单工厂类，让简单工厂类来决定应该用哪个具体子类来实例化。
 * @Author niutongtong
 * @Date 2019-06-02 19:08
 * @Version V1.0
 **/
public class SimpleFactory {

  public Product createProduct(int type) {
    Product product;
    switch (type) {
      case 1:
        product = new ConcreteProduct1();
        break;
      case 2:
        product = new ConcreteProduct2();
        break;
      default:
        product = new ConcreteProduct();
        break;
    }
    return product;
  }

  public static void main(String[] args) {
    SimpleFactory simpleFactory = new SimpleFactory();
    Product product = simpleFactory.createProduct(1);
    // do something with the product
  }
}

