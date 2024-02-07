import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int[][] matrix = {
            {2, 0, 1, 2 },
            {1, 2, 0, 1 },
            {1, 0, 0, 1 },
            {2, 2, 2, 1,}
        };

        Matrix powMatrix = new Matrix(matrix); 
        powMatrix.powerMatrix(6);

        System.out.println("-> MATRIX <-");
        for (int[] is : matrix) {
            System.out.println(Arrays.toString(is));
        }

        System.out.println("\n--> MATRIX POWER BY 6 <--");
        for (int[] is : powMatrix.getMatrix()) {
            System.out.println(Arrays.toString(is));
        }

    }
}

class Matrix{
    int[][] matrix;
    Matrix (int[][] matrix){
        this.matrix = matrix;
    }

    public void powerMatrix(int n) {
        int[][] carry = matrix;
        int[][] ans = matrix;
        for (int row = 1; row < n; row++){
            ans = new int[matrix.length] [matrix[0].length];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[0].length; j++) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        ans[i][j] += carry[i][k] * matrix[k][j];
                    }
                }
            }
            carry = ans;
        }
        matrix = ans;
    }

    public int[][] getMatrix(){
        return matrix;
    }
}
