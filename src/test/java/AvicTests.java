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

import javax.print.DocFlavor;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class AvicTests {

    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWorld() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("iPhone 11", Keys.ENTER);
        assertTrue(driver.getCurrentUrl().contains("query=iPhone"));
    }

    @Test(priority = 2)
    public void checkFilterByMaxPrice() {
        driver.findElement(By.xpath("//div[@class='top-links__left flex-wrap']//div[@class='top-links__box']//a[@href='/televizoryi']")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//div[@class='form-group']/input[@class='form-control form-control-max']")).clear();
        driver.findElement(By.xpath("//div[@class='form-group']/input[@class='form-control form-control-max']")).sendKeys("2200", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='filters']/aside/div/div[3]/a"))).click();
        assertTrue(driver.getCurrentUrl().contains("price--0--2200"));
    }

    @Test(priority = 3)
    public void checkSortByPriceAscending() {
        driver.get("https://avic.ua/iphone/seriya--apple-iphone-se-2020");
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//select[@data-placeholder='']/option[@value='priceasc']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 300);
        assertTrue(driver.getCurrentUrl().contains("sort--priceasc"));
    }

    @Test(priority = 4)
    public void checkSearchResultWhenTitleHaveMistake() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("suamsung a51");
        //driver.findElement(By.xpath("//div[@class='search-suggest__item search-suggest__container']//a[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-suggest__item search-suggest__container']//a")));
        assertTrue(driver.findElements(By.xpath("//div[@class='search-suggest__item search-suggest__container']//a")).contains(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'samsung-galaxy-a51')]")))));
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
