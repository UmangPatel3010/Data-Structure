import java.util.Scanner;

public class ArrayFindReplace {
    public static void main(String[] args) {
        int n;
        int num1,num2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        n= sc.nextInt();
        Integer a[]= new Integer[n];

        for(int i=0;i<n;i++) {
            System.out.print("Enter a["+i+"]:");
            a[i]= sc.nextInt();
        }

        System.out.print("Enter Number-1:");
        num1= sc.nextInt();
        System.out.print("Enter Number-2:");
        num2= sc.nextInt();
        for(int i=0;i<n;i++) {
            if(a[i]==num1)
            {
                a[i]=num2;
                System.out.println(num1+" found at index-"+i);
                for (Integer ar:a)
                    System.out.print(ar+",");
                System.exit(0);
            }
        }
        System.out.println("Array does not contain "+num1);
    }
}
