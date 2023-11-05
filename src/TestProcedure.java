/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class TestProcedure {
    private static Scanner _sysin;
    private static int i;
    private static int j;
    private static boolean p;
    private static float x;
    private static float y;

    static {
        _sysin = new Scanner(System.in);
    }

    public TestProcedure() {
    }

    private static void alpha(int m, int n, float r, int k, int o, float w, float z, boolean q) {
        float a = (float)1;
        float b = (float)2;
        float c = a * b - w / z;
        int i = 3;
        k = k + i + j + n;
        q = p ^ true | i == j & !(w <= (float)2) & w / z == 1.5F;
        System.out.printf("alpha parms:  m = %d, n = %d, r = %4.2f, k = %d, o = %d, w = %4.2f, z = %4.2f, q = %b\n", m, n, r, k, o, w, r, q);
        System.out.printf("alpha locals: a = %4.2f, b = %4.2f, c = %4.2f, i = %d\n", a, b, c, Integer.valueOf(i));
    }

    private static void beta() {
        float i = (float)22;
        float j = (float)44;
        System.out.printf("beta locals:  Hello, world! %4.2f\n", i + j);
    }

    private static void gamma(int i, int n, float x, float r) {
        float a = (float)(i + n);
        float b = (float)i * x + r;
        float c = (float)i;
        i += n;
        System.out.printf("gamma parms:  i = %d, n = %d, x = %4.2f, r = %4.2f\n", i, n, x, r);
        System.out.printf("gamma locals: a = %4.2f, b = %4.2f, c = %4.2f\n", a, b, c);
    }

    public static void main(String[] args) {
        Instant _start = Instant.now();
        i = 5;
        j = 7;
        x = (float)3;
        y = (float)2;
        p = false;
        System.out.printf("main:         i = %d, j = %d, x = %4.2f, y = %4.2f, p = %b\n", i, j, x, y, p);
        alpha(6, i - 3, x + y / (float)i, i, j, x, y, p);
        System.out.printf("main:         i = %d, j = %d, x = %4.2f, y = %4.2f, p = %b\n", i, j, x, y, p);
        beta();
        System.out.printf("main:         i = %d, j = %d, x = %4.2f, y = %4.2f, p = %b\n", i, j, x, y, p);
        gamma(i, j, (float)i / x, (float)(i * j));
        System.out.printf("main:         i = %d, j = %d, x = %4.2f, y = %4.2f, p = %b\n", i, j, x, y, p);
        Instant _end = Instant.now();
        long _elapsed = Duration.between(_start, _end).toMillis();
        System.out.printf("\n[%,d milliseconds execution time.]\n", _elapsed);
    }
}
