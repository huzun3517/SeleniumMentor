package MeryemHanim.ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _07_DragAndDrop {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/dragdrop");
        driver.manage().window().maximize();

        WebElement drag = driver.findElement(By.cssSelector("div#image"));

        WebElement drop = driver.findElement(By.cssSelector("div#box"));

        Actions actions = new Actions(driver);

        Thread.sleep(500);
        actions.dragAndDrop(drag,drop).perform();

        System.out.println("Test başarılıdır");

        Thread.sleep(2000);
        driver.quit();

    }
}
