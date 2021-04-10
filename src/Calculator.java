import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Calculator { 
    // ObjectOutputStream out = null;
    // PrintWriter out = null;
    // ArrayList<Calculation> calculations = new ArrayList<Calculation>();
    ArrayList<String> calculations = new ArrayList<String>();
    Scanner fileScanner; 

    public Calculator( ArrayList<String> previousCals ) {
        // try {
        //     out = new ObjectOutputStream(
		// 	 new BufferedOutputStream(
		// 	 new FileOutputStream( "SaveTo.dat" ) ));
        //      for( Calculation b : calculations ) {
        //         System.out.println(b.historyDisplay());
        //     }
        //      for( Calculation c : previousCals ) {
        //          calculations.add( c );
        //      }

        //      for( Calculation b : previousCals ) {
        //         System.out.print( "XXX" );
        //         System.out.println(b.historyDisplay());
        //     }

        // } catch(Exception e) {
        //     e.printStackTrace();
        // }
        // calculations = previousCals;

        try {
          // PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( "SaveTo.txt", true ) ) ); 
          calculations = previousCals;
          //out.close();
        } catch( Exception e ) {
            e.printStackTrace();
        }

        

    }

    // public void newInput( Calculation c ) {
    //     calculations.add( c );
    //     for( Calculation b : calculations ) {
    //         System.out.println(b.historyDisplay());
            
    //     }
    //     try {
    //         out.writeObject( calculations );
    //     } catch( Exception e ) {
    //         e.printStackTrace();
    //     }
    // }

    public void newInput( String c ) {
        calculations.add( c );
        try {
            PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( "SaveTo.txt", true ) ) ); 
            out.println( c );
            out.close();
        } catch( Exception e ) {
            e.printStackTrace();
        }

    }
    

    // public void close() {
    //     try {
            
    //         out.close();
    //     } catch( Exception e ) {
    //         e.printStackTrace();
    //     }
    // }

}