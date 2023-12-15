package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] a){
        int smallest;
        for (int i=0;i<a.length-1;i++){
            smallest=i;
            for(int j=i+1;j<a.length;j++){
                if(a[smallest]>a[j])
                    smallest=j;
            }
            if(smallest!= i){
                int temp=a[i];
                a[i]=a[smallest];
                a[smallest]=temp;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
//        System.out.print("Enter Size of array:");
//        int[] a= new int[sc.nextInt()];
        int[] a= {10,20,5,8,9,11,15,0,4,30,25,24,28,61,51,55,66,42,31,39,56,44,43,32,65,70,1};


//        for(int i=0;i<a.length;i++){
//            System.out.print("enter a["+i+"]:");
//            a[i]= sc.nextInt();
//        }
        selectionSort(a);
        for (int i:a){
            System.out.print(i+",");
        }
    }
}
