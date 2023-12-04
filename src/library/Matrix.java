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

    public static float getEntry(Matrix matrix, float row, float col) {
        return matrix.mat[(int) row][(int) col];
    }

    public static void setEntry(Matrix matrix, float row, float col, float val){
        matrix.mat[(int) row][(int) col] = (int) val;
    }

    public static void printMatrix(Matrix matrix){
        float[][] mat = matrix.mat;

        String out = new String();
        for(float[] arr: mat){
            for(float f: arr){
                out += (String.valueOf(f) + "\t");
            }
            out += ("\n");
        }
        System.out.println(out);
    }
}
