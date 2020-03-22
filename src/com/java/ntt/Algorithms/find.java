package com.java.ntt.Algorithms;

/**
 * @ClassName find
 * @Description
 * @Author niutongtong
 * @Date 2020/1/19 8:59 下午
 * @Version V1.0
 **/
public class find {

  public boolean find(int target, int [][] array) {
    if(array==null || array.length==0 || array[0].length==0){
      return false;
    }
     //行数
    int rows = array.length;
     //列数
    int cols = array[0].length;
    //右上角
    int r=0,c=cols-1;
    while (r<rows-1 && c>0){
      if(target>array[r][c]){
        r++;
      }else {
        c--;
      }
      if(target==array[r][c]){
        return true;
      }
    }
     return false;
  }
}
