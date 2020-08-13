package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IphonePage extends BasePage {

    public IphonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@data-placeholder='']/option[@value='priceasc']")
    private WebElement sortPriceByAscendingSelect;

    @FindBy(xpath = "//div[@class='container-main']//div[@class='prod-cart__prise-new']")
    private List<WebElement> iPhoneList;

    public List<WebElement> getIphoneList () {return iPhoneList;}

    public void clickSortPriceByAscendingSelect () {
        sortPriceByAscendingSelect.click();
    }
}
