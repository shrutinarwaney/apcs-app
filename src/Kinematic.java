public class Kinematic extends Calculation {
    
    private double vi;
    private double vf;
    private double a;
    private double t;
    
    public String calculate( String inputs ) {
        return "";
    }

    public Kinematic ( double vi, double vf, double a, double t, boolean viTest, boolean vfTest, boolean aTest, boolean tTest) {
        this.vi = vi;
        this.vf = vf;
        this.a = a;
        this.t = t;
        
        if ( viTest) {
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
    
    public String getvf() { return String.valueOf(vf); }
    public String getvi() { return String.valueOf(vi); }
    public String geta() { return String.valueOf(a); }
    public String gett() { return String.valueOf(t); }
}
