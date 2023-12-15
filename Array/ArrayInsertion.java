import java.util.Scanner;

public class ArrayInsertion {
    public static void main(String[] args) {
        int n;
        int loc,val;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        n= sc.nextInt();
        Integer a[]= new Integer[n+1];

        for(int i=0;i<n;i++) {
            System.out.print("Enter a["+i+"]:");
            a[i]= sc.nextInt();
        }

        System.out.print("Enter Location to insert:");
        loc= sc.nextInt();
        System.out.print("Enter Value to insert:");
        val= sc.nextInt();
        for(int i=(a.length-1);i>loc;i--)
            a[i]=a[i-1];

        a[loc]= val;
        for (Integer ar:a)
            System.out.print(ar+",");
    }
}
