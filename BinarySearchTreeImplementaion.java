package Tree;

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
public class BinarySearchTreeImplementaion {
    static Node root= null;
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
    public static Boolean tree_search(int node_data){
        Node ptr=root;
        while( ptr != null && ptr.data != node_data) {
            if(ptr.data>node_data)
                ptr=ptr.lptr;
            else
                ptr=ptr.rptr;
        }
        if(ptr != null && ptr.data == node_data)
            return true;
        else
            return false;
    }

    public static boolean tree_delete(Node T,int node_data){
        Node ptr=T;
        Node preptr=ptr;
        while( ptr != null && ptr.data != node_data) {
            preptr=ptr;
            if(ptr.data>node_data)
                ptr=ptr.lptr;
            else
                ptr=ptr.rptr;
        }
        if(ptr != null && ptr.data == node_data){
            if(ptr.lptr == null && ptr.rptr==null){
                if(ptr==root)
                    root=null;
                else {
                    if(preptr.rptr == ptr)
                        preptr.rptr =null;
                    else
                        preptr.lptr = null;
                }
            } else if (ptr.lptr==null) {
                if(ptr==root)
                    root=ptr.rptr;
                else {
                    if(preptr.rptr == ptr)
                        preptr.rptr =ptr.rptr;
                    else
                        preptr.lptr = ptr.rptr;
                }
            } else if (ptr.rptr == null) {
                if(ptr==root)
                    root=ptr.lptr;
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
                Node save;
                int temp;
                switch (option){
                    case 1:
                        save= ptr.lptr;
                        while (save.rptr != null)
                            save= save.rptr;
                        temp = save.data;
                        tree_delete(ptr, save.data);
                        ptr.data=temp;
                        break;
                    case 2:
                        save= ptr.rptr;
                        while (save.lptr != null)
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
    public static void preOrder(Node T){
        System.out.print(T.data+",");
        if(T.lptr != null)
            preOrder(T.lptr);
        if (T.rptr != null)
            preOrder(T.rptr);
    }
    public static void inOrder(Node T){
        if(T.lptr != null)
            inOrder(T.lptr);
        System.out.print(T.data+",");
        if (T.rptr != null)
            inOrder(T.rptr);
    }
    public static void postOrder(Node T){
        if(T.lptr != null)
            postOrder(T.lptr);
        if (T.rptr != null)
            postOrder(T.rptr);
        System.out.print(T.data+",");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op,val;
        while (true){
            System.out.println("\n\n1)INSERT\n2)DELETE\n3)PREORDER\n4)INORDER\n5)POSTORDER\n6)EXIT");
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
                        System.out.print("Postorder=");
                        postOrder(root);
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Appropriate Input");
            }

        }
    }
}
