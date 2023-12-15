package Seaching;

import java.util.Scanner;

public class LinearSearchInArray {
    public static int LinearSearch(int a[],int search){
        for(int i=0;i<a.length;i++){
            if(a[i]==search)
                return i;
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
        int index=LinearSearch(a, search);
        if(index==-1)
            System.out.println(search+" Element Not Found");
        else
            System.out.println(search+" Element Found at Index-"+ index);
    }
    
}
