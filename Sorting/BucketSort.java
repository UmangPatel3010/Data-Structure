package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BucketSort
{
    public static void bucketSort(int a[],int no_of_bucket){
        int max= Arrays.stream(a).max().getAsInt();
        if(max/2 < no_of_bucket){
            System.out.println("invalid Number of bucket");
            return;
        }
        ArrayList<Integer> []bucket = new ArrayList[no_of_bucket];
        for (int i=0;i<bucket.length;i++)
            bucket[i]=new ArrayList<Integer>();

        for(int i=0;i<a.length;i++){
            if(a[i]==max)
                bucket[bucket.length-1].add(a[i]);
            else
                bucket[(a[i]/(max/no_of_bucket))].add(a[i]);
        }
        for (int i=0;i<bucket.length;i++)
            Collections.sort(bucket[i]);

        int index=0;
        for (int i=0;i<bucket.length;i++)
            for (int j=0;j<bucket[i].size();j++)
                a[index++]=bucket[i].get(j);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Size of array:");
//        int[] a= {10,20,5,8,9,11,15,0,4,30,25,24,28,61,51,55,66,42,31,39,56,44,43,32,65,70};
        int[] a=new int[sc.nextInt()];

        for(int i=0;i<a.length;i++){
            System.out.print("enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        bucketSort(a,7);
        for (int i:a){
            System.out.print(i+",");
        }
    }
}
