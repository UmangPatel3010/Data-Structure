package Queue;

import java.util.Scanner;

public class PriorityQueueImplementation {
    static QueueNode head;
    static class QueueNode{
        int data;
        int priority;
        QueueNode link;
        QueueNode(int data,int priority){
            this.data=data;
            this.priority = priority;
            link=null;
        }
    }
    public static void enqueue(int val,int prio){
        QueueNode new_node= new QueueNode(val,prio);
        if(head == null)
            head= new_node;
        else {
            if(head.priority <= prio) {
                new_node.link=head;
                head=new_node;
            }else{
                QueueNode ptr= head;
                while(ptr.link !=null && ptr.link.priority > prio)
                    ptr=ptr.link;
                new_node.link=ptr.link;
                ptr.link=new_node;
            }
        }
    }
    public static int[] peek(){
        return new int[]{head.data,head.priority};
    }
    public static int dequeue(){
        int val = head.data;
        head= head.link;
        return val;
    }
    public static void display(){
        QueueNode ptr= head;
        while(ptr != null){
            System.out.print(ptr.data+"-"+ptr.priority+",");
            ptr= ptr.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int op;

        while(true) {
            System.out.println("1)ENQUEUE\n2)DEQUEUE\n3)PEEK\n4)DISPLAY\n5)EXIT");
            System.out.print("Enter from the following options:");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    do {
                        System.out.print("Enter Value to ENQUEUE:");
                        int val = sc.nextInt();
                        System.out.print("Enter Priority to ENQUEUE:");
                        int prio = sc.nextInt();
                        enqueue(val,prio);
                        System.out.print("do you want to continue?(yes or no):");
                    } while (sc.next().equals("yes"));
                    break;
                case 2:
                    if (head == null)
                        System.out.println("Queue is Underflow");
                    else
                        System.out.println(dequeue() + " is dequeue");
                    break;
                case 3:
                    if (head == null)
                        System.out.println("Queue is Underflow");
                    else{
                        int a[]=peek();
                        System.out.println(a[0]+" has highest priority is "+a[1]);
                    }
                    break;
                case 4:
                    if(head==null)
                        System.out.println("LINK LIST is UnderFlow");
                    else
                        display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("*** Enter appropriate input ***");
                    break;
            }
        }
    }
}
