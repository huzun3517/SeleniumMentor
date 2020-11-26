package MeryemHanim.ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

public class _08_RightClick {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/buttons");
        driver.manage().window().maximize();

        WebElement sagTiklama = driver.findElement(By.xpath("//button[text()='Right']"));

        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.contextClick(sagTiklama).perform();

        System.out.println("Test başarılıdır");

        Thread.sleep(5000);
        driver.quit();

    }
}
