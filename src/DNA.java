import java.io.*;

public class DNA extends Calculation implements Serializable {
    
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
        result += " mRNA strand: " + getmRNA();
        result += " Complimentary DNA strand: " + getComplimentary() + "\n";
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
    public String getmRNA() {
        while ( mrna.length() < 50 ) {
            mrna += " ";
        }
        return mrna; 
    }
    public String getDNA() { 
        while( dna.length() < 50 ) {
            dna += " ";
        }
        return dna;
    }

}
