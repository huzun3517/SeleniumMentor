package BurakBey;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

public class _02_isEnabled_isSelected_isDisplayed {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://form.jotform.com/202422515857050");
        JavascriptExecutor js =(JavascriptExecutor) driver;
        driver.manage().window().maximize();

        //AD
        WebElement ad = driver.findElement(By.xpath("//input[@id='first_6']"));
        ad.sendKeys("Hüseyin");

        //SOYAD
        WebElement soyad = driver.findElement(By.xpath("//input[@id='last_6']"));
        soyad.sendKeys("U");

        //MAİL
        WebElement mail = driver.findElement(By.xpath("//input[@id='input_12']"));
        mail.sendKeys("huzun3517@gmail.com");

        // isEnabled YAŞ KUTUSU KONTROL
        WebElement yaskontrol = driver.findElement(By.xpath("//input[@id='input_10']"));

        if (yaskontrol.isEnabled()){
            System.out.println("Yaş Kutusu Mevcuttur...");
        }

        //YAS
        WebElement yas = driver.findElement(By.xpath("//input[@id='input_10']"));
        yas.sendKeys("35");

        Thread.sleep(500);

        //HOBİ
        Select hobi = new Select(driver.findElement(By.xpath("//select[@id='input_11']")));
        hobi.selectByValue("Film/dizi izlemek");

        Thread.sleep(500);

        js.executeScript("window.scrollBy(0,600)");

        //DERS ÇALIŞMA
        WebElement ders = driver.findElement(By.xpath("//input[@id='input_14_3']"));
        ders.click();

        //KAÇ SAAT DERS ÇALIŞMA SEÇİLMESİ KONTROLÜ
        WebElement dersKontrol = driver.findElement(By.xpath("//input[@id='input_14_3']"));

        if (dersKontrol.isSelected()) {
            System.out.println("Kaç Saat ders çalıştığı seçildi...");
        }

        Thread.sleep(500);


        //DERS ÇALIŞAMAMA NEDENİ
        WebElement dersCalis = driver.findElement(By.xpath("//input[@id='input_16_1']"));
        dersCalis.click();

        //PUAN VERME
        WebElement puanver = driver.findElement(By.xpath("//input[@id='1599146075783-number']"));
        puanver.sendKeys("10");

        //FORMU BİTİR
        WebElement gonder = driver.findElement(By.xpath("//button[@id='input_2']"));
        gonder.click();

        //TEŞEKKÜR YAZISI KONTROL
        WebElement sonKontrol = driver.findElement(By.xpath("//h1[text()='Teşekkürler!']"));
                                                            //h1[contains(text(),'Teşekkürler!')]

        if (sonKontrol.isEnabled()) {
            System.out.println("Teşekkürler yazısı mevcut...");
        }

        System.out.println("Test başarılı...");
        Thread.sleep(3000);
        driver.quit();
    }
}
