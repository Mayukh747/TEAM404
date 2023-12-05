import backend.Compiler;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

import antlr4.*;

import backend.*;
import intermediate.type.*;
import intermediate.symtab.*;
import frontend.*;


public class Neo {

    public static void main(String[] args) throws Exception
    {
        if (args.length != 2)
        {
            System.out.println("USAGE: PascalJava option sourceFileName");
            System.out.println("   option: -convert, -execute, or -compile");
            return;
        }

        String option = args[0];
        String sourceFileName = args[1];

        if (!option.equalsIgnoreCase("-compile")) {
            System.out.println("ERROR: Invalid option.");
            System.out.println("   Valid options: -convert, -execute, or -compile");
        }

        // Generate a source file listing.
        new Listing(sourceFileName);

        // Create the input stream.
        InputStream source = new FileInputStream(sourceFileName);

        // Create the character stream from the input stream.
        CharStream cs = CharStreams.fromStream(source);

        // Custom syntax error handler.
        SyntaxErrorHandler syntaxErrorHandler = new SyntaxErrorHandler();

        // Create a lexer which scans the character stream
        // to create a token stream.
        NeoLexer lexer = new NeoLexer(cs);
        lexer.removeErrorListeners();
        lexer.addErrorListener(syntaxErrorHandler);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser which parses the token stream.
        NeoParser parser = new NeoParser(tokens);

        // Pass 1: Check syntax and create the parse tree.
        System.out.printf("\nPASS 1 Syntax: ");
        parser.removeErrorListeners();
        parser.addErrorListener(syntaxErrorHandler);
        ParseTree tree = parser.program();

        int errorCount = syntaxErrorHandler.getCount();
        if (errorCount > 0)
        {
            System.out.printf("\nThere were %d syntax errors.\n", errorCount);
            System.out.println("Object file not created or modified.");
            return;
        }
        else
        {
            System.out.println("There were no syntax errors.");
        }

        // Pass 2: Semantic operations.
        System.out.printf("\nPASS 2 Semantics:\n");
        Semantics pass2 = new Semantics();
        pass2.visit(tree);

        errorCount = pass2.getErrorCount();
        if (errorCount > 0)
        {
            System.out.printf("\nThere were %d semantic errors.\n", errorCount);
            System.out.println("Object file not created or modified.");
            return;
        }

        // Pass 3: Compile the Pascal program.
        System.out.printf("\nPASS 3 Compilation: ");
        SymtabEntry programId = pass2.getProgramId();
        Compiler pass3 = new Compiler(programId);
        //pass3.visit(tree);

        try{
            pass3.visit(tree);
        } catch(Exception e){
            pass3.code.close();
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }


        System.out.printf("Object file \"%s\" created.\n",
                pass3.getObjectFileName());

    }
}
