package Stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        String pf="";
        String str="";
        System.out.print("Enter Expression Without Space:");
        str = sc.next();
        for (int i=str.length()-1;i>=0;i--){
            System.out.print(str.charAt(i));
            if((str.charAt(i)>=97 && str.charAt(i)<=122) || (str.charAt(i)>=65 && str.charAt(i)<=90))
                pf=str.charAt(i) + pf;
            else if(str.charAt(i)==')'){
                s.push(str.charAt(i));
            }
            else if(str.charAt(i)=='(') {
                while (s.peek() != ')') {
                    pf = s.peek()+pf;
                    s.pop();
                }
                s.pop();
            }
            else {
                if(s.empty())
                    s.push(str.charAt(i));
                else {
                    if(str.charAt(i)=='^') {
                        s.push(str.charAt(i));
                    } else if (str.charAt(i)=='*' || str.charAt(i)=='/' || s.peek()=='%') {
                        while(s.peek()=='^') {
                            pf = s.peek()+pf;
                            s.pop();
                            if(s.empty())
                                break;
                        }
                        s.push(str.charAt(i));
                    }else if (str.charAt(i)=='+' || str.charAt(i)=='-') {
                        while(s.peek()=='/' || s.peek()=='*' || s.peek()=='^' || s.peek()=='%') {
                            pf = s.peek() +pf;
                            s.pop();
                            if(s.empty())
                                break;
                        }
                        s.push(str.charAt(i));
                    }
                }
            }
        }
        while(!s.empty()) {
            pf = s.peek()+pf;
            s.pop();
        }
        System.out.println("\n"+pf);
    }
}