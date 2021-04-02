import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Calculator { 
    DataOutputStream out = null;
    ArrayList<Calculation> calculations;
    Scanner fileScanner; 

    public void newInput( Calculation c ) {
        calculations.add( c );
    }

    
}
