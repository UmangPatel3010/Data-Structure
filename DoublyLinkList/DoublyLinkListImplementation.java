package DoublyLinkList;

import java.util.Scanner;

class Node{
    Node prev;
    int data;
    Node link;
    public Node(int val){
        prev=null;
        data = val;
        link = null;
    }
}

public class DoublyLinkListImplementation {
    static Node head = null;
    public static void insertFirst(int val){
        Node new_node= new Node(val);
        if(head == null)
            head = new_node;
        else {
            new_node.link = head;
            head.prev = new_node;
            head = new_node;
        }
    }
    public static void insertLast(int val){
        Node new_node= new Node(val);
        if(head == null)
            head = new_node;
        else {
            Node ptr= head;
            while(ptr.link != null)
                ptr= ptr.link;
            ptr.link = new_node;
            new_node.prev = ptr;
        }
    }
    public static boolean insertAfter(int chk,int val){
        Node new_node= new Node(val);
        if(head == null)
            System.out.println("Link List should have atleast one element to perform INSERT_AFTER operation");
        else {
            Node ptr= head;
            while(ptr.link != null && ptr.data != chk)
                ptr= ptr.link;
            if(ptr.data != chk)
                return false;
            new_node.prev = ptr;
            new_node.link = ptr.link;
            if(ptr.link != null)
                new_node.link.prev = new_node;
            ptr.link = new_node;
        }
        return true;
    }
    public static boolean insertBefore(int chk,int val){
        Node new_node= new Node(val);
        if(head == null)
            System.out.println("Link List should have atleast one element to perform INSERT_BEFORE operation");
        else {
            Node ptr= head;
            while(ptr.link != null && ptr.data != chk)
                ptr= ptr.link;
            if(ptr.data != chk)
                return false;
            new_node.link = ptr;
            new_node.prev = ptr.prev;
            if(ptr.prev == null)
                head = new_node;
            else
                new_node.prev.link = new_node;
            ptr.prev = new_node;
        }
        return true;
    }
    public static int deleteFirst(){
        int val = head.data;
        head= head.link;
        if(head != null){
            head.prev.link = null;//not mandatory just trying to free memory in java
            head.prev = null;
        }
        return val;
    }
    public static int deleteLast(){
        Node ptr= head;
        while(ptr.link != null)
            ptr= ptr.link;

        int val = ptr.data;
        if(ptr == head)
            head=null;
        else
            ptr.prev.link = null;
        return val;
    }
    public static boolean deletion(int chk){
        Node ptr= head;
        while (ptr.link !=null && ptr.data != chk)
            ptr= ptr.link;
        if(ptr.data != chk)
            return false;

        if(ptr == head){
            head= head.link;
            if(head != null){
                head.prev.link = null;//not mandatory just trying to free memory in java
                head.prev = null;
            }
        } else if (ptr.link == null) {
            ptr.prev.link = null;
        }else {
            ptr.link.prev = ptr.prev;
            ptr.prev.link = ptr.link;
        }
        return true;
    }
    public static void display() {
        Node ptr= head;
        while(ptr != null){
            System.out.print(ptr.data+",");
            if(ptr.link == null)
                break;
            ptr= ptr.link;
        }
        System.out.println();
        while(ptr != null){
            System.out.print(ptr.data+",");
            ptr= ptr.prev;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int op,val,chk;
        while(true){
            System.out.println("\n\n1)INSERT_FIRST\n2)INSERT_LAST\n3)INSERT_AFTER\n4)INSERT_BEFORE\n5)DELETE_FIRST\n6)DELETE_LAST\n7)DELETE_NUMBER\n8)DISPLAY\n9)EXIT");
            System.out.print("Enter from the following options:");
            op= sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Enter number to insert:");
                    val = sc.nextInt();
                    insertFirst(val);
                    break;
                case 2:
                    System.out.print("Enter number to insert:");
                    val = sc.nextInt();
                    insertLast(val);
                    break;
                case 3:
                    System.out.print("Enter data to insert_After:");
                    chk = sc.nextInt();
                    System.out.print("Enter number to insert:");
                    val = sc.nextInt();
                    System.out.println(insertAfter(chk,val)?"":chk+" Element not Found");
                    break;
                case 4:
                    System.out.print("Enter data to insert_Before:");
                    chk = sc.nextInt();
                    System.out.print("Enter number to insert:");
                    val = sc.nextInt();
                    System.out.println(insertBefore(chk,val)?"":chk+" Element not Found");
                    break;
                case 5:
                    if(head==null)
                        System.out.println("LINK LIST is UnderFlow");
                    else
                        System.out.println(deleteFirst()+" is Deleted from First");
                    break;
                case 6:
                    if(head==null)
                        System.out.println("LINK LIST is UnderFlow");
                    else
                        System.out.println(deleteLast()+" is Deleted from Last");
                    break;
                case 7:
                    if(head==null)
                        System.out.println("LINK LIST is UnderFlow");
                    else{
                        System.out.print("Enter number to delete:");
                        val = sc.nextInt();
                        System.out.println(deletion(val)?val+" is Deleted":val+" Element Not Found");
                    }
                    break;
                case 8:
                    if(head==null)
                        System.out.println("LINK LIST is UnderFlow");
                    else
                        display();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("*** Enter appropriate input ***");
                    break;
            }
        }
    }
}
