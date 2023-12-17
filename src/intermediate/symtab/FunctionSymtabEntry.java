package intermediate.symtab;

import intermediate.type.Typespec;
import java.util.ArrayList;

public class FunctionSymtabEntry extends SymtabEntry{
    private int slotNumber = -1;
    private Typespec returnType;
    private ArrayList<Typespec> parameterTypes;

    public FunctionSymtabEntry(String name, Symtab symtab) {
        super(name, symtab);
    }

    public FunctionSymtabEntry(String name, int slotNumber, Symtab symtab) {
        super(name, symtab);
        this.slotNumber = slotNumber;
    }

    public FunctionSymtabEntry(String name, Typespec returnType, ArrayList<Typespec> parameterTypes, Symtab symtab) {
        super(name, symtab);
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Typespec getReturnType() {
        return  returnType;
    }

    public ArrayList<Typespec> getParameterTypes() {
        return parameterTypes;
    }

}
