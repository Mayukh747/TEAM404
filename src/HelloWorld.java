public class HelloWorld
{
    private static java.util.Scanner _sysin = new java.util.Scanner(System.in);

    private static int i;

    public static void main(String[] args)
    {
        java.time.Instant _start = java.time.Instant.now();


        i = 0;
        do
        {
            i = i + 1;
            System.out.printf("#%1d: Hello, world!\n", i);
        }
        while (!(i == 5));

        java.time.Instant _end = java.time.Instant.now();
        long _elapsed = java.time.Duration.between(_start, _end).toMillis();
        System.out.printf("\n[%,d milliseconds execution time.]\n", _elapsed);
    }
}
