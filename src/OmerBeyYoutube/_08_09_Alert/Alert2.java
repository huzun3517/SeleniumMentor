package OmerBeyYoutube._08_09_Alert;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Alert2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://demo.automationtesting.in/Alerts.html");

        Thread.sleep(2000);

        // Basit Uyarı (Tek butondan oluşan)
        WebElement alert1 = driver.findElement(By.cssSelector("button.btn.btn-danger"));
        alert1.click();
        Thread.sleep(2000);

        String message1 = driver.switchTo().alert().getText(); // Alert1 in text ini yazdırdık.
        System.out.println("Alert1'in mesajı: " + message1);

        Thread.sleep(1000);

        driver.switchTo().alert().accept(); // --> alert onayla


        // Teyit Uyarıları
        WebElement button2 = driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
        button2.click();

        WebElement alert2 = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        alert2.click();

        Thread.sleep(1500);

        driver.switchTo().alert().dismiss();

        Thread.sleep(1500);


        // input bekleyen uyarılar
        WebElement button3 = driver.findElement(By.xpath("(//a[@class='analystic'])[3]"));
        button3.click();

        WebElement alert3 = driver.findElement(By.cssSelector("button.btn.btn-info"));
        alert3.click();

        Thread.sleep(1500);

        driver.switchTo().alert().sendKeys("Hüseyin"); // input girdik

        driver.switchTo().alert().accept(); // inputu onayladık


        //Alert3 ün Text ini yazdırma
        String message3 = driver.findElement(By.cssSelector("p#demo1")).getText();

        System.out.println("Alert3'ün mesajı: " + message3);

        System.out.println("Test Başarılı...");

        driver.quit();
    }
}