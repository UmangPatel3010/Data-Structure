package SinglyLinkList;
import java.util.Scanner;

class StackLL{
    static Node top=null;
    public void push(int data){
        Node new_node = new Node(data);
        if(top!=null)
            new_node.link = top;
        top=new_node;
    }
    public float pop(){
        if(top==null) {
            return 0.2f;
        }
        else {
            int val = top.data;
            top= top.link;
            return val;
        }
    }
    public float peek(){
        if(top == null)
            return 0.2f;
        return top.data;
    }
    public boolean display(){
        if(top==null)
            return false;
        Node ptr= top;
        while(ptr != null){
            System.out.print(ptr.data+",");
            ptr= ptr.link;
        }
        System.out.println();
        return true;
    }
}
public class StackUsingLinkList {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StackLL stk=new StackLL();
        int op,val;
        while(true){
            System.out.println("\n1)PUSH\n2)POP\n3)PEEK\n4)DISPLAY\n5)EXIT");
            System.out.print("Enter from the following options:");
            op= sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Enter number to insert:");
                    val = sc.nextInt();
                    stk.push(val);
                    break;
                case 2:
                    float value= stk.pop();
                    if(value==0.2f)
                        System.out.println("LINK LIST is UnderFlow");
                    else
                        System.out.println((int)value+" is Deleted");
                    break;
                case 3:
                    if(stk.peek() == 0.2f)
                        System.out.println("LINK LIST is UnderFlow");
                    else
                        System.out.println("Peek element is "+(int)stk.peek());
                    break;
                case 4:
                    if(!stk.display())
                        System.out.println("LINK LIST is UnderFlow");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("*** Enter appropriate input ***");
                    break;
            }
        }
    }
}
