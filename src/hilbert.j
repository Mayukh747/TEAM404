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
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	3
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
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
.limit stack 16
.end method

;
; MAIN
;
.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String;
.var 1 is _start Ljava/time/Instant;
.var 2 is _end Ljava/time/Instant;
.var 3 is _elapsed J
.var 4 is r_n F
.var 5 is r_i F
.var 6 is r_j F
.var 7 is r_k F
.var 8 is r_normrow F
.var 9 is r_pivot F
.var 10 is r_size F
.var 11 is r_biggest F
.var 12 is r_mult F
.var 13 is r_pivotindex F
.var 14 is r_sigcode F
.var 15 is m_10_A Llibrary/Matrix;
.var 16 is m_10_Ainv Llibrary/Matrix;
.var 17 is m_10_LU Llibrary/Matrix;
.var 18 is m_10_b Llibrary/Matrix;
.var 19 is m_10_x Llibrary/Matrix;
.var 20 is m_10_scales Llibrary/Matrix;
.var 21 is m_10_ps Llibrary/Matrix;

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
	ldc	0.0
	fstore	8
	ldc	0.0
	fstore	9
	ldc	0.0
	fstore	10
	ldc	0.0
	fstore	11
	ldc	0.0
	fstore	12
	ldc	0.0
	fstore	13
	ldc	0.0
	fstore	14
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	15
	aload	15
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	16
	aload	16
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	17
	aload	17
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	18
	aload	18
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	19
	aload	19
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	20
	aload	20
	new	library/Matrix
	dup
	ldc	10
	invokespecial	library/Matrix/<init>(I)V
	astore	21
	aload	21

	ldc	10.0
	fstore	4
	ldc	1.0
	fstore	5
L008:
	fload	5
	fload	4
	ldc	1.0
	fsub
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L009
	aload	21
	fload	5
	ldc	0.0
	fload	5
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	ldc	0.0
	fstore	8
	ldc	1.0
	fstore	6
L010:
	fload	6
	fload	4
	ldc	1.0
	fsub
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L011
	aload	17
	fload	5
	fload	6
	aload	15
	fload	5
	fload	6
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	fload	8
	aload	17
	fload	5
	fload	6
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	invokestatic	hilbert/rf_abs(F)F
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L014
L012:
	aload	17
	fload	5
	fload	6
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	invokestatic	hilbert/rf_abs(F)F
	fstore	8
L014:
	fload	6
	ldc	1.0
	fadd
	fstore	6
	goto	L010
L011:
	ldc	1.0
	fstore	6
	fload	8
	ldc	0.0
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L016
L015:
	aload	20
	fload	5
	ldc	0.0
	ldc	1.0
	fload	8
	fdiv
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	goto	L017
L016:
	aload	20
	fload	5
	ldc	0.0
	ldc	0.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
L017:
	fload	5
	ldc	1.0
	fadd
	fstore	5
	goto	L008
L009:
	ldc	1.0
	fstore	7
L018:
	fload	7
	fload	4
	ldc	2.0
	fsub
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L019
	ldc	0.0
	fstore	9
	ldc	0.0
	fstore	11
	fload	7
	fstore	5
L020:
	fload	5
	fload	4
	ldc	1.0
	fsub
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L021
	aload	17
	aload	21
	fload	5
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	7
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	invokestatic	hilbert/rf_abs(F)F
	aload	20
	aload	21
	fload	5
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fmul
	fstore	10
	fload	11
	fload	10
	ldc	1.0
	fsub
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L024
L022:
	fload	10
	fstore	11
	fload	5
	fstore	13
L024:
	fload	5
	ldc	1.0
	fadd
	fstore	5
	goto	L020
L021:
	fload	7
	fstore	5
	fload	7
	ldc	1.0
	fadd
	fstore	7
	goto	L018
L019:
	fload	11
	ldc	0.0
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L026
L025:
	ldc	100.0
	fstore	14
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	14
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	goto	L027
L026:
	fload	13
	fload	7
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L030
L028:
	aload	21
	fload	7
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fstore	6
	aload	21
	fload	7
	ldc	0.0
	aload	21
	fload	13
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	aload	21
	fload	13
	ldc	0.0
	fload	6
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
L030:
	aload	17
	aload	21
	fload	13
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	7
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fstore	9
	fload	7
	ldc	1.0
	fadd
	fstore	5
L031:
	fload	5
	fload	4
	ldc	1.0
	fsub
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L032
	aload	17
	aload	21
	fload	5
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	7
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	9
	fdiv
	fstore	12
	aload	17
	aload	21
	fload	5
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	7
	fload	12
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	fload	12
	ldc	0.0
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L035
L033:
	fload	7
	ldc	1.0
	fadd
	fstore	6
L036:
	fload	6
	fload	4
	ldc	1.0
	fsub
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L037
	aload	17
	aload	21
	fload	5
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	6
	aload	17
	aload	21
	fload	5
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	6
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	12
	aload	17
	aload	21
	fload	7
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	6
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fmul
	fsub
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	fload	6
	ldc	1.0
	fadd
	fstore	6
	goto	L036
L037:
L035:
	fload	5
	ldc	1.0
	fadd
	fstore	5
	goto	L031
L032:
L027:
	aload	17
	aload	21
	fload	4
	ldc	1.0
	fsub
	ldc	0.0
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fload	4
	ldc	1.0
	fsub
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	ldc	0.0
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L040
L038:
	ldc	200.0
	fstore	14
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	14
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
L040:
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%f\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	fload	5
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
	fload	7
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	aload	17
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	invokestatic	hilbert/mf_10_hilbert()Llibrary/Matrix;
	astore	17
	aload	17
	aload	17
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
.limit stack 136
.end method
