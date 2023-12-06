package library;

public class Matrix {
    float[][] mat;

    public Matrix(int size) {
        mat = new float[size][size];
    }

    public Matrix(float [][] m){
        mat = m;
    }

    public static Matrix mult(Matrix matrix1, Matrix matrix2){

        float[][] mat1 = matrix1.mat;
        float[][] mat2 = matrix2.mat;

        int rowsA = mat1.length;
        int colsA = mat1[0].length;
        int colsB = mat2[0].length;

        float[][] result = new float[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2){
        float[][] mat1 = matrix1.mat;
        float[][] mat2 = matrix2.mat;

        int row = mat1.length;
        int col = mat1[0].length;
        float[][] res = new float[row][col];

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                res[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        return new Matrix(res);
    }

    public static Matrix sub(Matrix matrix1, Matrix matrix2){
        float[][] mat1 = matrix1.mat;
        float[][] mat2 = matrix2.mat;

        int row = mat1.length;
        int col = mat1[0].length;
        float[][] res = new float[row][col];

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                res[i][j] = mat1[i][j] - mat2[i][j];
            }
        }

        return new Matrix(res);
    }

    public static float getEntry(Matrix matrix, float row, float col) {
        return matrix.mat[(int) row][(int) col];
    }

    public static void setEntry(Matrix matrix, float row, float col, float val){
        matrix.mat[(int) row][(int) col] = val;
    }

    public static void printMatrix(Matrix matrix){
        float[][] mat = matrix.mat;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                System.out.printf("%4f\t", mat[row][col]);
            }
            System.out.println();
        }
    }

    public static float booleanNot(float value) {
        if (value == 0.0f) return 1.0f;
        else               return 0.0f;
    }
    public static float booleanOr(float val1, float val2) {
        if (val1 == 0.0f && val2 == 0.0) return 0.0f;
        else                             return 1.0f;
    }
    public static float realEquals(float x, float y) {
        if (x != y) return 0.0f;
        else        return 1.0f;
    }
    public static float realLessEq(float x, float y) {
        if (x > y) return 0.0f;
        else       return 1.0f;
    }
    public static float matrixEquals(Matrix matrix1, Matrix matrix2) {
        if (matrix1.mat.length != matrix2.mat.length)       return 0.0f;        // if different sizes
        if (matrix1.mat[0].length != matrix2.mat[0].length) return 0.0f;

        for (int i = 0; i < matrix1.mat.length; i++) {
            for (int j = 0; j < matrix1.mat.length; j++) {
                if (matrix1.mat[i][j] != matrix2.mat[i][j]) return 0.0f;
            }
        }

        return 1.0f;
    }

    public static int floatToInt(float x) {
        return (int) x;
    }
}
