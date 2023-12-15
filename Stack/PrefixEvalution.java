package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvalution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Stack<Integer> s = new Stack<Integer>();
        System.out.println("Enter comma seprated Prefix notation:");
        String str; //= sc.nextLine();
        str="+,-,*,2,2,1,16";
        for(int i =str.length()-1;i>=0;i--){
            if(str.charAt(i)==',') {
                continue;
            } else if (str.charAt(i)>=48 && str.charAt(i)<=57) {
                String temp=str.charAt(i)+"";
                while (str.charAt(i-1)!=',') {
                    temp= str.charAt(i-1) + temp;
                    i--;
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
                        s.push(s.pop()-s.pop());
                        break;
                    case '*':
                        s.push(s.pop()*s.pop());
                        break;
                    case '/':
                        s.push(s.pop()/s.pop());
                        break;
                    case '%':
                        s.push(s.pop()%s.pop());
                        break;
                }
        }
        if(s.size()==1)
            System.out.println("Answer of Prefix Evaluation is:"+s.pop());
    }
}
