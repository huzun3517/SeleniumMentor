package OmerBeyYoutube._06_07_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActionClass2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        driver.manage().window().maximize();

        //BAŞKENTLER
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement seoul = driver.findElement(By.id("box5"));

        //ÜLKELER
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement southKorea = driver.findElement(By.id("box105"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement unitedStates  = driver.findElement(By.id("box103"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(rome,italy).build().perform();
        actions.dragAndDrop(seoul,southKorea).build().perform();
        actions.dragAndDrop(stockholm,sweden).build().perform();
        actions.dragAndDrop(oslo,norway).build().perform();
        actions.dragAndDrop(madrid,spain).build().perform();
        actions.dragAndDrop(copenhagen,denmark).build().perform();
        actions.dragAndDrop(washington,unitedStates).build().perform();

        Thread.sleep(3000);

        System.out.println("Test Başarılı...");

        driver.quit();
    }
}