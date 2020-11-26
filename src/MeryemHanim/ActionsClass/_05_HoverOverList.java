package MeryemHanim.ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _05_HoverOverList {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://birtwhistle.com/workers-compensation-insurance//");

        driver.manage().window().maximize();

        Actions action=new Actions(driver);
        List<WebElement> hoverOver= driver.findElements(By.cssSelector(".ubermenu-has-submenu-flyout"));
        System.out.println(hoverOver.size());

        for (int i = 0; i <hoverOver.size() ; i++) {
            action.moveToElement(hoverOver.get(i)).perform();
            Thread.sleep(2000);
        }
    }
}
