// Name: Sommer Le
// File: LargeNumberTest.java 
// Complete documentation is available from the IntNode link in:
//   http://www.cs.colorado.edu/~main/docs

import java.util.InputMismatchException;
import java.util.Scanner;

public class LargeNumberTest 
{
    public static void main(String []args)
    {
        /*
        * 1. Display both numbers (with commas)
        * 2. Input two new numbers (without commas)
        * 3. Check if numbers are equal
        * 4. Report the sum fo teh two numbers
        * 5. Report the multiplication of the two numbers
        * 6. Create and output the clone of the first number
        * 7. Quit
        */
        Scanner inputObj = new Scanner(System.in);
        int menuRequest = 0;

        while(menuRequest <= 6)
        {
            try
            {
                System.out.println("1. Display both numbers (with commas)");
                System.out.println("2. Input two new numbers (without commas)");
                System.out.println("3. Check if numbers are equal");
                System.out.println("4. Report the sum fo teh two numbers");
                System.out.println("5. Report the multiplication of the two numbers");
                System.out.println("6. Create and output the clone of the first number");
                System.out.println("7. Quit");
                System.out.print("Please type in a number from 1-7: ");
                menuRequest = inputObj.nextInt();
                if (menuRequest == 1)
                {
                    System.out.println("option 1");//
                }
                if (menuRequest == 2)
                {
                    System.out.println("option 2");//
                }
                if (menuRequest == 3)
                {
                    System.out.println("option 3");//
                }
                if (menuRequest == 4)
                {
                    System.out.println("option 4");//
                }
                if (menuRequest == 5)
                {
                    System.out.println("option 5");//
                }
                if (menuRequest == 6)
                {
                    System.out.println("option 6");//
                }//
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Please type in a whole number, not a string value.");//
            }
            catch (IllegalArgumentException exception)
            {
                System.out.println("Please type in a positive whole number that is within the range of 1-7");//
            }
            
        }
        System.out.println("End of my program!");
    }
}
