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

    private void createComplimentary() {
        cStrand = dna.replaceAll( "A", "T" );
        cStrand = cStrand.replaceAll( "G", "C" );
        cStrand = cStrand.replaceAll( "C", "G" );
        cStrand = cStrand.replaceAll( "T", "A" );
    }

    private void createmRNA() {
        mrna = dna.replaceAll( "T", "U" );
    }

    public String getComplimentary() { return cStrand; }
    public String getmRNA() { return mrna; }
    public String getDNA() { return dna; }

}
