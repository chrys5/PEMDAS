import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Balanced
{
    //Arranged so indexes can be used to determine whether brackets are closed correctly
    private static final String brackets = "([{)]}";

    public static void main(String[] args)
    {
        Scanner scan;
        try
        {
            int count = 0; //Initialize counter and set to 0
            scan = new Scanner(new File("in.txt")); //Call in.txt file
            int len = scan.nextInt(); //Call first number of lines to be scanned from in.txt
            scan.nextLine(); //Start scan cursor at new line
            //Go through every line and counts up when line is balanced
            for(int i = 0; i < len; i++)
            {
                String str = scan.nextLine();
                //System.out.println(i + 2 + ": " + balanced(str)); //(testing)
                if (balanced(str))
                {
                    count++; //Increase count
                }
            }
            System.out.println("You have " + count + " balanced equations");
        }
        //Run if there is no such "in.txt" file
        catch (FileNotFoundException e)
        {
            System.out.println("in.txt not found, using console input...");
            scan = new Scanner(System.in); //Reads scanner console input
            System.out.println("Balanced: " + balanced(scan.nextLine()));
        }
    }

    /**
     * This method checks if every bracket is closed and balanced correctly in the given String.
     * @param s String to be checked
     * @return Whether String is balanced
     */
    public static boolean balanced(String s)
    {
        ArrayStack stack = new ArrayStack(); //Create new Stack
        //Traverse all chars in String
        for(int i = 0; i < s.length(); i++)
        {
            //Sets index variable as -1 if current char as not bracket, or a corresponding number if it is,
            //referencing from the brackets String
            int index = brackets.indexOf(s.charAt(i));
            //If current char is bracket
            if(index != -1)
            {
                //If current char is open bracket
                if (index <= 2)
                {
                    stack.push(s.charAt(i)); //Add current char that is an open bracket to stack
                }
                //If current char is close bracket
                else
                {
                    //If open bracket in stack exists and matches with current char that is a close bracket
                    if (stack.peek() != null && stack.peek().equals(brackets.charAt(index - 3)))
                    {
                        stack.pop(); //Take open bracket out of stack
                    }
                    //If open bracket in stack does not exist or does not match with current char that is a close bracket
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return stack.empty(); //Returns whether stack is empty (whether all open brackets have been closed)
    }
}