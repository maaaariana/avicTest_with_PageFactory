package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='top-links__left flex-wrap']//div[@class='top-links__box']//a[@href='/televizoryi']")
    private WebElement televizoryiButton;

    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")
    private  WebElement appleStoreButton;

    public void searchByKeyWord(String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickTelevizoryiButton() {televizoryiButton.click();}

    public void clickAppleStoreButton () { appleStoreButton.click();}
}
