package MeryemHanim.ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

public class _03_DoubleClick {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://uitestpractice.com/"); // siteyi açtım
        driver.manage().window().maximize();

        WebElement ikikereTiklama = driver.findElement(By.cssSelector("button.btn.btn-default"));

        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.doubleClick(ikikereTiklama).perform();

        System.out.println("Test başarılıdır");

        Thread.sleep(5000);
        driver.quit();

    }
}
