package Hashing;

import java.util.Arrays;
import java.util.Scanner;

public class HashTable {
    public static int hashFunction(int val,int size){
        return val%size;
    }
    public static int[] createHashTable(int []input,int size){
        int hashtable[]=new int[size];
        Arrays.fill(hashtable,0);
        for (int i=0;i<input.length;i++){
            int index=hashFunction(input[i],size);
            if(hashtable[index]==0)
                hashtable[index]= input[i];
            else{
                int ser_itr=index+1; // ser_itr = search iteration/no of time we search for space
                while(ser_itr!= index){
                    if(ser_itr==hashtable.length)
                        ser_itr=0;
                    if(hashtable[ser_itr]==0) {
                        hashtable[ser_itr] = input[i];
                        break;
                    }
                    else
                        ser_itr++;
                }
                if(ser_itr==index){
                    System.out.println("HashTable OverFlow!! Further elements cannot be store in Hashtable");
                    break;
                }
            }
        }
        return hashtable;
    }
    public static int searchInHashTable(int number,int []hashtable) throws Exception {
        int index=hashFunction(number, hashtable.length);
        if(hashtable[index]==number)
            return index;
        else{
            int ser_itr=index+1;
            if(ser_itr==hashtable.length)
                ser_itr=0;
            while(ser_itr!= index){
                if(hashtable[ser_itr]==number)
                    return ser_itr;
                else
                    if(ser_itr==hashtable.length-1)
                        ser_itr=0;
                    else
                        ser_itr++;
            }
            throw new Exception("Element Not Found");
        }

    }
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Size of HashTable:");
        int size= sc.nextInt();

        System.out.print("Enter Size of array:");
//        int input[]={13,10,15,12,18,2,1,4};
        int input[]=new int[sc.nextInt()];

        for(int i=0;i<input.length;i++){
            System.out.print("enter a["+i+"]:");
            input[i]= sc.nextInt();
        }

        int []hashTable=createHashTable(input,size);

        System.out.print("Enter Element To Search:");
        int index = searchInHashTable(sc.nextInt(),hashTable);
        System.out.println(hashTable[index]+" Element Found at "+index);

    }
}
