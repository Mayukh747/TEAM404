.class public booleanTest
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
	putstatic	booleanTest/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LbooleanTest;

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
.var 4 is r_a F
.var 5 is r_b F
.var 6 is r_c F
.var 7 is r_d F
.var 8 is m_5_a Llibrary/Matrix;
.var 9 is m_5_b Llibrary/Matrix;
.var 10 is m_5_c Llibrary/Matrix;
.var 11 is m_5_d Llibrary/Matrix;

	invokestatic	java/time/Instant/now()Ljava/time/Instant;
	astore_1
	ldc	0.0
	fstore	4
	ldc	0.0
	fstore	5
	ldc	0.0
	fstore	6
	ldc	0.0
	fstore	7
	new	library/Matrix
	dup
	ldc	5
	invokespecial	library/Matrix/<init>(I)V
	astore	8
	aload	8
	new	library/Matrix
	dup
	ldc	5
	invokespecial	library/Matrix/<init>(I)V
	astore	9
	aload	9
	new	library/Matrix
	dup
	ldc	5
	invokespecial	library/Matrix/<init>(I)V
	astore	10
	aload	10
	new	library/Matrix
	dup
	ldc	5
	invokespecial	library/Matrix/<init>(I)V
	astore	11
	aload	11

	ldc	1.0
	fstore	4
	ldc	1.0
	fstore	5
	ldc	3.5
	fstore	6
	fload	4
	fload	5
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	fload	5
	fload	6
	invokestatic	library/Matrix/realEquals(FF)F
	fmul
	fload	6
	fload	7
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	invokestatic	library/Matrix/booleanOr(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L003
L001:
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	4
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
L003:
	fload	4
	fload	5
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	invokestatic	library/Matrix/booleanNot(F)F
	invokestatic	library/Matrix/booleanNot(F)F
	aload	9
	aload	8
	invokestatic	library/Matrix/matrixEquals(Llibrary/Matrix;Llibrary/Matrix;)F
	invokestatic	library/Matrix/booleanNot(F)F
	fload	6
	fload	4
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	invokestatic	library/Matrix/booleanNot(F)F
	fmul
	invokestatic	library/Matrix/booleanOr(FF)F
	fload	4
	fload	5
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	invokestatic	library/Matrix/booleanOr(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L006
L004:
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	6
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
L006:
	fload	4
	fload	5
	invokestatic	library/Matrix/realEquals(FF)F
	fload	6
	fload	7
	invokestatic	library/Matrix/realEquals(FF)F
	fmul
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L008
L007:
	aload	8
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	goto	L009
L008:
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	4
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
L009:

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
.limit stack 42
.end method
