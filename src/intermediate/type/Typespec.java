package intermediate.type;

import intermediate.symtab.*;

import java.util.ArrayList;

/**
 * <h1>Typespec</h1>
 *
 * <p>The type specification object for various datatypes.</p>
 *
 * <p>Copyright (c) 2020 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class Typespec
{
    private Form form;               // type form
    private SymtabEntry identifier;  // type identifier
    private TypeInfo info;           // type information
    
    public enum Form
    {
        SCALAR;

        public String toString() { return super.toString().toLowerCase(); }
    }

    
    /**
     * Type information interface.
     */
    private interface TypeInfo {}
    
    /**
     * Enumeration type information.
     */
    private class EnumerationInfo implements TypeInfo
    {
        private ArrayList<SymtabEntry> constants;
    }
    

    /**
     * Constructor.
     * @param form the type form.
     */
    public Typespec(Form form)
    {
        this.form = form;
        this.identifier = null;
        
        // Initialize the appropriate type information.
        switch (form)
        {
                
            default: break;
        }
    }

//    /**
//     * Determine whether or not the type is structured (array or record).
//     * @return true if structured, false if not.
//     */
//    public boolean isStructured()
//    {
//        return (form == Form.ARRAY) || (form == Form.RECORD);
//    }

    /**
     * Get the type form.
     * @return the form.
     */
    public Form getForm() { return form; }

    /**
     * Get the type identifier.
     * @return the identifier's symbol table entry.
     */
    public SymtabEntry getIdentifier() { return identifier; }

    /**
     * Setter.
     * @param identifier the type identifier (symbol table entry).
     */
    public void setIdentifier(SymtabEntry identifier)
    {
        this.identifier = identifier;
    }

    /**
     * Get the base type of this type.
     * @return the base type.
     */
    public Typespec baseType()
    {
        return this;
    }


}
