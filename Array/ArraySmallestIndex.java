import java.util.Scanner;

public class ArraySmallestIndex {
    public static void main(String[] args) {
        int n,min;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        n= sc.nextInt();
        Integer a[]= new Integer[n];

        for(int i=0;i<n;i++) {
            System.out.print("Enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        min=0;
        for(int i=0;i<n;i++) {
            if(a[i]<a[min])
                min=i;
        }
        System.out.println("smallest element is at position "+ min);
    }
}
