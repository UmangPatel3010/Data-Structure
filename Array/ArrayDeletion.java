import java.util.Scanner;

public class ArrayDeletion {
    public static void main(String[] args) {
        int n;
        int loc;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        n= sc.nextInt();
        Integer a[]= new Integer[n];

        for(int i=0;i<n;i++) {
            System.out.print("Enter a["+i+"]:");
            a[i]= sc.nextInt();
        }

        System.out.print("Enter Location to delete:");
        loc= sc.nextInt();

        for(int i=loc;i<(a.length-1);i++)
            a[i]=a[i+1];

        for(int i=0;i<(a.length-1);i++)
            System.out.print(a[i]+",");
    }
}
