package com.java.ntt.Algorithms;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName PrintListFromTailToHead
 * @Description
 * @Author niutongtong
 * @Date 2020/1/19 9:25 下午
 * @Version V1.0
 **/
public class PrintListFromTailToHead {

  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> arrayList = new ArrayList<>(16);
    //采用栈的先进后出
    while (listNode!=null){
      stack.push(listNode.val);
      listNode=listNode.next;
    }
    while (!stack.isEmpty()){
      arrayList.add(stack.pop());
    }
    return arrayList;
  }

  class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

}

