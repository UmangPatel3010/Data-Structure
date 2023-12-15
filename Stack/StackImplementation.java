import java.util.Scanner;

public class StackImplementation {
    static Integer[] s;
    static int top=-1;
    public static void push(int val){
        if(top==(s.length-1))
            System.out.println("Stack is Overflow");
        else {
            top++;
            s[top] = val;
        }
    }
    public static int pop(){
        int val=s[top];
        s[top]=null;
        top--;
        return val;
    }
    public static int peep(int index){
            return s[top-index];
    }
    public static void change(int val,int index){
        if(index>top)
            System.out.println("Not Possible! Stack will Underflow");
        else if (index<0)
            System.out.println("Not Possible! Top Out of Range");
        else
            s[top-index] = val;
    }


    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of Stack:");
        size = sc.nextInt();

        s = new Integer[size];
        int op,val,index;

        while(true){
            System.out.println("1)PUSH\n2)POP\n3)PEEP\n4)CHANGE\n5)PEEK\n6)DISPLAY\n7)EXIT");
            System.out.print("Enter from the following options:");
            op= sc.nextInt();

            switch (op) {
                case 1:
                    do {
                        System.out.print("Enter Value to PUSH:");
                        push(sc.nextInt());
                        System.out.print("do you want to continue?(1 or 0):");
                    } while (sc.next().equals("1"));
                    break;
                case 2:
                    if (top == -1)
                        System.out.println("Stack is Underflow");
                    else
                        System.out.println(pop() + " is poped");
                    break;
                case 3:
                    System.out.print("Enter Index to PEEP:");
                    index = sc.nextInt();
                    if(top ==-1)
                        System.out.println("Stack is Underflow");
                    else
                        if(index>top)
                            System.out.println("Not Possible! Stack will Underflow");
                        else if (index<0)
                            System.out.println("Not Possible! Top Out of Range");
                        else
                            System.out.println(peep(index)+" is the element on "+index+"th index from the top ");
                    break;
                case 4:
                    System.out.print("Enter Index to CHANGE:");
                    index = sc.nextInt();
                    System.out.print("Enter Value to CHANGE:");
                    val = sc.nextInt();
                    change(val,index);
                    break;
                case 5:
                    if(top==-1)
                        System.out.println("Stack is underflow");
                    else
                        System.out.println("Peek element is "+s[top]);
                    break;
                case 6:
                    if(top==-1)
                        System.out.println("Stack is underflow");
                    else
                        for (int i = top;i>=0;i--)
                            System.out.print(s[i]+",");
                        System.out.println();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("*** Enter appropriate input ***");
                    break;
            }
        }
    }
}
