package Sorting;
import java.util.Scanner;

public class MergeSort {
    public static void merge(int []a,int lb,int mid,int ub){
        int b[] = new int[(ub-lb)+1];
        int i=lb;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ub)
        {
            if(a[i]<=a[j]){
                b[k]=a[i];
                i++;
            }else {
                b[k]=a[j];
                j++;
            }
            k++;
        }
        if(i>mid)
           while (j<=ub){
               b[k]=a[j];
               j++;
               k++;
           }
        else
            while (i<=mid){
                b[k]=a[i];
                i++;
                k++;
            }
        for(int z=0;z<b.length;z++)
            a[lb++]=b[z];
    }
    public static void mergeSort(int []a,int lb,int ub){
        if(lb<ub){
            int mid=(lb+ub)/2;
            mergeSort(a,lb,mid);
            mergeSort(a,mid+1,ub);
            merge(a,lb,mid,ub);
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Size of array:");
        int[] a= new int[sc.nextInt()];
//        int[] a= {10,20,5,8,9,11,15,0,4,30,25,24,28,61,51,55,66,42,31,39,56,44,43,32,65,70};
//        int a[]={7,5,2,4,1,6,3,0};

        for(int i=0;i<a.length;i++){
            System.out.print("enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        mergeSort(a,0,a.length-1);
        for (int i:a){
            System.out.print(i+",");
        }
    }
}
