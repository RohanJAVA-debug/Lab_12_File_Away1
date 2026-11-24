import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retString = "";

        do
        {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while(!retString.matches(regEx));

        return retString;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value;

        while(true)
        {
            System.out.print(prompt + ": ");

            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();

                if(value >= low && value <= high)
                {
                    return value;
                }
            }
            else
            {
                pipe.nextLine();
            }

            System.out.println("Invalid input.");
        }
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;

        do
        {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().toUpperCase();
        }
        while(!response.equals("Y") && !response.equals("N"));

        return response.equals("Y");
    }
}