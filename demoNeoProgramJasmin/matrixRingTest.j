.class public matrixRingTest
.super java/lang/Object

.field private static _sysin Ljava/util/Scanner;

;
; Runtime input scanner
;
.method static <clinit>()V

	new	java/util/Scanner
	dup
	getstatic	java/lang/System/in Ljava/io/InputStream;
	invokespecial	java/util/Scanner/<init>(Ljava/io/InputStream;)V
	putstatic	matrixRingTest/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LmatrixRingTest;

	aload_0
	invokespecial	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

;
; MAIN
;
.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String;
.var 1 is _start Ljava/time/Instant;
.var 2 is _end Ljava/time/Instant;
.var 3 is _elapsed J
.var 4 is m_6_matrix1 Llibrary/Matrix;
.var 5 is m_6_matrix2 Llibrary/Matrix;
.var 6 is m_6_matrix3 Llibrary/Matrix;
.var 7 is m_6_result Llibrary/Matrix;

	invokestatic	java/time/Instant/now()Ljava/time/Instant;
	astore_1
	new	library/Matrix
	dup
	ldc	6
	invokespecial	library/Matrix/<init>(I)V
	astore	4
	aload	4
	new	library/Matrix
	dup
	ldc	6
	invokespecial	library/Matrix/<init>(I)V
	astore	5
	aload	5
	new	library/Matrix
	dup
	ldc	6
	invokespecial	library/Matrix/<init>(I)V
	astore	6
	aload	6
	new	library/Matrix
	dup
	ldc	6
	invokespecial	library/Matrix/<init>(I)V
	astore	7
	aload	7

	aload	4
	ldc	0.0
	ldc	0.0
	ldc	10.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	0.0
	ldc	1.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	0.0
	ldc	2.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	0.0
	ldc	3.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	0.0
	ldc	4.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	0.0
	ldc	5.0
	ldc	8.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	1.0
	ldc	0.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	1.0
	ldc	1.0
	ldc	9.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	1.0
	ldc	2.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	1.0
	ldc	3.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	1.0
	ldc	4.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	1.0
	ldc	5.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	2.0
	ldc	0.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	2.0
	ldc	1.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	2.0
	ldc	2.0
	ldc	8.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	2.0
	ldc	3.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	2.0
	ldc	4.0
	ldc	9.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	2.0
	ldc	5.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	3.0
	ldc	0.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	3.0
	ldc	1.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	3.0
	ldc	2.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	3.0
	ldc	3.0
	ldc	8.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	3.0
	ldc	4.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	3.0
	ldc	5.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	4.0
	ldc	0.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	4.0
	ldc	1.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	4.0
	ldc	2.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	4.0
	ldc	3.0
	ldc	9.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	4.0
	ldc	4.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	4.0
	ldc	5.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	5.0
	ldc	0.0
	ldc	9.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	5.0
	ldc	1.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	5.0
	ldc	2.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	5.0
	ldc	3.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	5.0
	ldc	4.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	5.0
	ldc	5.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	0.0
	ldc	0.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	0.0
	ldc	1.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	0.0
	ldc	2.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	0.0
	ldc	3.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	0.0
	ldc	4.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	0.0
	ldc	5.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	1.0
	ldc	0.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	1.0
	ldc	1.0
	ldc	8.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	1.0
	ldc	2.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	1.0
	ldc	3.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	1.0
	ldc	4.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	1.0
	ldc	5.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	2.0
	ldc	0.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	2.0
	ldc	1.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	2.0
	ldc	2.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	2.0
	ldc	3.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	2.0
	ldc	4.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	2.0
	ldc	5.0
	ldc	9.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	3.0
	ldc	0.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	3.0
	ldc	1.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	3.0
	ldc	2.0
	ldc	8.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	3.0
	ldc	3.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	3.0
	ldc	4.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	3.0
	ldc	5.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	4.0
	ldc	0.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	4.0
	ldc	1.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	4.0
	ldc	2.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	4.0
	ldc	3.0
	ldc	9.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	4.0
	ldc	4.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	4.0
	ldc	5.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	5.0
	ldc	0.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	5.0
	ldc	1.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	5.0
	ldc	2.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	5.0
	ldc	3.0
	ldc	8.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	5.0
	ldc	4.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	5
	ldc	5.0
	ldc	5.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	0.0
	ldc	0.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	0.0
	ldc	1.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	0.0
	ldc	2.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	0.0
	ldc	3.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	0.0
	ldc	4.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	0.0
	ldc	5.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	1.0
	ldc	0.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	1.0
	ldc	1.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	1.0
	ldc	2.0
	ldc	9.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	1.0
	ldc	3.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	1.0
	ldc	4.0
	ldc	8.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	1.0
	ldc	5.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	2.0
	ldc	0.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	2.0
	ldc	1.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	2.0
	ldc	2.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	2.0
	ldc	3.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	2.0
	ldc	4.0
	ldc	9.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	2.0
	ldc	5.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	3.0
	ldc	0.0
	ldc	8.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	3.0
	ldc	1.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	3.0
	ldc	2.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	3.0
	ldc	3.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	3.0
	ldc	4.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	3.0
	ldc	5.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	4.0
	ldc	0.0
	ldc	5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	4.0
	ldc	1.0
	ldc	9.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	4.0
	ldc	2.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	4.0
	ldc	3.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	4.0
	ldc	4.0
	ldc	6.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	4.0
	ldc	5.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	5.0
	ldc	0.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	5.0
	ldc	1.0
	ldc	4.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	5.0
	ldc	2.0
	ldc	7.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	5.0
	ldc	3.0
	ldc	8.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	5.0
	ldc	4.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	6
	ldc	5.0
	ldc	5.0
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	aload	5
	invokestatic	library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	aload	6
	invokestatic	library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	astore	7
	aload	7
	aload	7
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	4
	aload	5
	aload	6
	invokestatic	library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	invokestatic	library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	astore	7
	aload	7
	aload	7
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	4
	aload	5
	aload	6
	invokestatic	library/Matrix/add(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	invokestatic	library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	astore	7
	aload	7
	aload	7
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	4
	aload	5
	invokestatic	library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	aload	4
	aload	6
	invokestatic	library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	invokestatic	library/Matrix/add(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	astore	7
	aload	7
	aload	7
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V

	invokestatic	java/time/Instant/now()Ljava/time/Instant;
	astore_2
	aload_1
	aload_2
	invokestatic	java/time/Duration/between(Ljava/time/temporal/Temporal;Ljava/time/temporal/Temporal;)Ljava/time/Duration;
	invokevirtual	java/time/Duration/toMillis()J
	lstore_3
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"\n[%,d milliseconds execution time.]\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	lload_3
	invokestatic	java/lang/Long/valueOf(J)Ljava/lang/Long;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop

	return

.limit locals 106
.limit stack 478
.end method
