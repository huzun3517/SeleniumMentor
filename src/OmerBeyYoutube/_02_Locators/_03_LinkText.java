package OmerBeyYoutube._02_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class _03_LinkText {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://login.yahoo.com");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Kullanıcı adınızı mı unuttunuz?")).click(); // LinkText ile alındı

   //     driver.findElement(By.partialLinkText("Kullanıcı")).click(); // linkText in bir parçası ile alındı

        driver.findElement(By.className("phone-no")).sendKeys("suzun35@gmail.com");

        driver.findElement(By.name("verifyYid")).click();

        System.out.println("Test başarılı...");

        Thread.sleep(3000);

        driver.quit();
    }
}
