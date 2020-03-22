package com.java.ntt.Algorithms;

/**
 *  合并连个有序列表
 * @ClassName Merge
 * @Description
 * @Author niutongtong
 * @Date 2020/1/17 3:17 下午
 * @Version V1.0
 **/
public class Merge {
   public ListNode merge(ListNode listNode1 , ListNode listNode2){
        ListNode  head = new ListNode(-1);
        ListNode  cur = head;
        while (listNode1!=null && listNode2!=null){
          if(listNode1.val <= listNode2.val){
            cur.next = listNode1;
            listNode1 = listNode1.next;
          }else {
            cur.next =listNode2;
            listNode2 = listNode2.next;
          }
          cur = cur.next;
        }
        if(listNode1!=null){
          cur.next =listNode1;
        }
        if(listNode2!=null){
          cur.next = listNode2;
        }
      return  head.next;
   }

}



 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}