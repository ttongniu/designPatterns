package com.java.ntt.concurrency;

import java.util.concurrent.Callable;

/**
 * @ClassName MyCallable
 * @Description
 * @Author niutongtong
 * @Date 2020/1/15 11:09 上午
 * @Version V1.0
 **/
public class MyCallable implements Callable {

  @Override
  public Integer call() throws Exception {
    return 111;
  }
}
