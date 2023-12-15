package SinglyLinkList;
import java.util.Scanner;

public class OrderedCircularLinkListImplementation {
    static Node head= null;
    public static void insertion(int val){
        Node new_node= new Node(val);
        if(head == null){
            head = new_node;
            head.link = head;
        }
        else if (new_node.data <= head.data) {
            new_node.link = head;
            Node ptr=head;
            while(ptr.link!=head)
                ptr=ptr.link;
            ptr.link=new_node;
            head = new_node;
        } else {
            Node ptr= head;
            while(ptr.link != head && ptr.link.data < new_node.data)
                ptr= ptr.link;
            if(ptr.link != head)
                new_node.link =ptr.link;
            else
                new_node.link = head;
            ptr.link = new_node;
        }
    }
    public static Boolean deletion(int chk){
        if(head.data == chk){
            if(head.link == head)
                head=null;
            else {
                Node ptr = head;
                while (ptr.link != head)
                    ptr = ptr.link;
                head=head.link;
                ptr.link = head;
            }
        }
        else {
            Node ptr= head;
            while (ptr.link !=null && ptr.link.data != chk)
                ptr= ptr.link;
            if(ptr.link==head)
                return false;
            ptr.link = ptr.link.link;
        }
        return true;
    }
    public static void display() {
        Node ptr= head;
        while(ptr.link != head){
            System.out.print(ptr.data+",");
            ptr= ptr.link;
        }
        System.out.print(ptr.data);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int op,val;
        while(true){
            System.out.println("1)Ordered_Insertion\n2)Deletion\n3)DISPLAY\n4)EXIT");
            System.out.print("Enter from the following options:");
            op= sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Enter number to insert:");
                    val = sc.nextInt();
                    insertion(val);
                    break;
                case 2:
                    if(head==null)
                        System.out.println("LINK LIST is UnderFlow");
                    else{
                        System.out.print("Enter number to delete:");
                        val = sc.nextInt();
                        System.out.println(deletion(val)?val+" is Deleted":val +" Element Not Found");
                    }
                    break;
                case 3:
                    if(head==null)
                        System.out.println("LINK LIST is UnderFlow");
                    else
                        display();
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
