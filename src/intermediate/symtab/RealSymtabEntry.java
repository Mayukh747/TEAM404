package intermediate.symtab;

public class RealSymtabEntry extends SymtabEntry{
    private int slotNumber = -1;

    RealSymtabEntry(String name, Symtab symtab) {
        super(name, symtab);
    }

    RealSymtabEntry(String name, int slotNumber, Symtab symtab) {
        super(name, symtab);
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
