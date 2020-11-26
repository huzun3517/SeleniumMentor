package BurakBey;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _05_RobotClass {

    public static void main(String[] args) throws AWTException, InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://eu.jotform.com/form/202613856967365");

        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_TAB);

        // İsim
        robot.keyPress(KeyEvent.VK_B);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_K);


        robot.keyPress(KeyEvent.VK_TAB);

        // Soyisim
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_K);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);

        // T-Shirt e geçmek için
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        // T-Shirt
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        //Sweatshirt e geçmek için
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        //Sweatshirt
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        // Shoes geçmek için
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        //Shoes
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        js.executeScript("window.scrollBy(0,450)","");

        Thread.sleep(1000);

        // Saat e geçme

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        // Saat

        robot.keyPress(KeyEvent.VK_1);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_0);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_3);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_4);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        //Send Gift e geçiş
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        //Send Gift
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        js.executeScript("window.scrollBy(0,450)","");

        //Burak Türkmen'in Mentoring'leri e geçiş
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        //Burak Türkmen'in Mentoring'leri bölümü
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        // Görsel Seç e geç
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(500);

        // Görsel Butonunu Seç
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_R);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(500);

        // YUKLEME BUTONUNA TIKLAMAK ICIN

        robot.keyPress(KeyEvent.VK_RIGHT);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        System.out.println("Test Başarılı...");
        driver.quit();
    }
}
