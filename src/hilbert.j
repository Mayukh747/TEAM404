.class public hilbert
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
	putstatic	hilbert/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this Lhilbert;

	aload_0
	invokespecial	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

;
; FUNCTION rf_abs
;
.method private static rf_abs(F)F

.var 0 is r_x F
.var 1 is rf_abs F
	fload	0
	ldc	0.0
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L003
L001:
	ldc	-1.0
	fload	0
	fmul
	fstore_0
L003:
	fload	0

	fstore_1
	fload	1
	freturn

.limit locals 2
.limit stack 3
.end method

;
; FUNCTION mf_10_hilbert
;
.method private static mf_10_hilbert()Llibrary/Matrix;

.var 0 is m_10_h Llibrary/Matrix;
.var 1 is r_i F
.var 2 is r_j F
.var 3 is r_temp F
.var 4 is mf_10_hilbert Llibrary/Matrix;
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	0
	aload	0
	ldc	0.0
	fstore	1
	ldc	0.0
	fstore	2
	ldc	0.0
	fstore	3
L004:
	fload	1
	ldc	9.0
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L005
L006:
	fload	2
	ldc	9.0
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L007
	ldc	1.0
	fload	1
	fload	2
	fadd
	ldc	1.0
	fadd
	fdiv
	fstore_3
	aload	0
	fload	1
	fload	2
	fload	3
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	fload	2
	ldc	1.0
	fadd
	fstore_2
	goto	L006
L007:
	ldc	0.0
	fstore_2
	fload	1
	ldc	1.0
	fadd
	fstore_1
	goto	L004
L005:

	astore	4
	aload	4
	areturn

.limit locals 5
.limit stack 12
.end method

;
; MAIN
;
.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String;
.var 1 is _start Ljava/time/Instant;
.var 2 is _end Ljava/time/Instant;
.var 3 is _elapsed J
.var 4 is m_10_m Llibrary/Matrix;
.var 5 is m_10_mInv Llibrary/Matrix;
.var 6 is m_10_prod Llibrary/Matrix;
.var 7 is m_10_a Llibrary/Matrix;

	invokestatic	java/time/Instant/now()Ljava/time/Instant;
	astore_1
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	4
	aload	4
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	5
	aload	5
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	6
	aload	6
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	7
	aload	7

	invokestatic	hilbert/mf_10_hilbert()Llibrary/Matrix;
	astore	4
	aload	4
	aload	4
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	4
	invokestatic	library/Matrix/inverse(Llibrary/Matrix;)Llibrary/Matrix;
	astore	5
	aload	5
	aload	5
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	4
	aload	5
	invokestatic	library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	astore	6
	aload	6
	aload	5
	invokestatic	library/Matrix/inverse(Llibrary/Matrix;)Llibrary/Matrix;
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

.limit locals 105
.limit stack 45
.end method
