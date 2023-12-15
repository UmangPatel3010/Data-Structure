package Sorting;
import java.util.Scanner;

class Node{
    Node lptr;
    int data;
    Node rptr;

    Node(int val){
        lptr =null;
        data = val;
        rptr = null;
    }
}

public class TreeSort {
    static Node root;
    public static void tree_insert(int data){
        Node new_node= new Node(data);
        if(root== null){
            root=new_node;
        }
        else {
            Node ptr,preptr;
            ptr=preptr=root;
            while (ptr!= null){
                preptr=ptr;
                if(ptr.data>new_node.data)
                    ptr=ptr.lptr;
                else if (ptr.data<new_node.data)
                    ptr=ptr.rptr;
            }
            if(preptr.data>new_node.data)
                preptr.lptr=new_node;
            else
                preptr.rptr=new_node;
        }
    }
    public static void inOrder(Node T){
        if(T.lptr != null)
            inOrder(T.lptr);
        System.out.print(T.data+",");
        if (T.rptr != null)
            inOrder(T.rptr);
    }

    public static void treeSort(int a[]){
        for (int i:a)
            tree_insert(i);
        inOrder(root);
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
        treeSort(a);
    }
}
