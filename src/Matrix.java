public class Matrix {
    double[][] mat;

    public static double[][] mult(double[][] mat1, double[][] mat2){
        int rowsA = mat1.length;
        int colsA = mat1[0].length;
        int colsB = mat2[0].length;

        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    public static double[][] add(double[][] mat1, double[][] mat2){
        int row = mat1.length;
        int col = mat1[0].length;
        double[][] res = new double[row][col];

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                res[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return res;
    }
}
