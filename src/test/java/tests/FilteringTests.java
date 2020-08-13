package tests;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;

import javax.print.DocFlavor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FilteringTests extends BaseTest {

    private static final String MAX_PRICE_IN_INPUT_FIELED = "2200";
    private static final String MAX_PRICE_IN_URL = "price--0--2200";
    private static final String AVAILABLE_PRODUCTS_AND_MAKER_IN_URL = "available--on_proizvoditel--samsung";

    @Test(priority = 2)
    public void checkFilterByMaxPrice() {
        getHomePage().clickTelevizoryiButton();
        getBasePage().waitPageReadyState(30);
        getTelevizoryiPage().clearInputValueOfMaxPrice();
        getTelevizoryiPage().filterByMaxPrice(MAX_PRICE_IN_INPUT_FIELED);
        getBasePage().waitForElementVisibility(20, getTelevizoryiPage().getMaxPriceFilterAcceptButton());
        getTelevizoryiPage().clickMaxPriceFilterAcceptButton();
        assertTrue(getDriver().getCurrentUrl().contains(MAX_PRICE_IN_URL));
    }

    @Test(priority = 3)
    public void checkCheckBoxesFilterByProductAvailableAndManufacturerSamsung() {
        getHomePage().clickTelevizoryiButton();
        getBasePage().waitPageReadyState(30);
        getTelevizoryiPage().clickAvailableProductsCheckBox();
        getTelevizoryiPage().clickSamsungMakerCheckBox();
        getBasePage().waitForElementVisibility(20, getTelevizoryiPage().getAvailableProductsAndSamsungMakerFilterAcceptButton());
        getTelevizoryiPage().clickAvailableProductsAndSamsungMakerFilterAcceptButton();
        getBasePage().waitPageReadyState(30);
        assertTrue(getDriver().getCurrentUrl().contains(AVAILABLE_PRODUCTS_AND_MAKER_IN_URL));
    }

}
