package OmerBeyYoutube._02_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class _02_id {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://login.yahoo.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("createacc")).click();

        Thread.sleep(1000);

        driver.findElement(By.name("firstName")).sendKeys("Hüseyin"); // Ad

        driver.findElement(By.id("usernamereg-lastName")).sendKeys("Uzun"); // Soyad

        System.out.println("Test başarılı...");

        Thread.sleep(3000);

        driver.quit();
    }
}
