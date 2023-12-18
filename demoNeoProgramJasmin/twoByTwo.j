.class public twoByTwo
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
	putstatic	twoByTwo/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LtwoByTwo;

	aload_0
	invokespecial	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

;
; FUNCTION rf_determinant
;
.method private static rf_determinant(Llibrary/Matrix;)F

.var 0 is m_2_matrix Llibrary/Matrix;
.var 1 is rf_determinant F
	aload	0
	ldc	0.0
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	aload	0
	ldc	1.0
	ldc	1.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fmul
	aload	0
	ldc	0.0
	ldc	1.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	aload	0
	ldc	1.0
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fmul
	fsub

	fstore_1
	fload	1
	freturn

.limit locals 2
.limit stack 11
.end method

;
; FUNCTION mf_2_inverse
;
.method private static mf_2_inverse(Llibrary/Matrix;)Llibrary/Matrix;

.var 0 is m_2_matrix Llibrary/Matrix;
.var 1 is m_2_result Llibrary/Matrix;
.var 2 is r_d F
.var 3 is r_temp F
.var 4 is mf_2_inverse Llibrary/Matrix;
	new	library/Matrix
	dup
	ldc	2
	invokespecial	library/Matrix/<init>(I)V
	astore	1
	aload	1
	ldc	0.0
	fstore	2
	ldc	0.0
	fstore	3
	aload	0
	invokestatic	twoByTwo/rf_determinant(Llibrary/Matrix;)F
	fstore_2
	aload	0
	ldc	0.0
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fstore_3
	aload	1
	ldc	0.0
	ldc	0.0
	aload	0
	ldc	1.0
	ldc	1.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	2
	fdiv
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	1
	ldc	1.0
	ldc	1.0
	fload	3
	fload	2
	fdiv
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	1
	ldc	0.0
	ldc	1.0
	aload	0
	ldc	0.0
	ldc	1.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	ldc	-1.0
	fmul
	fload	2
	fdiv
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	1
	ldc	1.0
	ldc	0.0
	aload	0
	ldc	1.0
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	ldc	-1.0
	fmul
	fload	2
	fdiv
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	1

	astore	4
	aload	4
	areturn

.limit locals 5
.limit stack 36
.end method

;
; MAIN
;
.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String;
.var 1 is _start Ljava/time/Instant;
.var 2 is _end Ljava/time/Instant;
.var 3 is _elapsed J
.var 4 is m_2_matrix Llibrary/Matrix;
.var 5 is m_2_matrixInverse Llibrary/Matrix;
.var 6 is m_2_matrixProduct Llibrary/Matrix;
.var 7 is r_matrixDet F
.var 8 is m_2_invertedMatrix Llibrary/Matrix;
.var 9 is r_matrixInverseDet F
.var 10 is r_matrixProductDet F
.var 11 is r_matrixDetProduct F
.var 12 is r_matrixDet1 F

	invokestatic	java/time/Instant/now()Ljava/time/Instant;
	astore_1
	new	library/Matrix
	dup
	ldc	2
	invokespecial	library/Matrix/<init>(I)V
	astore	4
	aload	4
	new	library/Matrix
	dup
	ldc	2
	invokespecial	library/Matrix/<init>(I)V
	astore	5
	aload	5
	new	library/Matrix
	dup
	ldc	2
	invokespecial	library/Matrix/<init>(I)V
	astore	6
	aload	6
	ldc	0.0
	fstore	7
	new	library/Matrix
	dup
	ldc	2
	invokespecial	library/Matrix/<init>(I)V
	astore	8
	aload	8
	ldc	0.0
	fstore	9
	ldc	0.0
	fstore	10
	ldc	0.0
	fstore	11
	ldc	0.0
	fstore	12

	aload	4
	ldc	0.0
	ldc	0.0
	ldc	2.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	1.0
	ldc	0.0
	ldc	3.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	0.0
	ldc	1.0
	ldc	-1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	ldc	1.0
	ldc	1.0
	ldc	-5.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	4
	invokestatic	twoByTwo/mf_2_inverse(Llibrary/Matrix;)Llibrary/Matrix;
	astore	5
	aload	5
	aload	4
	aload	5
	invokestatic	library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	astore	6
	aload	6
	aload	4
	invokestatic	twoByTwo/rf_determinant(Llibrary/Matrix;)F
	fstore	7
	aload	5
	invokestatic	twoByTwo/rf_determinant(Llibrary/Matrix;)F
	fstore	9
	aload	6
	invokestatic	twoByTwo/rf_determinant(Llibrary/Matrix;)F
	fstore	10
	aload	4
	invokestatic	twoByTwo/rf_determinant(Llibrary/Matrix;)F
	aload	5
	invokestatic	twoByTwo/rf_determinant(Llibrary/Matrix;)F
	fmul
	fstore	11
	aload	4
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	5
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	6
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	7
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	9
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	10
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	11
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	aload	4
	invokestatic	library/Matrix/inverse(Llibrary/Matrix;)Llibrary/Matrix;
	astore	8
	aload	8
	aload	4
	invokestatic	library/Matrix/determinant(Llibrary/Matrix;)F
	fstore	12
	aload	8
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	12
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop

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

.limit locals 105
.limit stack 88
.end method
