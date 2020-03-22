package com.java.ntt.Algorithms;
/**
 * @ClassName numberRepeat
 * @Description
 * @Author niutongtong
 * @Date 2020/1/19 7:36 下午
 * @Version V1.0
 **/
public class NumberRepeat {
  // Parameters:
  //    numbers:     an array of integers
  //    length:      the length of array numbers
  //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
  //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
  //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
  // Return value:       true if the input is valid, and there are some duplications in the array number
  //                     otherwise false
  public boolean duplicate(int numbers[],int length,int [] duplication) {

     for(int i=0;i<length;i++){
       while (numbers[i]!=i){
         if(numbers[i] == numbers[numbers[i]]){
            duplication[0] =  numbers[i];
            return true;
         }
         swap(numbers,i,numbers[i]);
       }

     }

     return false;
  }

  private void swap(int[] numbers, int i, int j) {
    int t =numbers[i];
    numbers[i] = numbers[j];
    numbers[j]=t;
  }

}
