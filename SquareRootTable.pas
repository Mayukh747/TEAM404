PROGRAM SquareRootTable;

VAR
    whole, frac : integer;
    number : real;

FUNCTION sqroot(n: real) : real;
    VAR
        root, prev, diff : real;

    BEGIN
        root := n;
        prev := root;

        REPEAT
            root := (n/root + root)/2;
            diff := prev - root;
            prev := root;
        UNTIL diff < 0.0000001;

        sqroot := root;
    END;

BEGIN
    writeln('Square Root Table');
    writeln;
    write('     ');

    FOR frac := 0 TO 9 DO BEGIN
        write(frac/10.0:10:1);
    END;
    writeln;

    FOR whole := 1 TO 25 DO BEGIN
        write(whole:5);

        FOR frac := 0 TO 9 DO BEGIN
            number := whole + frac/10.0;

            write(sqroot(number):10:6);
        END;

        writeln;
    END;
END.