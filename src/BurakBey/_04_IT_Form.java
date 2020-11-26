package BurakBey;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class _04_IT_Form {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://form.jotform.com/202543889228363");

        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //AD SOYAD
        driver.findElement(By.id("first_3")).sendKeys("Hüseyin");
        driver.findElement(By.id("last_3")).sendKeys("U");

        //ŞİRKET
        driver.findElement(By.id("input_4")).sendKeys("Techno Study");

        //ADRES
        driver.findElement(By.id("input_12_addr_line1")).sendKeys("Langberg Street");
        driver.findElement(By.id("input_12_addr_line2")).sendKeys("12");
        driver.findElement(By.id("input_12_city")).sendKeys("Frankfurt");
        driver.findElement(By.id("input_12_state")).sendKeys("Hessen");
        driver.findElement(By.id("input_12_postal")).sendKeys("60306");

        //COUNTRY
        Select country = new Select(driver.findElement(By.cssSelector("select#input_12_country")));
        country.selectByValue("Germany");

        //TELEFON NUMARASI
        driver.findElement(By.id("input_13_area")).sendKeys("+49");
        driver.findElement(By.id("input_13_phone")).sendKeys("12334512");

        //E-MAİL
        WebDriverWait mailWait = new WebDriverWait(driver,10);
        WebElement email = mailWait.until(ExpectedConditions.elementToBeClickable(By.id("input_6")));
        email.sendKeys("huzun35@gmail.com");

        //scroll down
        js.executeScript("window.scrollBy(0,450)","");

        // Problem Katagori
        driver.findElement(By.id("input_7_0")).click();

        // Problem Yazısı
        driver.findElement(By.id("input_16")).sendKeys("İnternet hızı yavaş");

        // Soru yorum
        driver.findElement(By.id("input_9")).sendKeys("Sorunumu acil çözün");

        // Saat
        Select saat = new Select(driver.findElement(By.id("input_18_hourSelect")));
        saat.selectByValue("10");

        Select dakika = new Select(driver.findElement(By.id("input_18_minuteSelect")));
        dakika.selectByValue("30");

        Select AmPm = new Select(driver.findElement(By.id("input_18_ampm")));
        AmPm.selectByValue("AM");

        // Göder Butonu
        WebDriverWait gonderWait = new WebDriverWait(driver,10);
        WebElement gonder = gonderWait.until(ExpectedConditions.elementToBeClickable(By.id("input_17")));

        System.out.println("Test başarılı...");
        Thread.sleep(3000);
        driver.quit();
    }
}
