package OmerBey._04_Alert_Handle_Window;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Handle_Window {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.demo.guru99.com/popup.php");

        driver.manage().window().maximize();

        // İlk pencerem Ana Sayfa
        String firstWinID = driver.getWindowHandle();
        String firstWinUrl = driver.getCurrentUrl();

        // Click Here
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();

        // ID leri listelettik sonra 2.pencereye geçtik
        Set<String> windowAllWindows = driver.getWindowHandles();

        for (String window: windowAllWindows) {
            driver.switchTo().window(window);
        }

        Thread.sleep(1500);

        // 2.Penceredeki E-Mail Bölümü
        WebElement name = driver.findElement(By.cssSelector("input[name='emailid']"));
        name.sendKeys("huzun35@gmail.com");

        // 2.Penceredeki Submit Bölümü
        WebElement submitButton = driver.findElement(By.cssSelector("input[name='btnLogin']"));
        submitButton.click();

        System.out.println("2.pencerenin urlsi: " + driver.getCurrentUrl());

        driver.close();

//      Assert.assertEquals(firstWinUrl,driver.getCurrentUrl());
//      Yeni sekmeyi kapattık. Fakat driver orayı gösteriyor. Ana sayfaya geçmedik oyüzden Assert ile doğrulama yaptırınca hata verdi.

        driver.switchTo().window(firstWinID); // ilk pencereye geçildi.Anasayfam

        System.out.println(driver.getCurrentUrl()); // ana sayfanın url si.

        Assert.assertEquals(firstWinUrl,driver.getCurrentUrl()); // Anasayfanın url si doğrulandı

        System.out.println("Test başarılı");
        driver.quit();

    }
}