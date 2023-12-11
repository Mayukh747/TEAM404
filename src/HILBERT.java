//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import library.Matrix;

public class HILBERT {
    private static Scanner _sysin;

    static {
        _sysin = new Scanner(System.in);
    }

    public HILBERT() {
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
                ++r_j;
            }

            r_j = 0.0F;
        }

        return m_10_h;
    }

    public static void main(String[] args) {
        Instant _start = Instant.now();
        Matrix m_10_m = new Matrix(10);
        Matrix m_10_mInv = new Matrix(10);
        Matrix m_10_prod = new Matrix(10);
        Matrix m_10_a = new Matrix(10);
        m_10_m = mf_10_hilbert();
        Matrix.printMatrix(m_10_m);
        m_10_mInv = Matrix.inverse(m_10_m);
        Matrix.printMatrix(m_10_mInv);
        m_10_prod = Matrix.mult(m_10_m, m_10_mInv);
        m_10_a = Matrix.inverse(m_10_mInv);
        Matrix.printMatrix(m_10_a);
        Instant _end = Instant.now();
        long _elapsed = Duration.between(_start, _end).toMillis();
        System.out.printf("\n[%,d milliseconds execution time.]\n", _elapsed);
    }
}
