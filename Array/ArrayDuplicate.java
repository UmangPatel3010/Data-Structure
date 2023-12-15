import java.util.Scanner;

public class ArrayDuplicate {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        n= sc.nextInt();
        Integer a[]= new Integer[n];

        for(int i=0;i<n;i++) {
            System.out.print("Enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        for(int i=0;i<n;i++) {
            for (int j=0;j<n;j++ ){
                if(i==j)
                    continue;
                if(a[i]==a[j]) {
                    System.out.print("Array contains Duplicate ");
                    System.exit(0);
                }
            }
        }
        System.out.println("Array does not contain Duplicate ");
    }
}
