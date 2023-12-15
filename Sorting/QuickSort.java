package Sorting;

import java.util.Scanner;

public class QuickSort {
    public static int partition(int []a,int lb,int ub){
        int pivot=lb;
        int temp;
        while(lb<ub){
            while(lb<a.length && a[lb]<=a[pivot])
                lb++;
            while(ub>=0 && a[ub]>a[pivot])
                ub--;
            if(lb<ub){
                temp=a[lb];
                a[lb]=a[ub];
                a[ub]=temp;
            }
        }
        temp=a[ub];
        a[ub]=a[pivot];
        a[pivot]= temp;
        return ub;
    }
    public static void quickSort(int []a,int lb,int ub){
        if(lb<ub){
            int loc= partition(a,lb,ub);
            quickSort(a,lb,loc-1);
            quickSort(a,loc+1,ub);
        }

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Size of array:");
        int[] a= new int[sc.nextInt()];

        for(int i=0;i<a.length;i++){
            System.out.print("enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        quickSort(a,0,a.length-1);
        for (int i:a){
            System.out.print(i+",");
        }
    }
}
