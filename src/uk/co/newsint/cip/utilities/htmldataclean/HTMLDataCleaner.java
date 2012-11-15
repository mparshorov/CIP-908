package uk.co.newsint.cip.utilities.htmldataclean;

import java.io.IOException;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * This class is used to clean the input data
 * 
 * @author Georgi Petkov
 * 
 */

public class HTMLDataCleaner
{
    /**
     * This is a regular expression which is used for removing the nonalpha characters in the input text
     */
    private static final String REGEXP_REMOVE_NONALPHA = "[^a-zA-Z]";
    /**
     * This pattern's using the REGEX_REMOVE_NONALPHA
     */
    private static Pattern NONALPHA_PATTERN_CLEANER = Pattern.compile(HTMLDataCleaner.REGEXP_REMOVE_NONALPHA);

    /**
     * This method is used for cleaning the input data from html tags and url encoding
     */
    public static String clean(String inputText)
    {
        String cleanedText = null;

        return cleanedText;
    }

    /**
     * This method is used for cleaning the input data from html tags and url encoding and replacing with character
     * @throws IOException 
     */
    public static String cleanAndReplace(String inputText) throws IOException
    {
        String cleanedText = null;
        Document doc = Jsoup.connect("http://www.linux.org/page/view/join-linux-org").timeout(5000).get();
        // here i can call the clean method
        // here has to be the replace implementation
        cleanedText = Jsoup.parse(inputText).text();
        return cleanedText;
    }

    /**
     * This method is used for cleaning the input data from html tags and url encoding and nonalpha characters(inc spaces)
     */
    public static String removeNonAlphaCharacters(String inputText)
    {
        String cleanedText = null;
        // here i can call the clean method
        cleanedText = inputText.replaceAll(HTMLDataCleaner.REGEXP_REMOVE_NONALPHA, "#");
        return cleanedText;
    }
}
