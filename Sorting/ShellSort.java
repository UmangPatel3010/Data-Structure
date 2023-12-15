package Sorting;

import java.util.Scanner;

public class ShellSort {
    public static void shellSort(int a[]){
        for(int gap=a.length/2;gap>=1;gap/=2){
            for(int i=gap;i<a.length;i++){
                for (int j=i-gap;j>=0;j=j-gap){
                    if(a[j]<a[j+gap])
                        break;
                    else{
                        int temp = a[j];
                        a[j] = a[j + gap];
                        a[j + gap] = temp;
                    }
                }
//                if(a[i]<a[i-gap]){
//                    int temp= a[i];
//                    a[i]=a[i-gap];
//                    a[i-gap]=temp;
//
//                    for(int index=i-gap;(index-gap)>=0;index=index-gap) {
//                        if (a[index] < a[index - gap]) {
//                            temp = a[index];
//                            a[index] = a[index - gap];
//                            a[index - gap] = temp;
//                        }
//                    }
//                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Size of array:");
//        int []a = {23,29,15,19,31,7,9,5,23};
//        int[] a= {10,20,5,8,9,11,15,0,4,30,25,24,28,61,51,55,66,42,31,39,56,44,43,32,65,70};
        int[] a=new int[sc.nextInt()];

        for(int i=0;i<a.length;i++){
            System.out.print("enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        shellSort(a);
        for (int i:a)
            System.out.print(i+",");
    }
}
