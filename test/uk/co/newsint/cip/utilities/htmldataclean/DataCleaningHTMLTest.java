package uk.co.newsint.cip.utilities.htmldataclean;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.co.newsint.cip.utilities.htmldataclean.HTMLDataCleaner;

/**
 * JUnit tests.
 * 
 * @author BitMix
 *
 */
public class DataCleaningHTMLTest
{
    /**
     * Instance of LibDataCleaningHTML to parse Strings later in the tests.
     */
    HTMLDataCleaner testClean = new HTMLDataCleaner();

    /**
     * Initial test for converting encoded URL to non-encoded URL.
     */
    @Test
    public void test()
    {
        assertString("http://www.permadi.com/tutorial/urlEncoding/example.html?var=This+is+a+simple+%26+short+test.",
                "http://www.permadi.com/tutorial/urlEncoding/example.html?var=This is a simple & short test.");
    }

    /**
     * Initial assert method.
     * 
     * @param input
     * @param expectedOutput
     */
    private void assertString(String input, String expectedOutput)
    {
    //    String actualClean = testClean.parse(input);
     //   assertNotNull("Invalid String!", input);
    //    assertEquals("Fail", expectedOutput, actualClean);
        
        
    }

}
