import java.util.Scanner;

public class MatrixAddtion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row,col;
        System.out.print("enter Row Size:");
        row= sc.nextInt();
        System.out.print("enter Row Size:");
        col= sc.nextInt();
        int a[][] = new int[row][col];
        int b[][] = new int[row][col];
        int c[][] = new int[row][col];

        System.out.println("Enter Array-1");
        for (int i=0; i < row; i++) {
            for (int j=0;j<col ;j++) {
                System.out.print("Enter a["+i+"]["+j+"]:");
                a[i][j]= sc.nextInt();
            }
        }
        System.out.println("Enter Array-2 ");
        for (int i=0; i < row; i++) {
            for (int j=0;j<col ;j++) {
                System.out.print("Enter b["+i+"]["+j+"]:");
                b[i][j]= sc.nextInt();
                c[i][j]= a[i][j]+b[i][j];
            }
        }

        for (int i=0; i < row; i++) {
            for (int j=0;j<col ;j++)
                System.out.print(c[i][j]+" ");
            System.out.println();
        }
    }
}
