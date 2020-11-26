package OmerBey._01_Locators_CssSelector;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class _01_MyStoreTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        driver.manage().window().maximize();

        // Search Arama Çubuğu
        WebElement searchArea = driver.findElement(By.cssSelector("input[name=search]"));
        searchArea.sendKeys("Iphone");

        //Search Butonu
        WebElement searcButton = driver.findElement(By.cssSelector(".btn-default.btn-lg"));
        searcButton.click();

        // Listeleme Butonu
        WebElement listButton = driver.findElement(By.cssSelector("button#list-view"));
        listButton.click();

        //Add To Cart --> Sepete Ekleme
        driver.findElement(By.cssSelector("button[onclick*=cart]")).click();

        Thread.sleep(1000);

        // Sepete Ekleme Sonrası yukarıda çıkan Alert doğrulama
        WebElement alert = driver.findElement(By.cssSelector("div.alert"));

        //Alert 'ün text halini görmek için yazdırma işlemi
        System.out.println(alert.getText());


        String textAlert  = alert.getText();

//benim istediğim sonuç
        String myAlert ="Success: You have added iPhone to your shopping cart!";

        Assert.assertEquals("Success: You have added iPhone to your shopping cart!\n" +
                "×",textAlert);
        System.out.println("Ürün başarıyla karta eklenmiştir..");

//      Assert.assertTrue(textAlert.contains(myAlert),"ürün eklenirken bir sorun olustu");

        // Sepete Tıklatma
        WebElement sepet = driver.findElement(By.cssSelector("span#cart-total"));
        sepet.click();

        Thread.sleep(1000);

        // Toplam ücret bölümü ve ücreti doğrulatma
        WebElement totalPrice = driver.findElement(By.cssSelector(".table-bordered>tbody>:last-of-type>:last-of-type"));
        System.out.println(totalPrice.getText());

        Assert.assertEquals("$123.20",totalPrice.getText());

        System.out.println("Fiyat carta işlenmiştir..");

        Thread.sleep(5000);
        driver.quit();
    }
}