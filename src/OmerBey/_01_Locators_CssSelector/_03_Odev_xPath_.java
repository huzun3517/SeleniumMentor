package OmerBey._01_Locators_CssSelector;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import java.util.List;

public class _03_Odev_xPath_ {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://form.jotform.com/202426526543351"); // 1.bölüm
        JavascriptExecutor js =(JavascriptExecutor) driver;
        driver.manage().window().maximize();

        WebElement name = driver.findElement(By.xpath("//input[@id='first_3']")); // 2.bölüm
        name.sendKeys("Hüseyin");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_3']")); // 2.bölüm
        lastName.sendKeys("U");

        WebElement areaCode = driver.findElement(By.xpath("//input[@id='input_8_area']")); // 3.bölüm
        areaCode.sendKeys("345");

        WebElement phoneNummer = driver.findElement(By.xpath("//input[@id='input_8_phone']")); // 3.bölüm
        phoneNummer.sendKeys("3434343434");

        WebElement mail = driver.findElement(By.xpath("//input[@id='input_9']")); // 4.bölüm
        mail.sendKeys("huzun35@gmail.com");

        Thread.sleep(1000);

        List<WebElement> calisList = driver.findElements(By.cssSelector("span.form-radio-item"));

        for (int i = 0; i < calisList.size(); i++) {
            calisList.get(i).click();
            Thread.sleep(1000);
        }

        WebElement other = driver.findElement(By.cssSelector("#input_21")); // 5.bölüm
        other.sendKeys("5-9");

        js.executeScript("window.scrollBy(0,600)");


        List<WebElement> ilgiAlaniList = driver.findElements(By.cssSelector("div#cid_14>div>span"));// 6.bölüm

        System.out.println("İlgi alanlarım :");

        for (int i = 0; i < ilgiAlaniList.size(); i+=2) {
            ilgiAlaniList.get(i).click();
            Thread.sleep(1000);
            System.out.println(ilgiAlaniList.get(i).getText());
        }

        Thread.sleep(1000);


        List<WebElement> yetenekList = driver.findElements(By.cssSelector("div#cid_15>div>span"));// 7.bölüm

       WebElement yetenekE = yetenekList.get(RandomDegerAta(0,4));
       yetenekE.click();

        System.out.println("Özel yeteneğim : " + yetenekE.getText());

        Thread.sleep(1000);

        WebElement yorum = driver.findElement(By.cssSelector("div#cid_16")); // 8.bölüm
        yorum.click();

        Thread.sleep(500);

        WebElement yorum2 = driver.findElement(By.cssSelector("#input_16")); // 8.bölüm
        yorum2.sendKeys("Geri dönüşünüzü sabırsızlıkla bekliyorum.");


        WebElement gonder = driver.findElement(By.cssSelector("button#input_2")); // 9.bölüm
        gonder.click();


        WebElement kontrol = driver.findElement(By.xpath("//h1[text()='Thank You!']")); // 10.bölüm
        String kontrolStr = kontrol.getText();
        Assert.assertEquals("Thank You!",kontrolStr);


        System.out.println("Form başarıyla gönderilmiştir..");
        Thread.sleep(5000);
        driver.quit();

    }

    public static int RandomDegerAta(int Randommax, int Randommin) {

        int uretilenSayi = (int) (Math.random() * ((Randommax-Randommin)+1)) + Randommin;

        return uretilenSayi;
    }
}
