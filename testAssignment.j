.class public testAssignment
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
	putstatic	testAssignment/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LtestAssignment;

	aload_0
	invokespecial	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

;
; FUNCTION rf_assign
;
.method private static rf_assign(FFLlibrary/Matrix;)F

.var 0 is r_a F
.var 1 is r_b F
.var 2 is m_5_someMatrixJustForTesting Llibrary/Matrix;
.var 3 is m_3_matrix Llibrary/Matrix;
.var 4 is r_c F
.var 5 is r_d F
	fload	5
	fstore	4
	fload	4
