package BurakBey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

public class _01_Form {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // consola yazılan gereksiz bilgileri sessize aldı.
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        // hangi browseri kullanacağımı ve tarayıcının path ini verdim.
        WebDriver driver = new ChromeDriver(); // çalıştıracağımız driveri kontrol edecek değişkeni tanımladım.

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"); // siteyi açtım
        driver.manage().window().maximize();

        driver.findElement(By.id("email_create")).sendKeys("sensen@gmail.com");

        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("id_gender1")).click();

        driver.findElement(By.id("customer_firstname")).sendKeys("Huseyin");

        driver.findElement(By.id("customer_lastname")).sendKeys("Sen");

        driver.findElement(By.id("passwd")).sendKeys("senaysen");

        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByValue("18");

        Select ay = new Select(driver.findElement(By.id("months")));
        ay.selectByValue("8");

        Select yil = new Select(driver.findElement(By.id("years")));
        yil.selectByValue("1984");

        driver.findElement(By.id("company")).sendKeys("TechnoStudy");
        driver.findElement(By.id("address1")).sendKeys("Landberg Street. 12 ");
        driver.findElement(By.id("address2")).sendKeys("NYC 4587");
        driver.findElement(By.cssSelector("#city")).sendKeys("New York City");

        Select city = new Select(driver.findElement(By.cssSelector("select[id=id_state]")));
        city.selectByValue("32");

        driver.findElement(By.cssSelector("#postcode")).sendKeys("10006");
        driver.findElement(By.cssSelector("#other")).sendKeys("Stay home");
        driver.findElement(By.cssSelector("#phone")).sendKeys("23232424242323");
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("25314532122");

   //     driver.findElement(By.cssSelector("#submitAccount")).click();

        System.out.println("Test başarılıdır");

        Thread.sleep(5000);
        driver.quit();

    }
}
