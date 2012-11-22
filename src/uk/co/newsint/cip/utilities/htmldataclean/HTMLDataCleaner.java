package uk.co.newsint.cip.utilities.htmldataclean;

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
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
     * This is the text after the clean process
     */
    private String cleanedText;

    /**
     * Get the cleaned text
     */
    public String getCleanedText()
    {
        return this.cleanedText;
    }

    /**
     * This method is used for cleaning the input data from html tags and url encoding
     */
    public void clean(String inputText)
    {
        // The text after cleaning
        String cleanedText = null;

        // apache commons url codec for decoding the url's in the text
        URLCodec urlDecoder = new URLCodec();

        // Clean url decoding
        try
        {
            cleanedText = urlDecoder.decode(inputText);
        }
        catch (DecoderException e)
        {
            e.printStackTrace();
        }

        // Remove html tags from the text
        cleanedText = Jsoup.parse(cleanedText).text();

        // Remove nonalpha characters
        cleanedText = cleanedText.replaceAll(REGEXP_REMOVE_NONALPHA, "");

        this.cleanedText = cleanedText;
        //return cleanedText;
    }
}
