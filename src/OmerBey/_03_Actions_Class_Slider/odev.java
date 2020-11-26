package OmerBey._03_Actions_Class_Slider;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class odev {

    public static void main(String[] args) throws InterruptedException {

/*TODO
        1. driver.get("https://www.hotels.com/");  sayfasına gidin
        2. Arama kısmına "Istanbul " yazıp Enter yapın.
        3. Fiyat aralıgını $355 to $500    olarak değiştirin.
        4. Fiyatların aralıga uygun olup olmadıgını check edin ve konsola fiyatları yazdırın.
        5. ipucu: Try catch
 */

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.hotels.com");
        driver.manage().window().maximize();

        // ARAMA KISMINA ISTANBUL YAZILIP ENTER A BASILDI
        WebElement sehir = driver.findElement(By.cssSelector("#qf-0q-destination"));
        sehir.sendKeys("Istanbul");
        sehir.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // CEREZ TIKLATILDI
        WebElement cerez = driver.findElement(By.xpath("//button[text()='Zustimmen']"));
        cerez.click();

        // SLİDER BÖLÜMÜ
        WebElement solKaydirici = driver.findElement(By.cssSelector("div[aria-controls='f-price-min']"));
//        WebElement sagKaydirici = driver.findElement(By.cssSelector("div[aria-controls='f-price-max']"));
        WebElement slider = driver.findElement(By.xpath("(//div[@class='widget-slider-highlight'])[1]"));

        double genislik = slider.getSize().getWidth(); // asagidaki oran hesabinin double cikmasi icin double yaptim.

        System.out.println("Slider uzunlugu : " + genislik);

        int minSlider= 0;
        int maxSlider = 500;

        int minFiyat=355;
//        int maxFiyat=500;

        double oran = genislik/(maxSlider-minSlider); // buradaki sayilardan biri double olmaz ise sonuc double cikmiyor...

        int x = (int)(oran*minFiyat);

        System.out.println(oran+" "+x);

        Actions actions=new Actions(driver);
        actions.dragAndDropBy(solKaydirici, x, 0).perform();

        Thread.sleep(10000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,6000)"); // sayfanin en sonuna kadar veya 6000 pixel gidinceye kadar...
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-6000)");

        List <WebElement> prices = driver.findElements(By.cssSelector(".price")); // hotel fiyatlari
        List <WebElement> hotels = driver.findElements(By.cssSelector(".p-name")); // hotel isimleri

        int i=0;

        for (WebElement price:prices ) {

            System.out.print(hotels.get(i++).getText() + " : "+price.getText());

            int price1= Integer.parseInt(price.getText().replaceAll("[^0-9]", ""));

            if(price1>500) System.out.println(" < PAHALI >");

            else System.out.println();
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
