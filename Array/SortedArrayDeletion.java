import java.util.Scanner;

public class SortedArrayDeletion {
    public static void main(String[] args) {
        int n;
        int val;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        n= sc.nextInt();
        Integer a[]= new Integer[n];

        for(int i=0;i<n;i++) {
            System.out.print("Enter a["+i+"]:");
            a[i]= sc.nextInt();
        }
        System.out.print("Enter Number to insert:");
        val= sc.nextInt();
        int i;
        for(i=0;i<n;i++){
            if(a[i]==val){
                for (int j=i;j<(n-1);j++)
                    a[j]=a[j+1];
                break;
            }
        }

        if(i==n)
            System.out.println("element not found");
        else
            for(int j=0;j<(a.length-1);j++)
                System.out.print(a[j]+",");
    }
}
