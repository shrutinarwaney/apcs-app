
import java.io.*;

public class Kinematic extends Calculation implements Serializable {
    
    private Double vi;
    private Double vf;
    private Double a;
    private Double t;

    private int falseCount = 0;
    
    public String[] calculate() {
        String[] calculation = {getvi(), getvf(), geta(), gett()};
        // for( String s : calculation ) {
        //     System.out.println( s );
        // }
        return calculation;
    }

    public String historyDisplay() { // thisa is a history display
        String result = "";
        result += "Initial velocity: " + vi;
        result += " Final velocity: " + vf;
        result += " Acceleration: " + a;
        result += " Time: " + t + "\n";
        return result;
    }

    public Kinematic ( String viTxt, String vfTxt, String aTxt, String tTxt, boolean viTest, boolean vfTest, boolean aTest, boolean tTest) {
        falseCount = 0;

        if (viTxt.length() == 0){
            this.vi = null;
            falseCount++;
        } else {
            this.vi = Double.parseDouble(viTxt);
        }

        if( vfTxt.length() == 0 ) {
            this.vf = null;
            falseCount++;
        } else {
            this.vf = Double.parseDouble(vfTxt);    
        }

        if( aTxt.length() == 0 ) {
            this.a = null;
            falseCount++;
        } else {
            this.a = Double.parseDouble(aTxt);    
        }

        if (tTxt.length() == 0){
            this.t = null;
            falseCount++;
        } else {
            this.t = Double.parseDouble(tTxt);
        }
        
        if( falseCount > 1) {
            
        } else if ( viTest) {
            calculateInitial();
        } else if ( vfTest ) {
            calculateFinal();
        } else if ( aTest ) {
            calculateAcceleration();
        } else if ( tTest ) {
            calculateTime();
        }
    }
    
    public void calculateInitial() {
        vi = vf - a*t;
    }
    
    public void calculateFinal() {
        vf = vi + a*t;
    }
    
    public void calculateAcceleration() {
        a = (vf - vi)/t;
    }
    
    public void calculateTime() {
        t = (vf - vi)/a;
    }
    
    public String getvf() { 
        String s = "";
        
        if (falseCount > 1 && vf == null) {
            return "INVALID INPUTS";
        }
        
        s = String.valueOf(vf);
        while( s.length() < 100 ) {
            s = s + " ";
        }
        
        return s;
    }
    public String getvi() { 
        String s = "";
        
        if (falseCount > 1 && vi == null) {
            return "INVALID INPUTS";
        }
        
        s = String.valueOf(vi);
        while( s.length() < 50 ) {
            s = s + " ";
        }
        
        return s;  
    }
    public String geta() { 
        String s = "";
        
        if (falseCount > 1 && a == null) {
            return "INVALID INPUTS";
        }
        s = String.valueOf(a); 
        
        while( s.length() < 50 ) {
            s = s + " ";
        }
        return s;
    }
    public String gett() { 
        String s = "";
        if (falseCount > 1 && t == null) {
            return "INVALID INPUTS";
        }
        s = String.valueOf(t); 

        while( s.length() < 50 ) {
            s = s + " ";
        }
        return s;        
    }
}
