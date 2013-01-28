package uk.co.newsint.cip.utilities.htmldatacleaner.impl;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.jsoup.Jsoup;

import uk.co.newsint.cip.utilities.htmldatacleaner.DataCleaner;

/**
 * This class is used to clean the input data
 * 
 * @author Georgi Petkov
 * 
 */
public class HTMLDataCleaner implements DataCleaner
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
     * This method is used for cleaning
     * 
     * @see{@link DataCleaner#clean(String)}
     */
    public void clean(String inputText)
    {
        // The text after cleaning
        String cleanedText = null;

        // apache commons url codec for decoding the url's in the text
        URLCodec urlDecoder = new URLCodec();

        // Decoding the url
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
        if (cleanedText != null)
        {
            cleanedText = cleanedText.replaceAll(REGEXP_REMOVE_NONALPHA, "");
        }
        // Initialize the htmldatacleaner's cleanedText
        this.cleanedText = cleanedText;
    }
}
