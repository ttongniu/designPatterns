package com.java.ntt.Algorithms.sort;

import static com.java.ntt.Algorithms.sort.QuickSort.swap;

public class QuickSortNtt {

    public static void main(String[] args) {

        int[] array = new int[] {
            1,26,6,7,9
        };

        quickSort(array,0,array.length-1);
        for(int i=0 ;i<array.length; i++ ){
            System.out.println(array[i]);

        }

    }

    private static void quickSort(int[] array, int low, int high) {
        if(low<high){
            int mid = findMid(array,low, high);
            quickSort(array,low, mid );
            quickSort(array,mid +1,high);
        }


    }

    private static int findMid(int[] array, int low, int high) {
     int point = array[low];
     while (low < high){
         while (low < high && array[high] >point){
             high--;
         }
         swap(array,low,high);
         while (high > low && array[low]<point){
             low++;
         }
         swap(array, low, high);
     }

     return low;
    }

}
