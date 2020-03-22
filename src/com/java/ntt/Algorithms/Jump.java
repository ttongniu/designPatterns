package com.java.ntt.Algorithms;

/**
 * @ClassName Jump  跳台阶
 * @Description
 * @Author niutongtong
 * @Date 2020/1/17 11:33 上午
 * @Version V1.0
 **/
public class Jump {


  public static int jump(int n){
    if(n==1){
      return 1;
    }
    if(n==2){
      return 2;
    }
    int pre2=1,pre1=2;
    int result = 0;
    for(int i=2;i<n;i++){
       result = pre2+pre1;
       pre2= pre1;
       pre1=result;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println( Jump.jump(4));
  }

}
