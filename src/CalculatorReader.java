import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class CalculatorReader {
    // ObjectInputStream in = null;
    
    ArrayList<String> calculations = new ArrayList<String>();
    public CalculatorReader() {
        // try {
        //     in = new ObjectInputStream( new BufferedInputStream( new FileInputStream( "SaveTo.dat" ) ) );
        //     in.mark(1000000000);
        //     calculations.clear();
        //     calculations = (ArrayList<Calculation>) in.readObject();
        //     for( Calculation c : calculations ) {
        //         System.out.println( c.historyDisplay() );
        //     }

        // } catch( Exception e ) {
        //     e.printStackTrace();
        //     System.out.println( "Class constructor" );
        // }

        try {
            BufferedReader in = new BufferedReader( new FileReader( "SaveTo.txt" ) );
            String line = null;
            while( ( line = in.readLine() ) != null ) {
                calculations.add( line );
            } 
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCalculations() {
        // try {
        //     in.reset();
        //     System.out.println( ":)" );
        //     calculations = (ArrayList<Calculation>) in.readObject();
        //     System.out.println(":(");
        //     for( Calculation c : calculations ) {
        //         System.out.println( c.historyDisplay() );
        //     }
        // } catch( Exception e ) {
        //     e.printStackTrace();
        //     System.out.println( "getCalculations" );
        //     System.out.println( "cry" );
        // }
        
        try {
            BufferedReader in = new BufferedReader( new FileReader( "SaveTo.txt" ) );
            String line = null;
            calculations.clear();
            while( ( line = in.readLine() ) != null ) {
                calculations.add( line );
                System.out.println(line);
            } 
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return calculations;
    }

    // public String display() {
    //     try { 
    //         calculations.clear();
    //         for (String s : calculations){
            
    //         } 
    //     } catch( Exception e ) {
    //         e.printStackTrace();
    //     }
        
        
    //     // calculations.clear();
    //     // try {
    //         // Calculation [] calculationDisplay = new Calculation[ in.readInt() ]; 
    //         // for( int i = 0; i < calculationDisplay.length; i++ ) {
    //         //     Calculation currentCalc = ( Calculation ) in.readObject();
    //         //     calculations.add( currentCalc );
    //         // }

    //     //     in.reset();
    //     //     calculations = (ArrayList<Calculation>) in.readObject();
    //     //     System.out.println( calculations.size() );
    //     //     for( Calculation c : calculations ) {
    //     //         System.out.println( "YYYYYYYTY" );
                
    //     //         System.out.println( c.historyDisplay() );
    //     //     }
    //     //  } catch( Exception e ) {
    //     //      e.printStackTrace();
    //     //      System.out.println( "Display" );
    //     //      System.out.println( calculations.size());
    //     //  }

    //     //  for( Calculation c : calculations ) {
    //     //     System.out.println(s);
    //     //     s += c.historyDisplay();
    //     //  }



    //      return s;
    // }

}
