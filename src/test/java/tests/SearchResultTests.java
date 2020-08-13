package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchResultTests extends BaseTest {

    private static final String SEARCH_RESULT = "query=iPhone";
    private static final String SEARCH_KEYWORD = "iPhone";

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWorld() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(SEARCH_RESULT));
    }
}
