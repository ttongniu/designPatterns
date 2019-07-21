package com.java.ntt.concurrency.ntt007;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Account
 * @Description  写加锁 读未加锁   （出现脏读）
 * @Author niutongtong
 * @Date 2019-07-20 17:32
 * @Version V1.0
 **/
public class Account {

  private String name;
  private double  balance;

  private  synchronized   void setBalance(String name, double balance){

    this.name = name;
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    this.balance = balance;

  }


  public double getBalance(String name) {
    return  this.balance;
  }

  /**
   * out:
   * 0.0
   * 100.0
   * @param args
   */
  public static void main(String[] args) {
      Account account =new Account();

      new Thread(()->{account.setBalance("ntt",100);}).start();

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(account.getBalance("ntt"));

    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(account.getBalance("ntt"));
  }

}
