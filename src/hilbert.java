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
        Matrix m_10_A = new Matrix(10);
        Matrix m_10_Ainv = new Matrix(10);
        Matrix m_10_LU = new Matrix(10);
        Matrix m_10_b = new Matrix(10);
        Matrix m_10_x = new Matrix(10);
        Matrix m_10_scales = new Matrix(10);
        Matrix m_10_ps = new Matrix(10);
        r_n = 10.0F;

        for(r_i = 1.0F; Matrix.floatToInt(Matrix.realLessEq(r_i, r_n)) != 0; ++r_i) {
            Matrix.setEntry(m_10_ps, r_i, 0.0F, r_i);
            r_normrow = 0.0F;

            for(r_j = 1.0F; Matrix.floatToInt(Matrix.realLessEq(r_j, r_n)) != 0; ++r_j) {
                Matrix.setEntry(m_10_LU, r_i, r_j, Matrix.getEntry(m_10_A, r_i, r_j));
                if (Matrix.floatToInt(Matrix.realLessEq(r_normrow, rf_abs(Matrix.getEntry(m_10_LU, r_i, r_j)))) != 0) {
                    r_normrow = rf_abs(Matrix.getEntry(m_10_LU, r_i, r_j));
                }
            }

            if (Matrix.floatToInt(Matrix.booleanNot(Matrix.realEquals(r_normrow, 0.0F))) != 0) {
                Matrix.setEntry(m_10_scales, r_i, 0.0F, 1.0F / r_normrow);
            } else {
                Matrix.setEntry(m_10_scales, r_i, 0.0F, 0.0F);
            }
        }

        Instant _end = Instant.now();
        long _elapsed = Duration.between(_start, _end).toMillis();
        System.out.printf("\n[%,d milliseconds execution time.]\n", _elapsed);
    }
}
