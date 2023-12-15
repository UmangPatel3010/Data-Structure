package Queue;

import java.util.Scanner;

public class SimpleQueueImplementation {
    static Integer[] q;
    static int rear=-1;
    static int front=-1;
    static int size;

    public static void enqueue(int val){
        if(rear==(q.length-1))
            System.out.println("Queue is Overflow");
        else {
            rear++;
            q[rear]=val;
            if(front==-1) {
                front=0;
            }
        }
    }
    public static int dequeue(){
        int val=q[front];
        q[front]=null;
        if(front==rear)
            front=rear=-1;
        else
            front+=1;
        return val;
    }
    public static void display(){
        for(int i=front;i!=rear;i=(i+1)%size)
            System.out.print(q[i]+",");
        System.out.println(q[rear]);
    }
    public static int rear(){
        return q[rear];
    }
    public static int front(){
        return q[front];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of Queue:");
        size = sc.nextInt();

        q = new Integer[size];
        int op;

        while(true){
            System.out.println("1)ENQUEUE\n2)DEQUEUE\n3)REAR\n4)FRONT\n5)SHOW\n6)EXIT");
            System.out.print("Enter from the following options:");
            op= sc.nextInt();
            switch (op) {
                case 1:
                    do {
                        System.out.print("Enter Value to ENQUEUE:");
                        enqueue(sc.nextInt());
                        System.out.print("do you want to continue?(yes or no):");
                    } while (sc.next().equals("yes"));
                    break;
                case 2:
                    if(front == -1)
                        System.out.println("Queue is Underflow");
                    else
                        System.out.println(dequeue() + " is dequeue");
                    break;
                case 3:
                    if(rear == -1)
                        System.out.println("Queue is Underflow");
                    else
                        System.out.println("rear is pointing on "+rear());
                    break;
                case 4:
                    if(front == -1)
                        System.out.println("Queue is Underflow");
                    else
                        System.out.println("front is pointing on "+front());
                    break;
                case 5:
                    if(rear == -1)
                        System.out.println("Queue is Underflow");
                    else
                        display();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("*** Enter appropriate input ***");
                    break;
            }

        }
    }
}
