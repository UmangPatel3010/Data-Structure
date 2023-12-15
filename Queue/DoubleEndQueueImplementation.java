package Queue;

import java.util.Scanner;

public class DoubleEndQueueImplementation {
    static Integer[] q;
    static int rear=-1;
    static int front=-1;
    static int size;
    public static void enqueueRear(int val){
        if(rear==(q.length-1))
            System.out.println("Queue is Overflow from rear end");
        else {
            rear++;
            q[rear]=val;
            if(front==-1) {
                front=0;
            }
        }
    }
    public static int dequeueRear(){
        int val=q[rear];
        q[rear]=null;
        if(front==rear)
            front=rear=-1;
        else
            rear-=1;
        return val;
    }
    public static void enqueueFront(int val){
        if(front==0)
            System.out.println("Queue is Overflow from front end");
        else {
            if(front== -1)
                front=rear=0;
            else
                front--;
            q[front]=val;
        }
    }
    public static int dequeueFront(){
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
            System.out.println("1)ENQUEUE_REAR\n2)ENQUEUE_FRONT\n3)DEQUEUE_REAR\n4)DEQUEUE_FRONT\n5)REAR\n6)FRONT\n7)DISPLAY\n8)EXIT");
            System.out.print("Enter from the following options:");
            op= sc.nextInt();
            switch (op) {
                case 1:
                    do {
                        System.out.print("Enter Value to ENQUEUE:");
                        enqueueRear(sc.nextInt());
                        System.out.print("do you want to continue?(yes or no):");
                    } while (sc.next().equals("yes"));
                    break;
                case 2:
                    do {
                        System.out.print("Enter Value to ENQUEUE:");
                        enqueueFront(sc.nextInt());
                        System.out.print("do you want to continue?(yes or no):");
                    } while (sc.next().equals("yes"));
                    break;

                case 3:
                    if(front == -1)
                        System.out.println("Queue is Underflow");
                    else
                        System.out.println(dequeueRear() + " is dequeue");
                    break;
                case 4:
                    if(front == -1)
                        System.out.println("Queue is Underflow");
                    else
                        System.out.println(dequeueFront() + " is dequeue");
                    break;
                case 5:
                    if(rear == -1)
                        System.out.println("Queue is Underflow");
                    else
                        System.out.println("rear is pointing on "+rear());
                    break;
                case 6:
                    if(front == -1)
                        System.out.println("Queue is Underflow");
                    else
                        System.out.println("front is pointing on "+front());
                    break;
                case 7:
                    if(rear == -1)
                        System.out.println("Queue is Underflow");
                    else
                        display();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("*** Enter appropriate input ***");
                    break;
            }

        }
    }
}
