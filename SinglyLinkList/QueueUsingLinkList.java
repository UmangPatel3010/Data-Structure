package SinglyLinkList;

import java.util.Scanner;

public class QueueUsingLinkList {
    static Node rear=null;
    static Node front=null;
    public static void enqueue(int val){
        Node new_node= new Node(val);
        if(rear == null)
            rear=front = new_node;
        else {
            rear.link = new_node;
            rear=rear.link;
        }
    }
    public static float dequeue(){
        if(front==null)
            return 0.2f;
        else{
            int val = front.data;
            if(rear==front)
                front=rear=null;
            else
                front= front.link;
            return val;
        }
    }
    public static boolean display(){
        if(front==null)
            return false;
        else {
            Node ptr=front;
            while (ptr!=rear){
                System.out.print(ptr.data+",");
                ptr=ptr.link;
            }
            System.out.println(ptr.data);
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int op,val;
        while(true) {
            System.out.println("\n1)ENQUEUE\n2)DEQUEUE\n3)DISPLAY\n4)EXIT");
            System.out.print("Enter from the following options:");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Enter number to insert:");
                    val = sc.nextInt();
                    enqueue(val);
                    break;
                case 2:
                    float value = dequeue();
                    if (value == 0.2f)
                        System.out.println("LINK LIST is UnderFlow");
                    else
                        System.out.println((int) value + " is Deleted");
                    break;
                case 3:
                    if (!display())
                        System.out.println("LINK LIST is UnderFlow");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("*** Enter appropriate input ***");
                    break;
            }
        }
    }
}
