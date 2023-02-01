/* *************************************
 * Programmer:  Sveinson
 * 
 * Assignment:  if-else example, calcualte membership dues
 * 
 * Description: calculate dues owing based on age, months and monthly fee
 *              three age categories junior = under 18
 *                                      adult = 18-54
 *                                      senior = 55+
 *                                      
 *              now we will add some more features to our membership program.
 *              Junior members can sign up for a special training program. The program
 *              has two level Elite, which costs $5 per month and development that costs
 *              $3 per month
 *              
 *              Adult and Senior members can opt to buy a limited membership, with the limited
 *              membership they get a 20% reduction in their fees.
 *              
 *              We will add the code necessary to efficiently include these new properties into
 *              our fee calculator.
 ***************************************** */
// **** import Java class Libraries ****
import java.util.Scanner;
import javax.swing.*;
import java.text.NumberFormat;

public class usticeLeagueDuesNestedIfAndDependencies{
    public static void main(String[] args){
        // ******* declare constants *******

        // set constants for month charge
        final double ADULTFEE = 19.95;
        final double JUNIORFEE = 11.95;
        final double SENIORFEE = 15.95;

        final int AGETHRESHOLD = 18;       // age cut off between adult and junior
        final int SENIORTHRESHOLD = 55;    // age cut off beteen adult and senior

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
        
        char trainingProgram = 'x';       // junior training program
                                            // x no program
                                            // e elite
                                            // d development
                                    
                                    
        char membershipType = 'f';                // l limited
                                            // f full
                                    
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
        prompt += "Enter e, d, or x for training program.";
        prompt += "enter l for limited and f for full membership." + nl;
        
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
         * "bob"  "15"  "23" "e" "f"
         * each token is numbered with and index stargting at 0
         * so tokens[0] is "bob", tokens[1] is "15" and tokens[2] is "23"
         */ 

        // parse input into variable

        // use a try catch block to catch runtime exceptions
        try{
            name = tokens[0];                      // name is a string so no parsing is needed
            age = Integer.parseInt(tokens[1]);     // "15" must converted to 15 (String to int)
            months = Integer.parseInt(tokens[2]);  // "23" must converted to 23 (String to int) 
            trainingProgram = tokens[3].charAt(0);  // get traing program type
            membershipType = tokens[4].charAt(0);    // get typr of membership
        }// end try
        catch(NumberFormatException e){
            System.out.println("all numbers must be int");
        }// end number format error
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("you must enter all 3 data items.");
        }// end incorrct number of inputs error

        // test input and parsing
        /*System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("months: " + months);
         */

        // ******* processing *******

        if(age < AGETHRESHOLD){
            membershipType = 'f';       // default type for junior is full membership
            
            //System.out.println("junior");
            dues = JUNIORFEE * months;
            // do training program logic
            
            if(trainingProgram == 'x'){
                System.out.println("no program");
            }// end no progam
            else{
                if(trainingProgram == 'e'){
                    System.out.println("elite program");
                }// end elite
                else{
                    System.out.println("dev program");
                }// end of development
            }// end of program
            
        } // end if < 18
        else{
            trainingProgram = 'x';
            // could also set the cost of trainibng program to 0
            
            //System.out.println("not junior");
            if(age < SENIORTHRESHOLD){
                //System.out.println("Adult");
                dues = ADULTFEE * months;
            }// end adult
            else{
                //System.out.println("Senior");
                dues = SENIORFEE * months;
            } // end senior
            
            if(membershipType == 'l'){
                    System.out.println("limited");
                }// end limited
                else{
                    System.out.println("full");
                }// end full
        } // end  18 and over

        //System.out.println(dues);

        // ******* output *******

        System.out.format("%-10s %10s %10s %10s %s", "Name", "Age", "Months", "Dues", nl);
        System.out.format("%-10s %10d %10d %10s %s", name, age, months, (cf.format(dues)), nl);

        // now to JOptionPane
        strout = String.format("%-10s %10s %10s %10s %s", "Name", "Age", "Months", "Dues", nl);
        strout += String.format("%-10s %10d %10d %10s %s", name, age, months, (cf.format(dues)), nl);

        JOptionPane.showMessageDialog(null, banner + strout);

        // ******* closing message *******

        System.out.println("end of processing");

    } // end main
}// end public class
