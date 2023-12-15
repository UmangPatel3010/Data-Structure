package Sorting;

import java.util.Scanner;

public class HeapSort {
    public static void maxheapify(int a[],int n,int curr){
        int largest =curr;
        int l_child= curr*2+1;
        int r_child= curr*2+2;

        if(l_child<n && a[largest]<a[l_child])
            largest=l_child;
        if (r_child<n && a[largest]<a[r_child])
            largest=r_child;

        if(largest!=curr) {
            int temp = a[largest];
            a[largest]=a[curr];
            a[curr]=temp;

            maxheapify(a,n,largest);
        }

    }
    public static void minheapify(int a[],int n,int curr){
        int smallest =curr;
        int l_child= curr*2+1;
        int r_child= curr*2+2;

        if(l_child<n && a[smallest]>a[l_child])
            smallest=l_child;
        if (r_child<n && a[smallest]>a[r_child])
            smallest=r_child;

        if(smallest!=curr) {
            int temp = a[smallest];
            a[smallest]=a[curr];
            a[curr]=temp;

            minheapify(a,n,smallest);
        }

    }
    public static void heapsort(int a[],boolean flag){

        for (int i=(a.length/2)-1;i>=0;i--)
            if(flag)
                maxheapify(a,a.length,i);
            else
                minheapify(a,a.length,i);

        for (int i=a.length-1;i>=0;i--){
            int temp = a[0];
            a[0]=a[i];
            a[i]=temp;

            if (flag)
                maxheapify(a,i,0);
            else
                minheapify(a,i,0);
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
        System.out.print("\n1)Ascending Sort\n2)Decending Sort\nEnter Choice:");
        switch (sc.nextInt()){
            case 1:
                heapsort(a,true);
                break;
            case 2:
                heapsort(a,false);
                break;
            default:
                System.out.println("Enter appropriate Input");
                break;
        }
        for (int i:a)
            System.out.print(i+",");

    }
}


