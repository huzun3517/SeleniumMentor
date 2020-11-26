package AhmetT.Proje4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Proje4 {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        // Select List Demo --> Select ile Day seçtirdik
        WebElement day = driver.findElement(By.cssSelector("select#select-demo"));
        Select menu = new Select(day);
        menu.selectByValue("Friday");
        menu.selectByVisibleText("Monday");

        // options sayısı ve değerleri yazdırıldı
        List<WebElement>dayList= driver.findElements(By.cssSelector("select.form-control>option"));
        dayList.remove(0);

        ArrayList<String>gunler=new ArrayList<>();

        for (WebElement gun: dayList){
            System.out.println(gun.getAttribute("value"));
            String val = gun.getAttribute("value");
            if (val.length()>0) gunler.add(val);
        }

        System.out.println("option sayısı = " + dayList.size());

        // random olarak bir index ile bir secim yaptık
        menu.selectByIndex(random(dayList.size()));
        System.out.println(day.getAttribute("value"));

        // random olarak bir value ile bir seçim yaptık  --> değerleri for içinden yazdık
        menu.selectByValue(gunler.get(random(gunler.size())));
        System.out.println(day.getAttribute("value"));

        // random olarak bir GörünürText ile bir secim yapin
        menu.selectByVisibleText(gunler.get(random(gunler.size())));
        System.out.println(day.getAttribute("value"));

        //Multi Select List Demo
        List<WebElement>countryList=driver.findElements(By.cssSelector("select#multi-select>option"));
        WebElement country = driver.findElement(By.cssSelector("select#multi-select"));
        menu = new Select(country);

        // Country option sayısı
        System.out.println("option sayısı = " + menu.getOptions().size());

        // Select ile random değer seçtirdik ve sonrasında kaldırdık
        menu.selectByIndex(random(menu.getOptions().size()));
        menu.deselectAll();

        // ilk 3 eleman seçildi
        menu.selectByIndex(0);
        menu.selectByIndex(1);
        menu.selectByIndex(2);

        //seçimler kaldırıldı
        menu.deselectAll();

        // tek sayıdaki elemanları seçtirdik
        for (int i = 0; i < countryList.size(); i+=2) {
            countryList.get(i).click();
        }

        //sayfa nın ekran görüntüsü alındı
        TakesScreenshot ts = (TakesScreenshot) driver;
        File ekranDosyasi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranDosyasi,new File("ekranGoruntuleri/proje4.png"));

        System.out.println("Test başarılı...");
        Thread.sleep(3000);
        driver.quit();
    }

    public static int random(int max){
        Random random = new Random();

        int uretilenSayi = random.nextInt(max);

        return uretilenSayi;
    }


}
