package com.java.ntt.Algorithms.sort;

/**
 * @ClassName Selection
 * @Description
 *  选择排序思想：
 *     首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小的那个元素那么它就和自己交换）。再次，在剩下的
 *     元素中找到最小的那个元素，将它与数组的第二个元素进行交换位置。如此往复，直到将整个数组排序。
 * @Author niutongtong
 * @Date 2019-10-22 22:20
 * @Version V1.0
 **/
public class Selection {

    public static void sort(Comparable[] a){
      int N=a.length;
      for(int i=0; i<N ;i++){
        int min=i;
        //找最小
        for(int j=i+1;j<N;j++){
          if(Example.less(a[j],a[min])){
            min = j;
          }
        }
        //将a[i]与a[i+1...N]中的最小值交换
        Example.exch(a,i,min);
      }
    }

}
