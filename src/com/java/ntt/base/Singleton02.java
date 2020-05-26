package com.java.ntt.base;

/**
 * 懒汉
 */
public class Singleton02 {
    private  Singleton02(){

    }

    private static Singleton02 instance = null;

    public static Singleton02 getInstance(){
        instance = new Singleton02();
        return instance;
    }
}
