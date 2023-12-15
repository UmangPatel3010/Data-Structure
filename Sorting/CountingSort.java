package Sorting;

import java.util.*;

public class CountingSort {
    public static int[] countingSort(int a[]){
        int result[]= new int[a.length];
        int count[]= new int[(Arrays.stream(a).max().getAsInt())+1];

        Arrays.fill(count,0);
        for(int i=0;i<a.length;i++)
            count[a[i]]++;
        for(int i=1;i<count.length;i++)
            count[i] += count[i-1];
        for(int i=a.length-1;i>=0;i--)
            result[--count[a[i]]] = a[i];
        return result;
    }

    public static int[] countingSort(int a[],int max){
        int result[]= new int[a.length];
        int count[]= new int[max+1];

        Arrays.fill(count,0);
        for(int i=0;i<a.length;i++)
            count[a[i]]++;
        for(int i=1;i<count.length;i++)
            count[i] += count[i-1];
        for(int i=a.length-1;i>=0;i--)
            result[--count[a[i]]] = a[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Size of array:");
        int[] a= new int[sc.nextInt()];

        for(int i=0;i<a.length;i++){
            System.out.print("enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        a = countingSort(a);
        for (int i:a){
            System.out.print(i+",");
        }
    }
}
