package com.java.ntt.Algorithms.sort;

import java.util.HashMap;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @ClassName BubbleSort
 * @Description
 * @Author niutongtong
 * @Date 2020/3/13 8:37 下午
 * @Version V1.0
 **/
public class BubbleSort {

  public static void main(String[] args) {
    int [] nums = {5,6,73,3,2,3,4};

    boolean hasChange = true;

    for(int i=0 ; i< nums.length-1 && hasChange;i++){
     hasChange =false;
     for(int j=0;j<nums.length-i-1;j++){
       if(nums[j] >nums[j+1]){
         swap(nums,j,j+1);
         hasChange=true;
       }
     }
    }
    System.out.println(nums);
  }

  private static void swap(int[] nums, int j, int i) {
     int temp =nums[j];
     nums[j]=nums[i];
     nums[i]=temp;
  }


}
