package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RadixSort {
    public static int[] countSort(int []a,int place){
        int result[]= new int[a.length];
        int count[]= new int[10];

        Arrays.fill(count,0);
        for(int i=0;i<a.length;i++)
            count[(a[i]/place)%10]++;
        for(int i=1;i<count.length;i++)
            count[i] += count[i-1];
        for(int i=a.length-1;i>=0;i--)
            result[--count[(a[i]/place)%10]] = a[i];
        return result;
    }
    public static int[] radixSort(int a[]){
        int max= Arrays.stream(a).max().getAsInt();
        for (int place=1;(max/place)>0;place*=10)
            a = countSort(a, place);
        return a;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Size of array:");
        int[] a=new int[sc.nextInt()];

        for(int i=0;i<a.length;i++){
            System.out.print("enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        a=radixSort(a);
        for (int i:a)
            System.out.print(i+",");
    }
}
