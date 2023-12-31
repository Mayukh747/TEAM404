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

    public static float determinant(Matrix m) {
        float[][] matrix = m.mat;
        int n = matrix.length;
        float det = 0;

        if (n == 1) {
            return matrix[0][0]; // Base case: If matrix size is 1x1, return the single element
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]; // Base case: For 2x2 matrix
        } else {
            for (int col = 0; col < n; col++) {
                float[][] subMatrix = new float[n - 1][n - 1];
                for (int i = 1; i < n; i++) {
                    int k = 0;
                    for (int j = 0; j < n; j++) {
                        if (j != col) {
                            subMatrix[i - 1][k] = matrix[i][j];
                            k++;
                        }
                    }
                }
                det += java.lang.Math.pow(-1, col) * matrix[0][col] * determinant(new Matrix(subMatrix));
            }
        }
        return det;
    }

    public static Matrix inverse(Matrix m) {


        float[][] matrix = m.mat;

        int n = matrix.length;
        if (n != matrix[0].length) {
            // Check if the matrix is square
            throw new IllegalArgumentException("Matrix should be square for inversion.");
        }

        float[][] augmentedMatrix = new float[n][2 * n];
        float[][] invertedMatrix = new float[n][n];

        // Create an augmented matrix [A | I] where I is the identity matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, augmentedMatrix[i], 0, n);
            for (int j = 0; j < matrix.length; j++){
                double scale = Math.pow(10, 8);
                augmentedMatrix[i][j] = (float) (Math.round(augmentedMatrix[i][j] * scale) / scale);
            }
            augmentedMatrix[i][n + i] = 1.0f;
        }

        // Perform Gaussian elimination
        for (int i = 0; i < n; i++) {
            float pivot = augmentedMatrix[i][i];
            if (pivot == 0) {
                throw new ArithmeticException("Matrix is singular, cannot be inverted.");
            }

            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= pivot;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    float factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        // Extract the inverted matrix from the augmented matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(augmentedMatrix[i], n, invertedMatrix[i], 0, n);
        }

        return new Matrix(invertedMatrix);
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
                System.out.printf("%.4f\t", mat[row][col]);
            }
            System.out.println();
        }
        System.out.println();
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
