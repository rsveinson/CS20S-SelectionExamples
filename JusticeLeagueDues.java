/* *************************************
 * Programmer:  Sveinson
 * Class:       CS20S 0X
 * 
 * Assignment:  Lab 5 Ex 1 calculate club dues
 * 
 * Description: calculate dues owing based on age, months and monthly fee
 ***************************************** */
// **** import Java class Libraries ****
import java.util.Scanner;
import javax.swing.*;
import java.text.NumberFormat;
import java.awt.Font;

public class JusticeLeagueDues{
    public static void main(String[] args){
        // ******* declare constants *******

        // set constants for month charge
        final double ADULTFEE = 19.95;
        final double JUNIORFEE = 11.95;

        final int AGETHRESHOLD = 18;       // age cut off between adult and junior

        // ******* declare variables *******

        String banner = "";
        String strin = "";         // general input string
        String strout = "";        // general output string
        String prompt = "";        // prompt for user input

        String delim = "[ ]+";     // Delimiter for user input strings
        String[] tokens = null;    // an array to hold input tokens
        String nl = System.lineSeparator();    // universal newline character

        String name = "";          // member's name
        int age = 0;               // member's age
        int months = 0;            // number of months owing
        double dues = 0.0;         // member's dues owing

        // ******* create objects *******

        //Scanner scanner = new Scanner(System.in);      // connect to the keyboard
        NumberFormat cf = NumberFormat.getCurrencyInstance();  // use for formatting currency

        // ******* output banner *******

        banner = "************************\n";
        banner = banner + "Name: Sveinson\n";
        banner += "Class: CS20S-01\n";
        banner += "Assignment: Lab 5 Ex1\n";
        banner += "************************\n\n";

        System.out.println(banner);

        // ******* get input *******

        prompt = "Enter your name, age, and months of membership.";
        prompt += nl;
        strin = JOptionPane.showInputDialog(banner + prompt);
        JOptionPane.showMessageDialog(null, banner + "You entered: " + strin);

        /* the record is read in as a string so now
         * we have
         * "bob 15 23"  one string containing all of the input
         */

        // split and parse input string
        tokens = strin.split(delim); 
        /* split does just what it sounds like, it splits the 
         * string into tokens, each token is also a string
         * "bob"  "15"  "23
         * each token is numbered with and index stargting at 0
         * so tokens[0] is "bob", tokens[1] is "15" and tokens[2] is "23"
         */ 

        // parse input into variable

        // use a try catch block to catch runtime exceptions
        try{
            name = tokens[0];                      // name is a string so no parsing is needed
            age = Integer.parseInt(tokens[1]);     // "15" must converted to 15 (String to int)
            months = Integer.parseInt(tokens[2]);  // "23" must converted to 23 (String to int)
        } // end try
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Input Error: \nenter integer for age and months.");
        } // end catch NumberFormatException
        catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Input Error: \nyou must enter name, age, and months.");
        }// end catch ArrayIndexOutOfBoundsException 

        // test input and parsing
        /*System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("months: " + months);
         */

        // ******* processing *******

        if(age < AGETHRESHOLD){
            //System.out.println("junior"); 
            dues = JUNIORFEE * months;           // calculate juniot dues owing 
        } // end if < 18
        else{
            //System.out.println("adult");
            dues = ADULTFEE * months;           // calculate adult dues owing
        } // end  18 and over

        //System.out.println(dues);

        // ******* output *******

        System.out.format("%-10s %10s %10s %10s %s", "Name", "Age", "Months", "Dues", nl);
        System.out.format("%-10s %10d %10d %10s %s", name, age, months, (cf.format(dues)), nl);

        // now to JOptionPane
        strout = String.format("%-10s %10s %10s %10s %s", "Name", "Age", "Months", "Dues", nl);
        strout += String.format("%-10s %10d %10d %10s %s", name, age, months, (cf.format(dues)), nl);

        // set the font for the pop-up
        UIManager.put("OptionPane.messageFont", new Font("Courier",Font.PLAIN, 12));
        JOptionPane.showMessageDialog(null, banner + strout);

        // ******* closing message *******

        System.out.println("end of processing");

    } // end main
}// end public class
