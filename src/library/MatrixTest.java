package library;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @org.junit.jupiter.api.Test
    void inverse() {
        //2x2 Identity
        Matrix m = new Matrix(2);
        Matrix.setEntry(m,0,0,1);
        Matrix.setEntry(m,1,1,1);

        Matrix.printMatrix(m);
        Matrix.inverse(m);
        Matrix.printMatrix(m);
        Matrix.inverse(m);
        Matrix.printMatrix(m);

    }

    @org.junit.jupiter.api.Test
    void inverseTest2() {
        float[][] matrixValues = {
                {1.0f, 0.5f, 0.3333f, 0.25f, 0.2f, 0.1167f, 0.1429f, 0.125f, 0.1111f, 0.1f},
                {0.5f, 0.3333f, 0.25f, 0.2f, 0.1667f, 0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f},
                {0.3333f, 0.25f, 0.2f, 0.1667f, 0.1429f, 0.1250f, 0.1111f, 0.1f, 0.0909f, 0.0833f},
                {0.25f, 0.2f, 0.1667f, 0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f},
                {0.2f, 0.1667f, 0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f},
                {0.1667f, 0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f},
                {0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f, 0.0625f},
                {0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f, 0.0625f, 0.0588f},
                {0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f, 0.0625f, 0.0588f, 0.0556f},
                {0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f, 0.0625f, 0.0588f, 0.0566f, 0.0526f}
        };

        Matrix matrix = new Matrix(10);
        matrix.mat = matrixValues;

        System.out.println("Original Matrix:");
        Matrix.printMatrix(matrix);

        try {
            Matrix invertedMatrix = Matrix.inverse(matrix);
            Matrix invInvMatrix = Matrix.inverse(invertedMatrix);

            System.out.println("\nInverted Matrix:");
            Matrix.printMatrix(invertedMatrix);
            System.out.println("\nInverted Inverted Matrix:");
            Matrix.printMatrix(invInvMatrix);

        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Matrix inversion failed: " + e.getMessage());
        }

        System.out.println("\nDeterminant: " + Matrix.determinant(matrix));

    }

    @org.junit.jupiter.api.Test
    void inverseTest3() {
        float[][] matrixValues = {
                {1.0f, 0.5f, 0.3333f, 0.25f, 0.2f, 0.1167f, 0.1429f, 0.125f, 0.1111f, 0.1f},
                {0.5f, 0.3333f, 0.25f, 0.2f, 0.1667f, 0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f},
                {0.3333f, 0.25f, 0.2f, 0.1667f, 0.1429f, 0.1250f, 0.1111f, 0.1f, 0.0909f, 0.0833f},
                {0.25f, 0.2f, 0.1667f, 0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f},
                {0.2f, 0.1667f, 0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f},
                {0.1667f, 0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f},
                {0.1429f, 0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f, 0.0625f},
                {0.125f, 0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f, 0.0625f, 0.0588f},
                {0.1111f, 0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f, 0.0625f, 0.0588f, 0.0556f},
                {0.1f, 0.0909f, 0.0833f, 0.0769f, 0.0714f, 0.0667f, 0.0625f, 0.0588f, 0.0566f, 0.0526f}
        };

        Matrix matrix = new Matrix(10);
        matrix.mat = matrixValues;

        System.out.println("Original Matrix:");
        Matrix.printMatrix(matrix);

        try {
            Matrix invertedMatrix = Matrix.inverse(matrix);
            Matrix invInvMatrix = Matrix.inverse(invertedMatrix);

            System.out.println("\nInverted Matrix:");
            Matrix.printMatrix(invertedMatrix);
            System.out.println("\nInverted Inverted Matrix:");
            Matrix.printMatrix(invInvMatrix);

        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Matrix inversion failed: " + e.getMessage());
        }

        System.out.println("\nDeterminant: " + Matrix.determinant(matrix));

    }
}