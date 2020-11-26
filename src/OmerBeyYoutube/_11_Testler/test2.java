package OmerBeyYoutube._11_Testler;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.List;

public class test2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://en.wikipedia.org/wiki/Dell");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // TABLOYU SEÇTİRDİM
        WebElement table = driver.findElement(By.cssSelector("table.wikitable.sortable.jquery-tablesorter"));

        // TABLO GÖZÜKENE KADAR scroll ile AŞAĞI İNDİRDİM
        js.executeScript("arguments[0].scrollIntoView();",table);

        // TABLODAKİ TÜM SATIRLARI LİSTE İLE ALDIRDIM VE TEXT INI YAZDIRDIM
        List<WebElement> satirlar = driver.findElements(By.cssSelector("table.wikitable.sortable>tbody>tr"));

        for (WebElement satir: satirlar){
            System.out.println(satir.getText() + "\n");
        }

        System.out.println("-----------------               -------------------------");

        //// table[@class='wikitable sortable jquery-tablesorter']//tbody//tr[9]//td[2]
        // 9.satırın 2.stünuna git dedik Xpath ile

        // TABLE IN 10.SATIRINI YAZDIRDIK
        WebElement wyseSatir10 = driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tbody//tr[10]"));
        System.out.println(wyseSatir10.getText());

        // TABLE DAKİ BOOMININ NOTUNU YAZDIRDIK
        WebElement boomi = driver.findElement(By.cssSelector("table.wikitable.sortable.jquery-tablesorter>tbody>tr:nth-of-type(5)>td:nth-of-type(2)"));
        System.out.println("Boomi Company Note: " + boomi.getText());

        // BOOMININ NOTUNU ASSERT ILE KONTROL ETTIK
        Assert.assertEquals("Cloud integration leader",boomi.getText()); //1.YOL

        Assert.assertTrue(boomi.getText().contains("integration leader")); // 2.YOL

        Thread.sleep(2000);

        System.out.println("Test başarılı...");

        driver.quit();
    }
}