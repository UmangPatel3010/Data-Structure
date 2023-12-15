package Sorting;

import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int[] a){
        for (int i=0;i< a.length-2;i++){
            for (int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp= a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
//        System.out.print("Enter Size of array:");
//        int[] a= new int[sc.nextInt()];
//
//        for(int i=0;i<a.length;i++){
//            System.out.print("enter a["+i+"]:");
//            a[i]= sc.nextInt();
//        }
        int[] a= {10,20,5,8,9,11,15,0,4,30,25,24,28,61,51,55,66,42,85,31,39,56,44,43,32,65,70};

        bubbleSort(a);
        for (int i:a){
            System.out.print(i+",");
        }
    }
}
