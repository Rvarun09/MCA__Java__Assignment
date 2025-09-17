import java.util.Random;

public class MatrixOps {
    public static void main(String[] args) {
        int[][] A = createMatrix(2,2);
        int[][] B = createMatrix(2,2);

        display(A);
        display(B);

        int[][] sum = add(A,B);
        display(sum);

        int[][] sub = subtract(A,B);
        display(sub);

        int[][] mul = multiply(A,B);
        display(mul);

        int[][] trans = transpose(A);
        display(trans);
    }

    static int[][] createMatrix(int r, int c) {
        Random rand = new Random();
        int[][] m = new int[r][c];
        for (int i=0;i<r;i++)
            for (int j=0;j<c;j++)
                m[i][j] = rand.nextInt(10);
        return m;
    }

    static int[][] add(int[][] a,int[][] b){
        int r=a.length,c=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                res[i][j]=a[i][j]+b[i][j];
        return res;
    }

    static int[][] subtract(int[][] a,int[][] b){
        int r=a.length,c=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                res[i][j]=a[i][j]-b[i][j];
        return res;
    }

    static int[][] multiply(int[][] a,int[][] b){
        int r=a.length,c=b[0].length,n=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                for(int k=0;k<n;k++)
                    res[i][j]+=a[i][k]*b[k][j];
        return res;
    }

    static int[][] transpose(int[][] a){
        int r=a.length,c=a[0].length;
        int[][] res=new int[c][r];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                res[j][i]=a[i][j];
        return res;
    }

    static void display(int[][] a){
        for(int[] row:a){
            for(int v:row) System.out.print(v+" ");
            System.out.println();
        }
        System.out.println();
    }
}
