/*
    aaabbb= valid;
    aabbb = invalid;
    abbba= invalid (sequence does matter)
 */
import java.util.Scanner;
import java.util.Stack;

public class GrammerCheck_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int i;
        Stack<Character> s= new Stack<Character>();
        System.out.print("Enter String:");
        str = sc.nextLine();

        for(i=0;i<str.length();i++)
        {
            if(str.charAt(i) != 'a' && str.charAt(i) !='b'){
                System.out.println("String Should contain a and b only");
                System.exit(0);
            }
            if(str.charAt(i) == 'a')
                s.push(str.charAt(i));
            else {
                if(s.empty()){
                    System.out.println(str+" is a Invalid String");
                    System.exit(0);
                }
                else
                    s.pop();
            }
        }
        if(s.empty())
            System.out.println(str+" is a Valid String");
        else
            System.out.println(str+" is a Invalid String");


    }
}
