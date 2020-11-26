package OmerBey._04_Alert_Handle_Window;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert {

    public static void main(String[] args) throws InterruptedException {

        WebDriverWait wait;
        JavascriptExecutor js;

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.demo.guru99.com/test/delete_customer.php");

        driver.manage().window().maximize();

        // ID Button
        WebElement ID = driver.findElement(By.cssSelector("input[name='cusid']"));
        ID.sendKeys("omer123");

        // Submit Buton
        WebElement submitButton = driver.findElement(By.cssSelector("input[name='submit']"));
        submitButton.click();

        Thread.sleep(1500);

        // Alert penceresi1
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
//      driver.switchTo().alert().dismiss();  iptal

        Thread.sleep(1500);

        // Alert Penceresi2
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        System.out.println("Test başarılı");
        driver.quit();
    }
}