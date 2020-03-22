package com.java.ntt.Algorithms.sort;

/**
 * @ClassName mergeSort
 * @Description
 * @Author niutongtong
 * @Date 2020/3/15 3:10 下午
 * @Version V1.0
 **/
public class mergeSort {

  public static void main(String[] args) {
    int[] nums = {4,78,54,7,72,9,10};

    mergeSort(nums,0,nums.length-1);
    System.out.println(nums);
  }
  public static  void mergeSort(int[] arr , int l ,int r){
     if(l==r){
       return;
     }
     //分治
     int m=(l+r)/2;
     mergeSort(arr,l,m);
     mergeSort(arr, m+1, r);
     merge(arr,l,m+1,r);
  }


  public static  void merge(int [] arr ,int l ,int m,int r) {
     int leftSize = m-l;
     int rightSize = r-m+1;
     int[] left =new int[leftSize];
     int[] right = new int[rightSize];
     int i , j ,k ;

     for(i=l;i<m;i++){
       left[i-l]=arr[i];
     }
     for(i=m;i<=r;i++){
       right[i-m]=arr[i];
     }
     //合并
    i=0;k=l; j=0;
    while (i<leftSize && j<rightSize){
        if(left[i]<right[j]){
         arr[k]=left[i];
          i++;
          k++ ;
        }
        else {
          arr[k]=right[j];
          j++;
          k++;
        }
    }
     while (i<leftSize){
       arr[k]=left[i];
       i++;
       k++ ;
     }
     while (j<rightSize){
       arr[k]=right[j];
       j++;
       k++;
     }
  }

}
