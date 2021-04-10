
import java.io.*;
// for history
public class Starter extends Calculation implements Serializable {
    
    public String[] calculate() {
        String[] calculation = {" "};
        return calculation;
    }

    public String historyDisplay() { // this is a is a history display
        String result = "";
        result = "Start of hisory: ";
        while( result.length() < 50 ) {
            result += " ";
        }
        return result;
    }

}
