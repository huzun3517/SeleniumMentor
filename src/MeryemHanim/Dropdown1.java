package MeryemHanim;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

public class Dropdown1 {

    public static void main(String[] args) throws InterruptedException {

        // How handle dropdown in Selenium

        // if it is stactic dropdown

        // 1- by using select

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement cerez = driver.findElement(By.cssSelector("button.wt-btn.wt-btn--secondary.wt-width-full"));
        cerez.click();

        Thread.sleep(1000);

        WebElement button = driver.findElement(By.xpath("(//div[@class='shopping-window wt-grid__item-xs-4 wt-grid__item-lg-2 wt-text-center-xs wt-break-word wt-pb-xs-3 wt-pl-md-3 wt-pr-md-3'])[1]"));
        button.click();

        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0, 5000)");

        Select dil = new Select(driver.findElement(By.cssSelector("select#ship_to_select")));
        dil.selectByValue("RO");

        System.out.println("Test başarılı...");
        Thread.sleep(5000);
        driver.quit();

    }
}