package MeryemHanim.ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _06_HoverOver {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://qatechhub.com/mouse-hover-actions-selenium-webdriver/"); // siteyi açtım
        driver.manage().window().maximize();

        Actions action=new Actions(driver);
        List<WebElement> hoverOver= driver.findElements(By.className("dropdown")); // Sadece hoverover olan 3 menüyü istiyor.
        System.out.println(hoverOver.size());

        for (WebElement e: hoverOver) {
            action.moveToElement(e).perform();
            Thread.sleep(2000);
        }

        System.out.println("Test başarılıdır");

        Thread.sleep(2000);
        driver.quit();

    }
}
