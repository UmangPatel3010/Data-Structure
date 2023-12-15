/* string contain a  and b only c as center charater
* and check weather string is palindrome
* */
import java.util.Scanner;
import java.util.Stack;

public class GrammerCheck {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.print("Enter String:");
        str = sc.next();

        if(str.indexOf("c")!=str.lastIndexOf("c")) {
            System.out.println("string should have only one 'c' ");
            System.exit(0);
        }

        if(str.length()%2==0) {
            System.out.println(str +" is a invalid string");
            System.exit(0);
        }

        for (int i =0;i<str.length();i++) {
            if (str.charAt(i)=='c'){
                for (i=i+1;i<str.length();i++) {
                    if(str.charAt(i)!= 'a' && str.charAt(i)!= 'b') {
                        System.out.println("String should not contain letter other than 'a' or 'b'");
                        System.exit(0);
                    }
                    if(s.isEmpty()) {
                        System.out.println(str +" is a invalid string");
                        System.exit(0);
                    }
                    if(str.charAt(i)==s.peek()){
                        s.pop();
                    }
                    else
                        break;
                }
                break;
            }
            if(str.charAt(i)!= 'a' && str.charAt(i)!= 'b') {
                System.out.println("String should not contain letter other than 'a' or 'b'");
                System.exit(0);
            }
            s.push(str.charAt(i));
        }

        if(s.size()==0)
            System.out.println(str+" is a valid string");
        else
            System.out.println(str +" is a invalid string");
    }
}
