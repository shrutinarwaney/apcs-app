import java.io.*;
import java.util.ArrayList;

public class Tester2 {
    public static void main(String[] args) {
        
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream( new BufferedInputStream( new FileInputStream( "SaveTo.dat" ) ) );
            ArrayList<Calculation> s = (ArrayList<Calculation>) in.readObject();
            for( Calculation c : s ) {
                System.out.println( c.historyDisplay() );
            }

            in.close();
        } catch( Exception e ) {
            e.printStackTrace();
        }

    }
}
