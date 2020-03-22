package com.java.ntt.Algorithms.sort;

/**
 * @ClassName Insertion
 * @Description
 *   思想：
 *   通常人们整理桥牌的方法是一张一张的来，将每一张桥牌插入到其他已经有序的牌中的适当位置。
 *   在计算机中实现中，为了给要插入的元素腾出空间，我们需要将其他所有元素在插入之前都向右移动一位。
 * @Author niutongtong
 * @Date 2019-10-22 22:53
 * @Version V1.0
 **/
public class Insertion {

  public static void sort(Comparable[] a){
    int N=a.length;
    for(int i=1;i<N;i++){
      //将a[i]插入到 a[i-1],a[i-2],a[i-3]...之中
      for(int j=i;j>0 && Example.less(a[j],a[j-1]); j--){
        Example.exch(a,j,j-1);
      }
    }
  }


}
