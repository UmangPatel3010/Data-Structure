import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int i;
        Stack<Character> s= new Stack<Character>();
        System.out.print("Enter String:");
        str = sc.nextLine();
        for(i=0;i<str.length();i++)
        {
            if(i<(str.length()/2))
                s.push(str.charAt(i));
            else {
                if ((str.length()%2==1) && (i == (str.length() / 2)))
                    i++;
                if (s.pop() != str.charAt(i)) {
                    System.out.println(str + " is not a palindrome string");
                    System.exit(0);
                }
            }
        }
        if(i==str.length())
            System.out.println(str+" is a palindrome String");
    }
}
