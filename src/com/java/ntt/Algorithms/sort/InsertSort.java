package com.java.ntt.Algorithms.sort;

/**
 * @ClassName InsertSort
 * @Description
 * @Author niutongtong
 * @Date 2020/3/14 8:18 下午
 * @Version V1.0
 **/
public class InsertSort {

  public static void main(String[] args) {
    int[] nums ={23,4,5,6,89,2,0};
    int temp;
    int j;
    for(int i=1;i<nums.length;i++){
      temp=nums[i];
      for( j=i;j>0 && nums[j-1]>temp;j--){
          nums[j]=nums[j-1];
      }
      nums[j]=temp;
    }
    System.out.println(nums);
  }
}
