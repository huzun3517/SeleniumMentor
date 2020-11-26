package OmerBeyYoutube._06_07_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActionClass {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        // ÇEREZLERİ KABUL ET TIKLATTIK
        WebElement cookies = driver.findElement(By.cssSelector("button.wt-btn.wt-btn--secondary.wt-width-full"));
        cookies.click();

        // DİLLER SEÇENEĞİNE TIKLATTIK
        WebElement dil = driver.findElement(By.xpath("//span[@class='wt-display-inline-block wt-vertical-align-middle']"));
        dil.click();

        Thread.sleep(1000);

        // DİLİ SEÇTİRDİK
        WebElement sprache = driver.findElement(By.xpath("//select[@name='language_code']"));

        Select slc = new Select(sprache);
        slc.selectByVisibleText("English (US)");

        Thread.sleep(3000);

        // KAYDET BUTONUNA TIKLATTIK
        WebElement kaydet = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled']"));
        kaydet.click();

        Thread.sleep(1000);

        // ACTIONCLASS
        Actions actions = new Actions(driver);

        List<WebElement>menubarsList = driver.findElements(By.xpath("//ul[@role='menubar']//li"));
// TODO     1.YOL  --> li lerin ul olan babalarından yakaladık. bir altına li ye indik. 8 taneyi bulduk
//          2.YOL  --> ul[@role='menubar']//li // --> direk li lerden birincisini yakaladık. 8 tane görünüyor sonrasında.

        for (WebElement menubarElement: menubarsList) {

            actions.moveToElement(menubarElement).perform();

            Thread.sleep(1000);
        }

        Thread.sleep(3000);

        System.out.println("Test Başarılı...");

        driver.quit();
    }
}
