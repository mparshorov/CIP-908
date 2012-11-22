package uk.co.newsint.cip.utilities.htmldataclean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is used to generate CSV file with cleaned from HTML tags, encoding and non-alpha characters Strings.
 * 
 * @author BitMix
 * 
 */
public class DataCleaningHTMLUtility
{

    /**
     * Method for generating a file with the input line and the cleaned line(tab delimited)
     * 
     * @param file input file to be cleaned line by line from HTML tags, encoding and non-alpha characters
     */
    private void cleanAll(File file)
    {
        HTMLDataCleaner hdc = new HTMLDataCleaner();
        BufferedReader reader = null;
        String currentLine = null;
        FileWriter writer = null;
        try
        {
            try
            {
                writer = new FileWriter("test_html_clean_result_tabDelimited.csv");
                writer.append("Input" + "\t" + "Result" + "\n");
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

                while ((currentLine = reader.readLine()) != null)
                {
                    hdc.clean(currentLine);
                    writer.append(currentLine + "\t" + hdc.getCleanedText() + "\n");
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("There is not such file!!!");
            }
            catch (NullPointerException e)
            {
                System.out.println("File is NULL!!!");
            }
        }
        catch (IOException e)
        {
            System.out.println("Couldn't create file!!!");
        }
        finally
        {
            try
            {
                writer.flush();
                writer.close();
            }
            catch (IOException e1)
            {
                // do nothing
            }
            if (reader != null)
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    // do nothing
                }
        }
    }

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        DataCleaningHTMLUtility utility = new DataCleaningHTMLUtility();
        utility.cleanAll(new File("test_html_clean.txt"));
    }

}
