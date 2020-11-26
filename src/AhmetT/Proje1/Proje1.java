package AhmetT.Proje1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Proje1 {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        // Bu locator daki eleman visible olana kadar bekle.
        WebDriverWait wait=new WebDriverWait(driver, 45);
        WebElement text= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='at4-close']")));
        text.click();

        //Ad
        WebElement ad = driver.findElement(By.cssSelector("input#user-message"));
        ad.sendKeys("Hüseyin");

        // Show Message Button
        WebElement show = driver.findElement(By.xpath("//button[text()='Show Message']"));
        show.click();

        // Ekranı "Two Input Fields" yazısına kadar kaydırma
        WebElement element = driver.findElement(By.xpath("//div[text()='Two Input Fields']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);

        // a inputbox
        WebElement a = driver.findElement(By.cssSelector("input#sum1"));
        a.sendKeys("5");

        // b inputbox
        WebElement b = driver.findElement(By.cssSelector("input#sum2"));
        b.sendKeys("10");

        //Get Total Button
        WebElement getTotal = driver.findElement(By.xpath("//button[text()='Get Total']"));
        getTotal.click();

        //ave b Clear
        a.clear();
        b.clear();

        // a inputboxa rand değer ile yazdırma
        int rand = (int)(1000 + Math.random()*9000);
        String randStr = String.valueOf(rand);
        a.sendKeys(randStr);


        // Actions ile a inputbox ına çift tıklattık
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(a).doubleClick().build();
        action.perform();

        // Robot kullanılarak ekran CTRL C ile kopyalandı.
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);

        // Robot kullanılarak ekran CTRL V ile b inputbox ına yapıştırıldı.
        b.click();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // a ve b inputBox ındaki value değerlerinin eşitliği doğrulandı
        String aStr = a.getAttribute("value");
        System.out.println(aStr);
        String bStr = b.getAttribute("value");
        System.out.println(bStr);

        Assert.assertEquals(aStr,bStr);

        // sayfa nın ekran görüntüsü alındı
        TakesScreenshot ts = (TakesScreenshot) driver;
        File ekranDosyasi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranDosyasi,new File("ekranGoruntuleri/proje1.png"));

        System.out.println("Test başarılı...");
        Thread.sleep(3000);
        driver.quit();
    }
}
