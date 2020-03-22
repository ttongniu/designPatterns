package com.java.ntt.Algorithms;

/**
 * @ClassName MoreThanHalfNum_Solution
 * @Description 采用阵地攻守的思想：
 *   第一个数字作为第一个士兵，守阵地；count = 1；
 *   遇到相同元素，count++;
 *   遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
 *   再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
 * @Author niutongtong
 * @Date 2020/1/17 4:00 下午
 * @Version V1.0
 **/
public class MoreThanHalfNum_Solution {

  public static int MoreThanHalfNum_Solution(int [] array) {
     int cont =0;
     int soldier =array[0];
    for (int i = 0; i < array.length; i++) {
      int value = array[i];
      if (soldier == value) {
        cont++;
      } else {
        cont--;
      }
      if (cont == 0) {
        soldier = value;
        cont++;
      }
    }
    cont=0;
    for(int value : array ){
      if(value==soldier){
        cont++;
      }
    }

     return cont>array.length/2 ? soldier:0;
  }

  public static void main(String[] args) {
    int[] array =  {1,2,3,2,2,2,5,4,2};
    MoreThanHalfNum_Solution(array);
  }

}
