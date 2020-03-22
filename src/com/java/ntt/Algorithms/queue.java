package com.java.ntt.Algorithms;

import java.util.Stack;

/**
 * @ClassName queue
 * @Description
 * @Author niutongtong
 * @Date 2020/1/15 9:56 下午
 * @Version V1.0
 **/
public class queue {

  Stack<Integer> in = new Stack<Integer>();

  Stack<Integer> out = new Stack<Integer>();

  public void push(Integer item){
    in.push(item);
  }

  public int pop() throws Exception{
    if(out.isEmpty()){

         while (!in.isEmpty()){
           out.push(in.pop());
         }

    }
    if(out.isEmpty()){
      throw new Exception("queue is empty!");
    }
    return out.pop();
  }

}
