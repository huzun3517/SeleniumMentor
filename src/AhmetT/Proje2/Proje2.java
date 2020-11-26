package AhmetT.Proje2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Proje2 {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        // Checkbox tıklatıldı
        WebElement checkbox = driver.findElement(By.cssSelector("input#isAgeSelected"));
        checkbox.click();

        // Ekranı "Multiple Checkbox Demo" yazısına kadar kaydırma
        WebElement element = driver.findElement(By.xpath("//div[text()='Multiple Checkbox Demo']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);

        //Checkboxların hepsini seçtirme ve Doğrulama
        List<WebElement>optionsList = driver.findElements(By.cssSelector("input.cb1-element"));

        for (WebElement option: optionsList){
            option.click();
            Assert.assertTrue(option.isSelected());
        }

        for (WebElement option: optionsList){
            option.click();
            Assert.assertFalse(option.isSelected());
        }

        // Checkboxlara random ile tıklatma
        int randomSayi = random( optionsList.size());
        optionsList.get(randomSayi).click();

        //sayfa nın ekran görüntüsü alındı
        TakesScreenshot ts = (TakesScreenshot) driver;
        File ekranDosyasi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranDosyasi,new File("ekranGoruntuleri/proje2.png"));

        System.out.println("Test başarılı...");
        Thread.sleep(3000);
        driver.quit();
    }
    public static int random(int max) {

        Random random = new Random();

        int uretilenSayi = random.nextInt(max);

        return uretilenSayi;
    }
}
