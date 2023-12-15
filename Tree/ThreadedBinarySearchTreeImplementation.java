package Tree;

import java.util.Scanner;

class TNode{
    TNode lptr;
    boolean lThread;
    int data;
    boolean rThread;
    TNode rptr;

    TNode(int val){
        lptr =null;
        lThread=true;
        data = val;
        rThread=true;
        rptr = null;
    }
}

public class ThreadedBinarySearchTreeImplementation {

    static TNode root= null;
    static TNode dummy= new TNode(111);
    static {
        dummy.rptr=dummy;
    }
    public static void tree_insert(int data){
        TNode new_node= new TNode(data);
        if(root== null){
            root=new_node;
            new_node.lptr=dummy;
            new_node.rptr=dummy;
            dummy.lptr=new_node;
        }
        else {
            TNode ptr;
            ptr=root;
            while (ptr != dummy){
                if(ptr.data>new_node.data && (!ptr.lThread) )
                    ptr=ptr.lptr;
                else if (ptr.data<new_node.data && (!ptr.rThread) )
                    ptr=ptr.rptr;
                else
                    break;
            }
            if(ptr.data>new_node.data){
                new_node.lptr=ptr.lptr;
                new_node.rptr=ptr;
                ptr.lThread=false;
                ptr.lptr=new_node;
            }
            else{
                new_node.rptr=ptr.rptr;
                new_node.lptr= ptr;
                ptr.rThread=false;
                ptr.rptr=new_node;
            }
        }
    }
    public static Boolean tree_search(int node_data){
        if(root==null)
            return false;
        TNode ptr=root;
        while( ptr != dummy && ptr.data != node_data) {
            if(ptr.data>node_data && (!ptr.lThread))
                ptr=ptr.lptr;
            else if(ptr.data<node_data && (!ptr.rThread))
                ptr=ptr.rptr;
            else
                break;
        }
        if(ptr != dummy && ptr.data == node_data)
            return true;
        else
            return false;
    }

    public static boolean tree_delete(TNode T,int node_data){
        TNode ptr=T;
        TNode preptr=ptr;
        while( ptr != dummy && ptr.data != node_data) {
            preptr=ptr;
            if(ptr.data>node_data && (!ptr.lThread))
                ptr=ptr.lptr;
            else if (ptr.data<node_data && (!ptr.rThread))
                ptr=ptr.rptr;
            else
                break;
        }
        if(ptr != dummy && ptr.data == node_data){
            if(ptr.lThread && ptr.rThread){
                if(ptr==root){
                    root=null;
                    dummy.lptr=null;
                }
                else {
                    if(preptr.rptr == ptr){
                        preptr.rThread=true;
                        preptr.rptr =ptr.rptr;
                    }
                    else{
                        preptr.lThread =true;
                        preptr.lptr = ptr.lptr;
                    }
                }
            } else if (ptr.lThread) {
                TNode temp=ptr.rptr;
                while (!temp.lThread)
                    temp=temp.lptr;
                temp.lptr=ptr.lptr;

                if(ptr==root){
                    root=ptr.rptr;
                    dummy.lptr =root;
                }
                else {
                    if(preptr.rptr == ptr)
                        preptr.rptr =ptr.rptr;
                    else
                        preptr.lptr = ptr.rptr;
                }
            } else if (ptr.rThread) {
                TNode temp=ptr.lptr;
                while (!temp.rThread)
                    temp=temp.rptr;
                temp.rptr=ptr.rptr;

                if(ptr==root){
                    root=ptr.lptr;
                    dummy.lptr =root;
                }
                else {
                    if(preptr.rptr == ptr)
                        preptr.rptr =ptr.lptr;
                    else
                        preptr.lptr = ptr.lptr;
                }
            } else {
                System.out.print("\n1)Greatest Predecessor\n2)Smallest Successor\n");
                System.out.print("Select The option to Delete Node:");
                int option= new Scanner(System.in).nextInt();
                TNode save;
                int temp;
                switch (option){
                    case 1:
                        save= ptr.lptr;
                        while (!save.rThread)
                            save= save.rptr;
                        temp = save.data;
                        tree_delete(ptr, save.data);
                        ptr.data=temp;
                        break;
                    case 2:
                        save= ptr.rptr;
                        while (!save.lThread)
                            save= save.lptr;
                        temp = save.data;
                        tree_delete(ptr, save.data);
                        ptr.data=temp;
                        break;
                    default:
                        System.out.println("Enter Appropriate input to delete Node");
                        break;
                }

            }
            return true;
        }
        else
            return false;
    }
    public static void preOrder(TNode T){
        System.out.print(T.data+",");
        if(T.lptr != dummy && (!T.lThread))
            preOrder(T.lptr);
        if (T.rptr != dummy && (!T.rThread))
            preOrder(T.rptr);
    }
    public static void inOrder(TNode T){
        TNode ptr=T;
        while (!ptr.lThread)
            ptr=ptr.lptr;

        while (ptr != dummy){
            System.out.print(ptr.lptr.data+"-"+ptr.data+"-"+ptr.rptr.data+"\t,\t");
           if(ptr.rThread)
                ptr=ptr.rptr;
           else{
               inOrder(ptr.rptr);// Using Recurssion
                break;
//                OR Without Recurssion
//               ptr=ptr.rptr;
//               while (!ptr.lThread)
//                   ptr=ptr.lptr;
           }
        }
    }

    public static void descInOrder(TNode T){
        TNode ptr=T;
        while (!ptr.rThread)
            ptr=ptr.rptr;

        while (ptr != dummy){
            System.out.print(ptr.lptr.data+"-"+ptr.data+"-"+ptr.rptr.data+"\t,\t");
            if(ptr.lThread)
                ptr=ptr.lptr;
            else {
                descInOrder(ptr.lptr);// Using Recurssion
                break;
                // OR Without Recurssion
//                ptr=ptr.lptr;
//                while (!ptr.rThread)
//                    ptr=ptr.rptr;
            }
        }
    }

    public static void postOrder(TNode T){
        if(T.lptr != dummy && (!T.lThread))
            postOrder(T.lptr);
        if (T.rptr != dummy && (!T.rThread))
            postOrder(T.rptr);
        System.out.print(T.data+",");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op,val;
        while (true){
            System.out.println("\n\n1)INSERT\n2)DELETE\n3)PREORDER\n4)INORDER\n5)INORDER-DESC\n6)POSTORDER\n7)EXIT");
            System.out.print("Enter from the following options:");
            op= sc.nextInt();
            switch (op){
                case 1:
                    System.out.print("Enter Number to Insert:");
                    val = sc.nextInt();
                    if(tree_search(val))
                        System.out.println(val+" Number is Already Present in The Tree");
                    else
                        tree_insert(val);
                    break;
                case 2:
                    if(root==null)
                        System.out.println("Tree is Underflow");
                    else{
                        System.out.print("Enter Number to Delete:");
                        val = sc.nextInt();
                        if(tree_delete(root,val))
                            System.out.println(val+" is Deleted");
                        else
                            System.out.println(val+" Element Not Found");
                    }
                    break;
                case 3:
                    if(root==null)
                        System.out.println("Tree is Underflow");
                    else{
                        System.out.print("Preorder=");
                        preOrder(root);
                    }
                    break;
                case 4:
                    if(root==null)
                        System.out.println("Tree is Underflow");
                    else {
                        System.out.print("Inorder=");
                        inOrder(root);
                    }
                    break;
                case 5:
                    if(root==null)
                        System.out.println("Tree is Underflow");
                    else {
                        System.out.print("Inorder=");
                        descInOrder(root);
                    }
                    break;
                case 6:
                    if(root==null)
                        System.out.println("Tree is Underflow");
                    else {
                        System.out.print("Postorder=");
                        postOrder(root);
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Appropriate Input");
            }
        }
    }
}
