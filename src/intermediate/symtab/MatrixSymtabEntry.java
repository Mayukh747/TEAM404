package intermediate.symtab;

public class MatrixSymtabEntry extends SymtabEntry {
    private int slotNumber = -1;

    MatrixSymtabEntry(String name, Symtab symtab) {
        super(name, symtab);
    }

    MatrixSymtabEntry(String name, int slotNumber, Symtab symtab) {
        super(name, symtab);
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

}
