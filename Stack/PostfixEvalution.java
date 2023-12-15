package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvalution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Stack<Integer> s = new Stack<Integer>();
        System.out.println("Enter comma seprated postfix notation:");
        String str; //= sc.nextLine();
        str = "7,5,2,+,*,4,1,1,+,/,-";
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)==',') {
                continue;
            } else if (str.charAt(i)>=48 && str.charAt(i)<=57) {
                String temp=str.charAt(i)+"";
                while (str.charAt(i+1)!=',') {
                    temp= temp+str.charAt(i+1);
                    i++;
                }
//                System.out.println(i+",,,"+temp);
                s.push(Integer.parseInt(temp));
            }
            else
                switch(str.charAt(i)){
                    case '+':
                        s.push(s.pop()+s.pop());
                        break;
                    case '-':
                        int op2= s.pop();
                        int op1= s.pop();
                        s.push(op1 -op2);
                        break;
                    case '*':
                        s.push(s.pop()*s.pop());
                        break;
                    case '/':
                        op2= s.pop();
                        op1= s.pop();
                        s.push(op1/op2);
                        break;
                    case '%':
                        op2= s.pop();
                        op1= s.pop();
                        s.push(op1%op2);
                        break;
                }
        }
        if(s.size()==1)
            System.out.println("Answer of Postfix Evaluation is:"+s.pop());
    }
}
