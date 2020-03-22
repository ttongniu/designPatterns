package com.java.ntt.base;

public class Test1 {

    public  static ParameTer p1 = new ParameTer("静态成员变量");
    public   ParameTer p2 = new ParameTer("非静态成员变量");

    public Test1(){
        System.out.println("我是构造函数");
    }
    static {
        System.out.println("我是静态代码块");
    }

    {
        System.out.println("我是构造代码块1");
    }

    {
        System.out.println("我是构造代码块2");
    }

    public static void main(String[] args) {
        new Test1();

        new Test1();
    }

}
