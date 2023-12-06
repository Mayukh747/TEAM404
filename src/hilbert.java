//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import library.Matrix;

public class hilbert {
    private static Scanner _sysin;

    static {
        _sysin = new Scanner(System.in);
    }

    public hilbert() {
    }

    private static float rf_abs(float r_x) {
        if (Matrix.floatToInt(Matrix.realLessEq(r_x, 0.0F)) != 0) {
            r_x = -1.0F * r_x;
        }

        return r_x;
    }

    private static Matrix mf_10_hilbert() {
        Matrix m_10_h = new Matrix(10);
        float r_i = 0.0F;
        float r_j = 0.0F;

        for(float r_temp = 0.0F; Matrix.floatToInt(Matrix.realLessEq(r_i, 9.0F)) != 0; ++r_i) {
            while(Matrix.floatToInt(Matrix.realLessEq(r_j, 9.0F)) != 0) {
                r_temp = 1.0F / (r_i + r_j + 1.0F);
                Matrix.setEntry(m_10_h, r_i, r_j, r_temp);
                System.out.printf("%f\n", r_temp);
                ++r_j;
            }

            r_j = 0.0F;
        }

        return m_10_h;
    }

    public static void main(String[] args) {
        Instant _start = Instant.now();
        float r_n = 0.0F;
        float r_i = 0.0F;
        float r_j = 0.0F;
        float r_k = 0.0F;
        float r_normrow = 0.0F;
        float r_pivot = 0.0F;
        float r_size = 0.0F;
        float r_biggest = 0.0F;
        float r_mult = 0.0F;
        float r_pivotindex = 0.0F;
        float r_sigcode = 0.0F;
        Matrix m_10_A = new Matrix(10);
        Matrix m_10_Ainv = new Matrix(10);
        Matrix m_10_LU = new Matrix(10);
        Matrix m_10_b = new Matrix(10);
        Matrix m_10_x = new Matrix(10);
        Matrix m_10_scales = new Matrix(10);
        Matrix m_10_ps = new Matrix(10);
        r_n = 10.0F;

        for(r_i = 1.0F; Matrix.floatToInt(Matrix.realLessEq(r_i, r_n - 1.0F)) != 0; ++r_i) {
            Matrix.setEntry(m_10_ps, r_i, 0.0F, r_i);
            r_normrow = 0.0F;

            for(r_j = 1.0F; Matrix.floatToInt(Matrix.realLessEq(r_j, r_n - 1.0F)) != 0; ++r_j) {
                Matrix.setEntry(m_10_LU, r_i, r_j, Matrix.getEntry(m_10_A, r_i, r_j));
                if (Matrix.floatToInt(Matrix.realLessEq(r_normrow, rf_abs(Matrix.getEntry(m_10_LU, r_i, r_j)))) != 0) {
                    r_normrow = rf_abs(Matrix.getEntry(m_10_LU, r_i, r_j));
                }
            }

            r_j = 1.0F;
            if (Matrix.floatToInt(Matrix.booleanNot(Matrix.realEquals(r_normrow, 0.0F))) != 0) {
                Matrix.setEntry(m_10_scales, r_i, 0.0F, 1.0F / r_normrow);
            } else {
                Matrix.setEntry(m_10_scales, r_i, 0.0F, 0.0F);
            }
        }

        for(r_k = 1.0F; Matrix.floatToInt(Matrix.realLessEq(r_k, r_n - 2.0F)) != 0; r_i = r_k++) {
            r_pivot = 0.0F;
            r_biggest = 0.0F;

            for(r_i = r_k; Matrix.floatToInt(Matrix.realLessEq(r_i, r_n - 1.0F)) != 0; ++r_i) {
                r_size = rf_abs(Matrix.getEntry(m_10_LU, Matrix.getEntry(m_10_ps, r_i, 0.0F), r_k)) * Matrix.getEntry(m_10_scales, Matrix.getEntry(m_10_ps, r_i, 0.0F), 0.0F);
                if (Matrix.floatToInt(Matrix.realLessEq(r_biggest, r_size - 1.0F)) != 0) {
                    r_biggest = r_size;
                    r_pivotindex = r_i;
                }
            }
        }

        if (Matrix.floatToInt(Matrix.realEquals(r_biggest, 0.0F)) != 0) {
            r_sigcode = 100.0F;
            System.out.printf("%f\n", r_sigcode);
        } else {
            if (Matrix.floatToInt(Matrix.booleanNot(Matrix.realEquals(r_pivotindex, r_k))) != 0) {
                r_j = Matrix.getEntry(m_10_ps, r_k, 0.0F);
                Matrix.setEntry(m_10_ps, r_k, 0.0F, Matrix.getEntry(m_10_ps, r_pivotindex, 0.0F));
                Matrix.setEntry(m_10_ps, r_pivotindex, 0.0F, r_j);
            }

            r_pivot = Matrix.getEntry(m_10_LU, Matrix.getEntry(m_10_ps, r_pivotindex, 0.0F), r_k);

            for(r_i = r_k + 1.0F; Matrix.floatToInt(Matrix.realLessEq(r_i, r_n - 1.0F)) != 0; ++r_i) {
                r_mult = Matrix.getEntry(m_10_LU, Matrix.getEntry(m_10_ps, r_i, 0.0F), r_k) / r_pivot;
                Matrix.setEntry(m_10_LU, Matrix.getEntry(m_10_ps, r_i, 0.0F), r_k, r_mult);
                if (Matrix.floatToInt(Matrix.booleanNot(Matrix.realEquals(r_mult, 0.0F))) != 0) {
                    for(r_j = r_k + 1.0F; Matrix.floatToInt(Matrix.realLessEq(r_j, r_n - 1.0F)) != 0; ++r_j) {
                        Matrix.setEntry(m_10_LU, Matrix.getEntry(m_10_ps, r_i, 0.0F), r_j, Matrix.getEntry(m_10_LU, Matrix.getEntry(m_10_ps, r_i, 0.0F), r_j) - r_mult * Matrix.getEntry(m_10_LU, Matrix.getEntry(m_10_ps, r_k, 0.0F), r_j));
                    }
                }
            }
        }

        if (Matrix.floatToInt(Matrix.realEquals(Matrix.getEntry(m_10_LU, Matrix.getEntry(m_10_ps, r_n - 1.0F, 0.0F), r_n - 1.0F), 0.0F)) != 0) {
            r_sigcode = 200.0F;
            System.out.printf("%f\n", r_sigcode);
        }

        System.out.printf("%f\n", r_i);
        System.out.printf("%f\n", r_k);
        Matrix.printMatrix(m_10_LU);
        m_10_LU = mf_10_hilbert();
        Matrix.printMatrix(m_10_LU);
        Instant _end = Instant.now();
        long _elapsed = Duration.between(_start, _end).toMillis();
        System.out.printf("\n[%,d milliseconds execution time.]\n", _elapsed);
    }
}
