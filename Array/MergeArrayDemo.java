import java.util.Scanner;

public class MergeArrayDemo {
    public static void main(String[] args) {
        int a1,a2,temp=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array-1:");
        a1= sc.nextInt();
        System.out.print("Enter size of array-2:");
        a2= sc.nextInt();
        Integer a[]= new Integer[a1];
        Integer b[]= new Integer[a2];
        Integer c[]= new Integer[a1+a2];

        System.out.println("Enter Array-1");
        for(int i=0;i<a1;i++,temp++) {
            System.out.print("Enter a["+i+"]:");
            a[i]= sc.nextInt();
            c[temp]=a[i];
        }
        System.out.println("Enter Array-2:");
        for(int i=0;i<a1;i++,temp++) {
            System.out.print("Enter a["+i+"]:");
            b[i]= sc.nextInt();
            c[temp]=b[i];
        }
        for (Integer i : c)
            System.out.print(i+",");
    }
}
