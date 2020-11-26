package OmerBey._01_Locators_CssSelector;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class _02_Odev_Css_Selector {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // bütün webElementler için geçerli

        // Name
        WebElement name = driver.findElement(By.cssSelector("input#firstName"));
        name.sendKeys("Hüseyin");

        // Lastname
        WebElement lastname = driver.findElement(By.cssSelector("input#lastName"));
        lastname.sendKeys("Uzun");

        // E-Mail
        WebElement mail = driver.findElement(By.cssSelector("input#userEmail"));
        mail.sendKeys("huzun35@gmail.com");

        Thread.sleep(1000);

        // Gender
        WebElement gender = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        gender.click();

        // Mobile Number
        WebElement mobil = driver.findElement(By.cssSelector("input#userNumber"));
        mobil.sendKeys("017622138135");

        // Dogum Tarihi
        WebElement birth = driver.findElement(By.cssSelector("input#dateOfBirthInput"));
        birth.click();

        Select yil = new Select(driver.findElement(By.cssSelector("select.react-datepicker__year-select")));
        yil.selectByValue("1984");

        Select ay = new Select(driver.findElement(By.cssSelector("select.react-datepicker__month-select")));
        ay.selectByValue("7");

        WebElement gun = driver.findElement(By.xpath("//div[text()='18']"));
        gun.click();

        // Hobbies
        WebElement hobbies = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        hobbies.click();

        WebElement hobbies2 = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
        hobbies2.click();

        // Adress
        WebElement adress = driver.findElement(By.cssSelector("textarea#currentAddress"));
        adress.sendKeys("Kasseler str");

        // State and City Bölümü
        WebElement state = driver.findElement(By.xpath("//div[text()='Select State']"));
        state.click();
        WebElement haryana = driver.findElement(By.xpath("//div[text()='Haryana']"));
        haryana.click();

        WebElement city = driver.findElement(By.xpath("//div[text()='Select City']"));
        city.click();
        WebElement karnal = driver.findElement(By.xpath("//div[text()='Karnal']"));
        karnal.click();

        //Submit Buton
        WebElement submitButton = driver.findElement(By.cssSelector("button#submit"));
        submitButton.click();

        //Assert ile Mesajı Doğrulatma
        WebElement mesaj = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
        Assert.assertEquals("Thanks for submitting the form",mesaj.getText());
        System.out.println("Mesaj = " + mesaj.getText());

        Thread.sleep(2000);

        //Close Butonu
        WebElement closeButton = driver.findElement(By.cssSelector("button#closeLargeModal"));
        closeButton.click();

        System.out.println("Formu doldurdugunuz için teşekkür ederiz...");
        Thread.sleep(2000);
        driver.quit();
    }
}