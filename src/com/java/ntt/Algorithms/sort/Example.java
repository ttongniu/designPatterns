package com.java.ntt.Algorithms.sort;


/**
 * @ClassName Example
 * @Description
 * @Author niutongtong
 * @Date 2019-10-20 17:34
 * @Version V1.0
 **/
public class Example {

   static void sort(Comparable[] a){
    // Selection.sort(a);
     Insertion.sort(a);
  }

  /**
   * 元素比较
   * @param v
   * @param w
   * @return
   */
   static boolean less(Comparable v ,Comparable w){
    return v.compareTo(w) < 0;
  }

  /**
   * 元素交换
   * @param a
   * @param i
   * @param j
   */
   static void exch(Comparable[] a ,int i,int j){
    Comparable t= a[i];
    a[i]=a[j];
    a[j]=t;
  }

  /**
   * 打印
   * @param a
   */
   static void show(Comparable[] a){
    //
    for(int i = 0;i<a.length;i++){
      System.out.println(a[i]+" ");
    }
    System.out.println();
  }

   static boolean isSorted(Comparable[] a){
    for(int i=1;i<a.length;i++){
      if(less(a[i],a[i-1])){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] a = {"a","k","c","b"};

    sort(a);

    assert isSorted(a);
    show(a);
  }


}
