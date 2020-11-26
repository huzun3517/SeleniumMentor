package OmerBeyYoutube._11_Testler;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class test1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.tutorialsninja.com/demo/index.php?route=common/home");

        driver.manage().window().maximize();

        // My Account
        WebElement myAccount = driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]"));
        myAccount.click();

        Thread.sleep(1000);

        // Register
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();

        //First Name
        WebElement firstName = driver.findElement(By.cssSelector("input#input-firstname"));
        firstName.sendKeys("Hüseyin");

        //Last Name
        WebElement lastName = driver.findElement(By.cssSelector("input#input-lastname"));
        lastName.sendKeys("U");

        //E-Mail  --> DİKKAT bir E-Mail ile sadece 1 kere register yapabiliyoruz. Her seferinde yeni Mail yazılmalı.
        WebElement mail = driver.findElement(By.cssSelector("input#input-email"));
        mail.sendKeys("huzun12@gmail.com");

        //Telephone
        WebElement telephone = driver.findElement(By.cssSelector("input#input-telephone"));
        telephone.sendKeys("3670562");

        //Password
        WebElement password = driver.findElement(By.cssSelector("input#input-password"));
        password.sendKeys("3670562");

        //Password2
        WebElement password2 = driver.findElement(By.cssSelector("input#input-confirm"));
        password2.sendKeys("3670562");

        // Privacy Policy
        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicy.click();

        // Continue Button
        WebElement continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        continueButton.click();

        // Açılan sayfadaki mesajı Assert ile Doğrulatma
        String myMessage = "Your Account Has Been Created!";

        Assert.assertEquals(myMessage,driver.getTitle());

        Thread.sleep(2000);

        System.out.println("Hesabınız oluşturuldu...");

        driver.quit();
    }
}