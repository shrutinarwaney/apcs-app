import java.io.*;
import java.util.ArrayList;

public class Tester { 
    public static void main(String[] args) {
        
        // ObjectOutputStream out = null;
        File f = new File( "SaveTo.dat" );
        RandomAccessFile in = null;
        try {
            // out = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream( "SaveTo.dat" ) ) );
            // PrintWriter o = new PrintWriter(new File("SaveTo.dat"));
            in = new RandomAccessFile( f , "rw");
            ArrayList<Calculation> a = new ArrayList<Calculation>();
            a.add( new DNA( "AGCGTCAGTGACAGT" ) );
            a.add( new DNA( "AGAGAGGAGGGFGG" ) );
            a.add( new DNA( "AGACGAACA" ) );
            // o.println("hi");
            // o.close();
            // out.writeObject( a );
            System.out.println("success");
            

            // out.close();

            
        } catch( Exception e ) {
            e.printStackTrace();
        }


    }

}
