.class public treeTheoremTest
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
	putstatic	treeTheoremTest/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LtreeTheoremTest;

	aload_0
	invokespecial	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

;
; FUNCTION mf_4_adjacencyToDegree
;
.method private static mf_4_adjacencyToDegree(Llibrary/Matrix;)Llibrary/Matrix;

.var 0 is m_4_adjacencyMatrix Llibrary/Matrix;
.var 1 is r_row F
.var 2 is r_col F
.var 3 is r_degree F
.var 4 is m_4_degreeMatrix Llibrary/Matrix;
.var 5 is mf_4_adjacencyToDegree Llibrary/Matrix;
	ldc	0.0
	fstore	1
	ldc	0.0
	fstore	2
	ldc	0.0
	fstore	3
	new	library/Matrix
	dup
	ldc	4
	invokespecial	library/Matrix/<init>(I)V
	astore	4
	aload	4
	ldc	0.0
	fstore_1
L001:
	fload	1
	ldc	3.5
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L002
	ldc	0.0
	fstore_3
	ldc	0.0
	fstore_2
L003:
	fload	2
	ldc	3.5
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L004
	fload	3
	aload	0
	fload	1
	fload	2
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	fadd
	fstore_3
	fload	2
	ldc	1.0
	fadd
	fstore_2
	goto	L003
L004:
	aload	4
	fload	1
	fload	1
	fload	3
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
	fload	1
	ldc	1.0
	fadd
	fstore_1
	goto	L001
L002:
	aload	4

	astore	5
	aload	5
	areturn

.limit locals 6
.limit stack 13
.end method

;
; FUNCTION mf_4_makeLaplacian
;
.method private static mf_4_makeLaplacian(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;

.var 0 is m_4_degreeMatrix Llibrary/Matrix;
.var 1 is m_4_adjacencyMatrix Llibrary/Matrix;
.var 2 is mf_4_makeLaplacian Llibrary/Matrix;
	aload	0
	aload	1
	invokestatic	library/Matrix/sub(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;

	astore_2
	aload	2
	areturn

.limit locals 3
.limit stack 13
.end method

;
; FUNCTION mf_3_removeRowAndCol
;
.method private static mf_3_removeRowAndCol(Llibrary/Matrix;FF)Llibrary/Matrix;

.var 0 is m_4_matrix Llibrary/Matrix;
.var 1 is r_rowToRemove F
.var 2 is r_colToRemove F
.var 3 is m_3_result Llibrary/Matrix;
.var 4 is r_row F
.var 5 is r_col F
.var 6 is r_reducedRow F
.var 7 is r_reducedCol F
.var 8 is mf_3_removeRowAndCol Llibrary/Matrix;
	new	library/Matrix
	dup
	ldc	3
	invokespecial	library/Matrix/<init>(I)V
	astore	3
	aload	3
	ldc	0.0
	fstore	4
	ldc	0.0
	fstore	5
	ldc	0.0
	fstore	6
	ldc	0.0
	fstore	7
	ldc	0.0
	fstore	4
L005:
	fload	4
	ldc	3.5
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L006
	ldc	0.0
	fstore	5
L007:
	fload	5
	ldc	3.5
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L008
	fload	4
	fload	1
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	fload	5
	fload	2
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	fmul
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L011
L009:
	fload	1
	fload	4
	invokestatic	library/Matrix/realLessEq(FF)F
	fload	1
	fload	4
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	fmul
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L013
L012:
	fload	4
	ldc	1.0
	fsub
	fstore	6
	goto	L014
L013:
	fload	4
	fstore	6
L014:
	fload	2
	fload	5
	invokestatic	library/Matrix/realLessEq(FF)F
	fload	2
	fload	5
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	fmul
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L016
L015:
	fload	5
	ldc	1.0
	fsub
	fstore	7
	goto	L017
L016:
	fload	5
	fstore	7
L017:
	aload	3
	fload	6
	fload	7
	aload	0
	fload	4
	fload	5
	invokestatic	library/Matrix/getEntry(Llibrary/Matrix;FF)F
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
L011:
	fload	5
	ldc	1.0
	fadd
	fstore	5
	goto	L007
L008:
	fload	4
	ldc	1.0
	fadd
	fstore	4
	goto	L005
L006:
	aload	3

	astore	8
	aload	8
	areturn

.limit locals 9
.limit stack 31
.end method

;
; MAIN
;
.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String;
.var 1 is _start Ljava/time/Instant;
.var 2 is _end Ljava/time/Instant;
.var 3 is _elapsed J
.var 4 is m_4_adjacencyMatrix Llibrary/Matrix;
.var 5 is m_4_degreeMatrix Llibrary/Matrix;
.var 6 is m_4_laplacianMatrix Llibrary/Matrix;
.var 7 is m_3_reducedLaplacian Llibrary/Matrix;
.var 8 is r_col F
.var 9 is r_row F
.var 10 is r_determinant F

	invokestatic	java/time/Instant/now()Ljava/time/Instant;
	astore_1
	new	library/Matrix
	dup
	ldc	4
	invokespecial	library/Matrix/<init>(I)V
	astore	4
	aload	4
	new	library/Matrix
	dup
	ldc	4
	invokespecial	library/Matrix/<init>(I)V
	astore	5
	aload	5
	new	library/Matrix
	dup
	ldc	4
	invokespecial	library/Matrix/<init>(I)V
	astore	6
	aload	6
	new	library/Matrix
	dup
	ldc	3
	invokespecial	library/Matrix/<init>(I)V
	astore	7
	aload	7
	ldc	0.0
	fstore	8
	ldc	0.0
	fstore	9
	ldc	0.0
	fstore	10

	ldc	0.0
	fstore	9
L018:
	fload	9
	ldc	3.5
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L019
	ldc	0.0
	fstore	8
L020:
	fload	8
	ldc	3.5
	invokestatic	library/Matrix/realLessEq(FF)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L021
	fload	9
	fload	8
	invokestatic	library/Matrix/realEquals(FF)F
	invokestatic	library/Matrix/booleanNot(F)F
	invokestatic	library/Matrix/floatToInt(F)I
	ifeq	L024
L022:
	aload	4
	fload	9
	fload	8
	ldc	1.0
	invokestatic	library/Matrix/setEntry(Llibrary/Matrix;FFF)V
L024:
	fload	8
	ldc	1.0
	fadd
	fstore	8
	goto	L020
L021:
	fload	9
	ldc	1.0
	fadd
	fstore	9
	goto	L018
L019:
	aload	4
	invokestatic	treeTheoremTest/mf_4_adjacencyToDegree(Llibrary/Matrix;)Llibrary/Matrix;
	astore	5
	aload	5
	aload	5
	aload	4
	invokestatic	treeTheoremTest/mf_4_makeLaplacian(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;
	astore	6
	aload	6
	aload	6
	ldc	0.0
	ldc	0.0
	invokestatic	treeTheoremTest/mf_3_removeRowAndCol(Llibrary/Matrix;FF)Llibrary/Matrix;
	astore	7
	aload	7
	aload	7
	invokestatic	library/Matrix/determinant(Llibrary/Matrix;)F
	fstore	10
	aload	4
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	5
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	6
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
	aload	7
	invokestatic	library/Matrix/printMatrix(Llibrary/Matrix;)V
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

.limit locals 109
.limit stack 75
.end method
