package com.java.ntt.base;
/**
 *静态内部类
 */
public class Singleton04 {

    private Singleton04(){

    }

    private  static   class Singleton04Handle {
        private static  Singleton04  instance = new Singleton04();
    }


    public   static  Singleton04 Singleton04 (){
        return Singleton04Handle.instance;
    }

}
