package OmerBey._02_Select_Class;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.List;

public class Select {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://form.jotform.com/202468401801346");
        JavascriptExecutor js =(JavascriptExecutor) driver;
        driver.manage().window().maximize();

        //AD
        WebElement ad = driver.findElement(By.cssSelector("input#first_4"));
        ad.sendKeys("Hüseyin");

        //SOYAD
        WebElement soyad = driver.findElement(By.cssSelector("input#last_4"));
        soyad.sendKeys("U");

        //BOLUM SECINIZ
        WebElement element = driver.findElement(By.cssSelector("select#input_14"));
        org.openqa.selenium.support.ui.Select slc = new org.openqa.selenium.support.ui.Select(element);
        slc.selectByValue("Hukuk Fakültesi");

        //BAŞVURU DÖNEMİ
        element = driver.findElement(By.cssSelector("select#input_20"));
        slc = new org.openqa.selenium.support.ui.Select(element);
        slc.selectByIndex(3);

        //TELEFON KODU
        WebElement telkodu = driver.findElement(By.cssSelector("input#input_12_area"));
        telkodu.sendKeys("+49");

        //TELEFON
        WebElement tel = driver.findElement(By.cssSelector("input#input_12_phone"));
        tel.sendKeys("1763434334");

        //MAİL
        WebElement mail = driver.findElement(By.cssSelector("input#input_5"));
        mail.sendKeys("huzun35@gmail.com");

        //ADRES
        WebElement adres = driver.findElement(By.cssSelector("input#input_3_addr_line1"));
        adres.sendKeys("Kasseler str");

        //ADRES2
        WebElement adres2 = driver.findElement(By.cssSelector("input#input_3_addr_line2"));
        adres2.sendKeys("Josef");

        //CITY
        WebElement city = driver.findElement(By.cssSelector("input#input_3_city"));
        city.sendKeys("Erfurt");

        //STATE
        WebElement state = driver.findElement(By.cssSelector("input#input_3_state"));
        state.sendKeys("Erfurt");

        //POSTALCODE
        WebElement postcode = driver.findElement(By.cssSelector("input#input_3_postal"));
        postcode.sendKeys("99899");

        //COUNTRY
        element = driver.findElement(By.cssSelector("select#input_3_country"));
        slc = new org.openqa.selenium.support.ui.Select(element);
        slc.selectByValue("Germany");

        js.executeScript("window.scrollBy(0,600)");

        Thread.sleep(1000);

        //BURS DÜZEYİ
        element = driver.findElement(By.cssSelector("select#input_11"));
        slc = new org.openqa.selenium.support.ui.Select(element);

        List<WebElement> burs = slc.getOptions();

        int optionSayisi = burs.size();
        slc.selectByIndex(RandomDegerAta(optionSayisi,1));

        Thread.sleep(1000);

        //DOĞUM GÜNÜ
        element = driver.findElement(By.cssSelector("select#input_19"));
        slc = new org.openqa.selenium.support.ui.Select(element);
        slc.selectByValue("10");

        //BİZİ NEREDEN DUYDUNUZ
        element = driver.findElement(By.cssSelector("select#input_21"));
        slc = new org.openqa.selenium.support.ui.Select(element);
        slc.selectByValue("Internet");

        //KABUL ETME
        WebElement kabul = driver.findElement(By.cssSelector("input#input_22_0"));
        kabul.click();

        //SUBMİT
        WebElement submit = driver.findElement(By.cssSelector("button#input_2"));
        submit.click();

        WebElement sonKontrol = driver.findElement(By.xpath("//h1[text()='Thank You!']"));
        if (sonKontrol.isEnabled()) {
            System.out.println("Teşekkürler yazısı mevcut");
        }

        System.out.println("Test başarılı...");
        Thread.sleep(3000);
        driver.quit();
    }

    public static int RandomDegerAta(int Randommax, int Randommin) {

        int uretilenSayi = (int) (Math.random() * ((Randommax-Randommin)+1)) + Randommin;

        return uretilenSayi;
    }
}
