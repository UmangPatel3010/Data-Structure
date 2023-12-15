import java.util.Scanner;

public class SortedArrayInsertion {
    public static void main(String[] args) {
        int n;
        int val;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        n= sc.nextInt();
        Integer a[]= new Integer[n+1];

        for(int i=0;i<n;i++) {
            System.out.print("Enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        System.out.print("Enter Number to insert:");
        val= sc.nextInt();
        int i;
        for(i=0;i<n;i++) {
            if(a[i]>=val) {
                for(int j=(a.length-1);j>i;j--)
                    a[j]=a[j-1];
                a[i]=val;
                break;
            }
        }

        if(i==n)
            a[i]=val;

        for (Integer ar:a) {
            System.out.print(ar+",");
        }
    }
}
