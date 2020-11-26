package OmerBeyYoutube._08_09_Alert;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Alert1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.demo.guru99.com/test/delete_customer.php");

        driver.manage().window().maximize();

        //ARAMA BUTONUNA DEĞER GİRME
        WebElement customer_Id = driver.findElement(By.xpath("//input[@name='cusid']"));
        customer_Id.sendKeys("asd123");

        // SUBMİT BUTONUNA TIKLATMA
        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
        submitButton.click();

        Thread.sleep(2000);

        // ALERT HATA KODUNU KABUL ETME-->TAMAM TIKLATMA
        driver.switchTo().alert().accept(); // --> kabul etme
    // driver.switchTo().alert().dismiss(); // --> iptal etme


        Thread.sleep(2000);

        // EN SON SAYFADAKİ ALERT MESAJINI ASERT İLE DOĞRULATMA
        Assert.assertEquals("Customer Successfully Delete!",driver.switchTo().alert().getText());

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();









        System.out.println("Test Başarılı...");

   //     driver.quit();
    }
}