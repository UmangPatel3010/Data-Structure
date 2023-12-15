import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int row_a,col_a,row_b,col_b;
        System.out.print("Enter Rows of First Matrix:");
        row_a = sc.nextInt();
        System.out.print("Enter Columns of First Matrix:");
        col_a = sc.nextInt();
        System.out.print("Enter Rows of Second Matrix:");
        row_b = sc.nextInt();
        System.out.print("Enter Columns of Second Matrix:");
        col_b = sc.nextInt();
        int[][] a=new int[row_a][col_a];
        int[][] b=new int[row_b][col_b];
        int[][] c=new int[row_a][col_b];

        if(col_a!=row_b)
            System.out.println("multiplication is not possible" );

        System.out.println("Enter Matrix-1");
        for(int i=0;i<row_a;i++) {
            for (int j=0;j<col_a;j++){
                System.out.print("Enter a["+i+"]["+j+"]:");
                a[i][j]= sc.nextInt();
            }
        }
        System.out.println("Enter Matrix-2");
        for(int i=0;i<row_b;i++) {
            for (int j=0;j<col_b;j++){
                System.out.print("Enter b["+i+"]["+j+"]:");
                b[i][j]= sc.nextInt();
            }
        }

        for (int i=0;i<row_a;i++){
            for (int j=0;j<col_b;j++) {
                for (int k=0;k<row_b;k++)
                    c[i][j]+= a[i][k]* b[k][j];
            }
        }
        for(int i=0;i<row_a;i++) {
            for (int j=0;j<col_b;j++){
                System.out.print(c[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
