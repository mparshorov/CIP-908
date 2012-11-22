package uk.co.newsint.cip.utilities.htmldataclean;

/**
 * User Agent parser utility class
 * 
 * @author Georgi Petkov
 * @see {@link HTMLDataCleaner}
 */
public abstract class DataCleaner
{
    /**
     * This method's cleaning the current text
     * 
     * @param Current text for cleaning
     */
    public abstract void clean(String text);
}
