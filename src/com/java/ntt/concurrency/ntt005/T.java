package com.java.ntt.concurrency.ntt005;

/**
 * @ClassName T
 * @Description  synchronized 关键字
 * @Author niutongtong
 * @Date 2019-07-20 15:45
 * @Version V1.0
 **/
public class T implements Runnable {
  private  int count = 10;

  private synchronized   void m() {  // synchronized (T.class)
      count--;
      System.out.println(Thread.currentThread().getName() + "Count =" + count);
  }

  @Override
  public void run() {
    m();
  }

  public static void main(String[] args) {
    T t=new T();
    for(int i=0;i<5;i++){
      new Thread(t,"Thread"+i).start();
    }
  }

}
