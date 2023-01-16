import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;

/** ***************************************************
 *  Name:           your name
 *  Class:          CS20S
 * 
 *  Assignment:     Getting entire data records 
 * 
 *************************************************************/

public class CS20S001MixedDataInputRecords {

    public static void main(String[] args) throws IOException{
    // ***** constants *******
    
    // ***** variables *****
    
        String banner = "";             // output banner
        String prompt = "";             // prompt for user input
        
        String strin = "";              // string fro keyboard input
        String strout = "";             // string for formatted output
        
        String delim = "[ ]+";          // delimiter for splitting input records
        String[] tokens = null;         // used to split input records
        
        // a new line character that works on every computer system
        String nl = System.lineSeparator();
        
        String name;
        char initial;
        int age;
        double wage;
    
    // ***** objects *****
    
        Scanner scanner = new Scanner(System.in);
        //NumberFormat currency = NumberFormat.getCurrencyInstance();
    
    // ***** print banners *****
    
        banner = "*****************************" + nl;
        banner += "Name:        Sveinson" + nl;
        banner += "Class:       CS30S" + nl;
        banner += "Assignment:  MIxed type input" + nl;
        banner += "*****************************" + nl + nl;
        
        System.out.println(banner);
        //fout.print(banner);
    
    // ***** Get Input *****
    
        prompt = "Enter you first Inital and last name" + nl;
        prompt += "also enter your age and your wage" + nl;
        prompt += "Your input should look like this: " + nl;
        prompt += "E Newman 34 23.23";
        
        // System.out.println(prompt);
        // strin = scanner.nextLine();
        // System.out.println(strin);
        
        strin = JOptionPane.showInputDialog(banner + prompt);
        JOptionPane.showMessageDialog(null, banner + strin);
    
    // ***** Main Processing *****
    
        // step one: split the input string into tokens
        tokens = strin.split(delim);
        
        // changed "e newman 34 23.23"
        // into "e" "newman" "34" "23.23"
        
        // step two: parse each token into its appropriate variable
        initial = tokens[0].charAt(0);
        name = tokens[1];
        age = Integer.parseInt(tokens[2]);
        wage = Double.parseDouble(tokens[3]);
    
    // ***** Print Formatted Output *****
    
        System.out.println("here are the variables that have been parsed");
        System.out.println(initial);
        System.out.println(name);
        System.out.println(age);
        System.out.println(wage);
    
    // ***** Closing Message *****
    
        System.out.println();
        System.out.println("end of processing");
        //fout.println("End of Processing");
        
    } // end main 
    
} // end FormatTemplate
