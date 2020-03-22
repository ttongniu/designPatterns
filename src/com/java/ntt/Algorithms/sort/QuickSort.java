package com.java.ntt.Algorithms.sort;


/**
 * @ClassName QuickSort
 * @Description
 * @Author niutongtong
 * @Date 2020/3/14 9:47 下午
 * @Version V1.0
 **/
public class QuickSort {

  public static void main(String[] args) {
    int[] nums = {12,45,62,55,7,9,4};

    quick(nums,0,nums.length-1);
    System.out.println(nums);

  }
  public static  void   quick(int [] nums,int low,int high){
     int pivot;
     if(low<high){
       pivot = partition(nums,low,high);
       quick(nums,low,pivot-1);
       quick(nums,pivot+1,high);
     }
  }

  private static int partition(int[] nums, int low, int high) {
    int pioutKey=nums[low];
    while (low<high){
      while (low<high && nums[high]>pioutKey){
        high--;
      }
      swap(nums,low,high);
      while (low<high && nums[low]<pioutKey){
        low++;
      }
      swap(nums,low,high);
    }

    return low;
  }
  public static void swap(int[] L,int i,int j) {
    int temp=L[i];
    L[i]=L[j];
    L[j]=temp;
  }
}
