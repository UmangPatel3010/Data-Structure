package Stack;

import java.util.Scanner;
import java.util.Stack;

public class ABOccurance {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.print("Enter String:");
        str = sc.next();

        if(str.length()%2==1)
        {
            System.out.println(str+" is a invalid string");
            System.exit(0);
        }

        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) != 'a' && str.charAt(i) != 'b') {
                System.out.println("String should not contain letter other than 'a' or 'b'");
                System.exit(0);
            }
            if (str.charAt(i) == 'a')
                s.push(str.charAt(i));
        }

        for (int i=0;i<str.length();i++)
            if(str.charAt(i)=='b')
                s.pop();

        if(s.size()==0)
            System.out.println(str +" is a valid string");
        else
            System.out.println(str +" is a invalid string");
    }
}
