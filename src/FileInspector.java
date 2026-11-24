import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInspector
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser("src");
        int result = chooser.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = chooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try
            {
                Scanner fileReader = new Scanner(selectedFile);

                while(fileReader.hasNextLine())
                {
                    String line = fileReader.nextLine();

                    System.out.println(line);

                    lineCount++;

                    if(!line.trim().isEmpty())
                    {
                        wordCount += line.trim().split("\\s+").length;
                    }

                    charCount += line.length();
                }

                fileReader.close();

                System.out.println("\n----- FILE SUMMARY -----");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Error reading file.");
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("No file selected.");
        }
    }
}