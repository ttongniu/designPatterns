package com.java.ntt.base;

public class Test {

    static {
        System.out.println("我是静态代码块1");
    }

    {
        System.out.println("我是构造代码块1");
    }

    public Test(){
        System.out.println("我是无参构造");
    }


    public Test(int i){
        System.out.println("我是有参"+i);
    }
    static {
        System.out.println("我是静态代码块2");
    }

    {
        System.out.println("我是构造代码块2");
    }


    public static void main(String[] args) {
        Test test = new Test();
        Test test2 = new Test(3);

    }


}
