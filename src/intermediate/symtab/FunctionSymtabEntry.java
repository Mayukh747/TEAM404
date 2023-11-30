package intermediate.symtab;

public class FunctionSymtabEntry extends SymtabEntry{
    private int slotNumber = -1;

    FunctionSymtabEntry(String name, Symtab symtab) {
        super(name, symtab);
    }

    FunctionSymtabEntry(String name, int slotNumber, Symtab symtab) {
        super(name, symtab);
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
