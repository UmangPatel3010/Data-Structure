package Seaching;

import java.util.Scanner;

public class BinarySearchInArray {
    public static int BinarySearch(int a[],int search){
        int lb=0;
        int ub=a.length-1;
        int mid;
        while (ub>=lb){
            mid=(ub+lb/2);
            if(a[mid]==search)
                return mid;
            else if(a[mid]>search)
                ub=mid-1;
            else if(a[mid]<search)
                lb=mid+1;
        }
        return -1;
    } 
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // int a[]= {11,22,33,44,55,66,77,88,99,100};
        System.out.print("Enter Size of Array:");
        int a[]= new int[sc.nextInt()];

        for(int i=0;i<a.length;i++){
            System.out.print("Enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        System.out.print("Enter Element to Search:");
        int search = sc.nextInt();
        int index=BinarySearch(a, search);
        if(index==-1)
            System.out.println(search+" Element Not Found");
        else
            System.out.println(search+" Element Found at Index-"+ index);
    }
    
}
