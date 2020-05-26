package com.java.ntt.Algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Solution {

   //
   public static String  replaceSpace(StringBuilder str){
       StringBuilder result = new StringBuilder();
       int length = str.length();
       for(int i=0;i<length;i++){
          char b =str.charAt(i);
          if(String.valueOf(b).equals(" ")){
            result.append("%20");
          }else {
            result.append(b);

          }
       }
       return  result.toString();
   }

   public static String  charString(String[] strs){
        if(!checkStrs(strs)){
           return "";
        }
        int len = strs.length;
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        int m=strs[0].length();
        int n = strs[len-1].length();
        int num = Math.min(n,m);
        for(int i=0;i<num;i++){
          if(strs[0].charAt(i)==strs[len-1].charAt(i)){
            result.append(strs[0].charAt(i));
          }else{
            break;
          }
        }
     return result.toString();
   }

  private static boolean checkStrs(String[] strs) {
      boolean flag =false;
      if(strs !=null){
        for(int i=0;i<strs.length;i++) {
          if(strs[i]!=null && strs[0].length()!=0){
            flag=true;
          }else{
            flag=false;
            break;
          }
        }
      }
      return flag;
  }

   public int longestPalindrome(String s){
     if(s.length()==0){
       return 0;
     }
     HashSet<Character> hash=new HashSet<Character>();
     int count=0;
     char[] chars = s.toCharArray();
     for(int i=0;i<chars.length;i++){
         if(!hash.contains(chars[i])){
           hash.add(chars[i]);
         }else{
           hash.remove(chars[i]);
           count++;
         }
     }
     return hash.isEmpty()?count*2:count*2+1;

   }

  public boolean isPalindrome(String s){
       if(s!=null && s.length()==0){
         return true;
       }
       int l=0 ;int r=s.length()-1;
       while (l<r){
         if(!Character.isLetterOrDigit(s.charAt(l))){
           l++;
         }
        else if(!Character.isLetterOrDigit(s.charAt(r))){
           r--;
         }else{
          if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
            return  false;
          }
          l++;
          r--;
         }
       }
       return true;
  }

   public  ListNode addTwoNumbers(ListNode l1,ListNode l2){
     ListNode dummyHead = new ListNode(0);
     ListNode p=l1, q=l2,curr=dummyHead;
     int carry=0;
     while(p!=null||q!=null){
       int x=(p!=null)?p.val:0;
       int y = (q!=null)?q.val:0;
       int sum = carry+x+y;
       carry=sum%10;
       curr.next=new ListNode(sum%10);
       curr=curr.next;
       if(p!=null) p=p.next;
       if(q!=null) q=q.next;
     }
     if(carry>0){
       curr.next=new ListNode(carry);
     }
   return dummyHead.next;
   }


   public  ListNode ReverseList(ListNode head){
      ListNode next =null;
      ListNode pre =null;

      while(head!=null){
        next =head.next;
        head.next=pre;
        pre=head;
        head=next;
      }
     return pre;
   }

  public ListNode getKthFromEnd(ListNode head, int k){
       ListNode q = head;
       ListNode m =  head;

       while (q!=null && k>0){
         q =q.next;
         k--;
       }
       while (q!=null){
         q=q.next;
         m=m.next;
       }
       return m;
  }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    /*  ListNode tem = new ListNode(0);
      tem.next=head;
      ListNode q = head;
      ListNode  m=tem;
      while (q!=null && n>0){
        q = q.next;
        n--;
      }
      while (q!=null){
        q = q.next;
        m = m.next;
      }
      m.next =m.next.next;
      return tem.next;*/
    ListNode tem = new ListNode(0);
    tem.next=head;
    ListNode q=head;
    ListNode  m=tem;
    while (q!=null && n>0){
      q = q.next;
      n--;
    }
    while (q!=null){
      q = q.next;
      m = m.next;
    }
    m.next =m.next.next;
    return tem.next;
  }

  Stack<Integer> stack1 =  new Stack<Integer>();
   Stack<Integer> stack2 = new Stack<Integer>();

   public void push(int node){
      stack1.push(node);
   }

   public int pop(){
     if(stack1.isEmpty()&& stack2.isEmpty()){
       throw new RuntimeException("queue is empty");
     }
     if(stack2.isEmpty()){
       while (!stack1.isEmpty()){
         stack2.push(stack1.pop());
       }
     }
     return stack2.pop();
   }

   public boolean find(int target ,int [][] arrayss){
       int row = arrayss.length-1;
       int column = 0;
       while ((row>=0) && column< arrayss[0].length) {
         if(arrayss[row][column]>target){
           row--;
         }else if (arrayss[row][column]<target){
           column++;
         }else{
           return  true;
         }
       }
       return false;
   }

}
