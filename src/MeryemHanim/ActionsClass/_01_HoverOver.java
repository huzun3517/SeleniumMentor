package MeryemHanim.ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

public class _01_HoverOver {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://birtwhistle.com/workers-compensation-insurance/"); // siteyi açtım
        driver.manage().window().maximize();

        // Personal Insurance --> Actions Class
        WebElement personelInsurance = driver.findElement(By.cssSelector("li#menu-item-19"));
        Actions action = new Actions(driver);
        action.moveToElement(personelInsurance).perform();

        Thread.sleep(1000);

        // Business Insurance --> Actions Class
        WebElement businessInsurance = driver.findElement(By.cssSelector("li#menu-item-18"));
        action.moveToElement(businessInsurance).perform();

        System.out.println("Test başarılıdır");

        Thread.sleep(2000);
        driver.quit();

    }
}
