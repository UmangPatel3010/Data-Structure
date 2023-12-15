package Sorting;

import java.util.Scanner;

public class insertionSort {
    public static void insertionSort(int[] a) {
        int curr;
        int index;
        for(int i=1;i<a.length;i++){
            curr=a[i];
            index=i-1;
            while (index>=0 && curr<a[index]){
                a[index+1]=a[index];
                index--;
            }
            a[index+1]=curr;
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
        insertionSort(a);
        for (int i:a ){
            System.out.print(i+",");
        }
    }
}
