import java.util.*;

public class DNA extends Calculation {
    
    private String dna;
    private String cStrand;
    private String mrna;

    public DNA( String dna ) {
        this.dna = dna;
        createComplimentary();
        createmRNA();
    }

    public String[] calculate() {
        String[] calculation = {getDNA(), getmRNA(), getComplimentary()};
        return calculation;
    }

    public String historyDisplay() {
        String result = "";
        result += "DNA strand: " + getDNA();
        result += "\nmRNA strand: " + getmRNA();
        result += "\nComplimentary DNA strand: " + getComplimentary() + "\n";
        return result;
    }

    private void createComplimentary() {
        cStrand = dna.replaceAll( "A", "V" );
        cStrand = cStrand.replaceAll( "G", "W" );
        cStrand = cStrand.replaceAll( "C", "G" );
        cStrand = cStrand.replaceAll( "T", "A" );
        cStrand = cStrand.replaceAll( "V", "T" );
        cStrand = cStrand.replaceAll( "W", "C" );

        
    }

    private void createmRNA() {
        mrna = dna.replaceAll( "T", "U" );
    }

    public String getComplimentary() { return cStrand; }
    public String getmRNA() { return mrna; }
    public String getDNA() { return dna; }

}
