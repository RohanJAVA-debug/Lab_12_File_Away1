import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> records = new ArrayList<>();

        boolean done = false;

        while(!done)
        {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String id = SafeInput.getRegExString(in, "Enter ID Number (6 digits)", "\\d{6}");
            String email = SafeInput.getNonZeroLenString(in, "Enter Email");
            int yob = SafeInput.getRangedInt(in, "Enter Year of Birth", 1900, 2026);

            String record = firstName + "," +
                    lastName + "," +
                    id + "," +
                    email + "," +
                    yob;

            records.add(record);

            done = !SafeInput.getYNConfirm(in, "Add another record?");
        }

        String fileName = SafeInput.getNonZeroLenString(in,
                "Enter output file name (without .csv)");

        try
        {
            File file = new File("src/" + fileName + ".csv");

            PrintWriter writer = new PrintWriter(file);

            for(String record : records)
            {
                writer.println(record);
            }

            writer.close();

            System.out.println("CSV file saved successfully.");
        }
        catch(Exception e)
        {
            System.out.println("Error saving file.");
            e.printStackTrace();
        }

        in.close();
    }
}