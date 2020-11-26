package OmerBeyYoutube._10_Handle_Window;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.Set;

public class Handle_window {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.demo.guru99.com/popup.php");

        driver.manage().window().maximize();

        // ANASAYFA ID VE URL Sİ ALINDI
        String firstWinID = driver.getWindowHandle();
        String firsWinUrl = driver.getCurrentUrl();

        System.out.println("Başlangıç pencerem = " + firsWinUrl);

        //CLİCK HERE TIKLAMA
        WebElement clickHereButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereButton.click();

        // 2.PENCEREYE GEÇME
        Set<String> windowList = driver.getWindowHandles();

        for (String strWindow: windowList) {

            driver.switchTo().window(strWindow);
        }


        //E-MAİL BUTTON
        WebElement mail = driver.findElement(By.xpath("//input[@name='emailid']"));
        mail.sendKeys("huzun@gmail.com");

        // SUBMİT BUTTON
        WebElement submit = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        submit.click();

        // 2.SAYAFNIN URL Sİ
        String secondWinUrl = driver.getCurrentUrl();
        System.out.println("2.pencerenin Url si = " + secondWinUrl);

        driver.close();
        driver.switchTo().window(firstWinID);

        // YENİ PENCERENİN URL Sİ
        System.out.println("Şuanki sayfanın Url si = " + driver.getCurrentUrl());

        Thread.sleep(2000);

        System.out.println("Test Başarılı...");

        driver.quit();
    }
}