import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

/* ****************************************
 * Name:        Sveinson
 * Class:       CS20S
 * 
 * Assignment:  Voting age selection example
 **********************************************/
public class CS20SVotingAgeExample001{
    public static void main(String[] args){
        // **** Constants ****

        final String nl = System.lineSeparator();

        // **** variables ****

        String banner = "";         // output banner
        String prompt = "";         // prompt for input

        String strin = "";          // intput
        String strout = "";         // used for formatted output

        int age = 0;            // person's age
        String message;         // voting eligibility message

        // **** Objects ****
        // create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);
        //NumberFormat currency = NumberFormat.getCurrencyInstance();

        // **** banner ****

        banner = "*****************************" + nl;
        banner += "Name:        Sveinson" + nl;
        banner += "Class:       CS20S" + nl;
        banner += "Assignment:  AxQy" + nl;
        banner += "******************************";

        // now print the banner to the terminal window
        System.out.println(banner);

        // **** input ****

        prompt = "Enter your age.";
        System.out.println(prompt);
        age = scanner.nextInt();
        System.out.println(age);

        // **** processing ****

        // use an if else to set the message
        if(age >= 18){
            message = "old enough";
        }// end if
        else{
            message = "not old enough";
        }// end else

        // print result
        System.out.println("Your are " + message + " to vote.");

        // **** output ****

        // **** closing message ****

        System.out.println();
        System.out.println("end of program");

    }// end main

}// end class
