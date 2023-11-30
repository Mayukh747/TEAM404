.class public demoNeoProgram
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
	putstatic	demoNeoProgram/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LdemoNeoProgram;

	aload_0
	invokespecial	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

;
; FUNCTION rf_add
;
.method private static rf_add(FFLlibrary/Matrix;)F

.var 0 is r_a F
.var 1 is r_b F
.var 2 is m_5_someMatrixJustForTesting Llibrary/Matrix;
.var 3 is m_3_matrix Llibrary/Matrix;
.var 4 is r_c F
.var 5 is r_d F
	fstore	-1

	fload	0
	freturn

.limit locals 7
.limit stack 0
.end method

;
; MAIN
;
.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String;
.var 1 is _start Ljava/time/Instant;
.var 2 is _end Ljava/time/Instant;
.var 3 is _elapsed J

	invokestatic	java/time/Instant/now()Ljava/time/Instant;
	astore_1
.var 4 is r_variable F
.var 5 is m_50_A Llibrary/Matrix;
.var 6 is m_50_B Llibrary/Matrix;
.var 7 is r_n F

	fstore	-1
	fstore	-1
	fstore	-1
	fstore	-1
	fstore	-1
	fstore	-1
	fstore	-1
	fstore	-1

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

.limit locals 12
.limit stack 7
.end method
