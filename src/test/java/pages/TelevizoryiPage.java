package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TelevizoryiPage extends BasePage {


    @FindBy(xpath = "//div[@class='form-group']/input[@class='form-control form-control-max']")
    private WebElement inputValueOfMaxPrice;

    @FindBy(xpath = "//form[@id='filters']//div[@class='form-group filter-group js_filter_parent open-filter-tooltip']//a")
    private WebElement MaxPriceFilterAcceptButton;

    @FindBy(xpath = "//label[@for='fltr-1']")
    private WebElement availableProductsCheckBox;

    @FindBy(xpath = "//label[@for='fltr-proizvoditel-samsung']")
    private WebElement samsungMakerCheckBox;

    @FindBy(xpath = "//form[@id='filters']//div[@class='filter-area js_filter_parent open-filter-tooltip']//a")
    private WebElement availableProductsAndSamsungMakerFilterAcceptButton;

    public TelevizoryiPage(WebDriver driver) {
        super(driver);
    }

    public void clearInputValueOfMaxPrice() {
        inputValueOfMaxPrice.clear();
    }

    public void filterByMaxPrice(String maxPrice) {
        inputValueOfMaxPrice.sendKeys(maxPrice, Keys.ENTER);
    }

    public WebElement getMaxPriceFilterAcceptButton() {
        return MaxPriceFilterAcceptButton;
    }

    public void clickMaxPriceFilterAcceptButton() {
        MaxPriceFilterAcceptButton.click();
    }

    public void clickAvailableProductsCheckBox () {
        availableProductsCheckBox.click();
    }

    public void clickSamsungMakerCheckBox () {
        samsungMakerCheckBox.click();
    }

    public WebElement getAvailableProductsAndSamsungMakerFilterAcceptButton() {
        return availableProductsAndSamsungMakerFilterAcceptButton;
    }

    public void clickAvailableProductsAndSamsungMakerFilterAcceptButton() {
        availableProductsAndSamsungMakerFilterAcceptButton.click();
    }
}
