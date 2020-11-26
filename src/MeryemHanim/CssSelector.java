package MeryemHanim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

public class CssSelector {

    public static void main(String[] args) throws InterruptedException {

/*
todo        name -->  user[postal_code]

todo        input[name^='user[p']  -->  ^  prefix

todo        input[name$='code]']  -->   $  suffix

todo        input[name*='cod']  -->   *  contains
*/

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://developer.salesforce.com/signup"); // siteyi açtım
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();

        driver.findElement(By.cssSelector("#first_name")).sendKeys("Hüseyin");
        // CssSellector için Console kontrol -->  $("input[name='user[first_name]']");

        // 2.Yol
 //     driver.findElement(By.xpath("//input[@name='user[first_name]']")).sendKeys();
        // Xpath için Console kontrol -->  xpath-- $x("//input[@name='user[first_name]']");

        driver.findElement(By.cssSelector("#last_name")).sendKeys("Uzun");

        driver.findElement(By.cssSelector("input#email")).sendKeys("h35@gmail.com");

        Select role = new Select(driver.findElement(By.cssSelector("select#job_role")));
        role.selectByValue("IT Manager/Executive");

        driver.findElement(By.cssSelector("input#company")).sendKeys("Techno Study");

        Select country = new Select(driver.findElement(By.cssSelector("select#country")));
        country.selectByValue("DE");

        driver.findElement(By.cssSelector("input#postal_code")).sendKeys("99089");

        driver.findElement(By.cssSelector("input#username")).sendKeys("huzun35@gmail.com");

        driver.findElement(By.cssSelector("label#opt-in-label")).click();
        driver.findElement(By.cssSelector("label[for='eula']")).click();
        driver.findElement(By.cssSelector("input#submit_btn")).click();

        System.out.println("Test başarılıdır");

        Thread.sleep(5000);
        driver.quit();

    }
}
