package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SortTests extends BaseTest {

    @Test(priority = 4)
    public void checkSortByPriceAscending() {
        getHomePage().clickAppleStoreButton();
        getAppleStorePage().clickIphoneButton();
        getBasePage().waitPageReadyState(30);
        getIphonePage().clickSortPriceByAscendingSelect();
        getIphonePage().getIphoneList();
        List<Integer> iPhoneListPrices = new ArrayList<>();
        for (WebElement elements : getIphonePage().getIphoneList()) {
            iPhoneListPrices.add(Integer.parseInt(elements.getText().substring(0, 5).trim()));
        }
        boolean SortByPriceAscending = true;
        for (int i = 0; i < iPhoneListPrices.size() - 1; i++) {
            if (iPhoneListPrices.get(i + 1) != null) {
                if (iPhoneListPrices.get(i) > iPhoneListPrices.get(i+1)) {
                    SortByPriceAscending = false;
                    break;
                }
            }
        }
        assertEquals(SortByPriceAscending, true);
    }

}
