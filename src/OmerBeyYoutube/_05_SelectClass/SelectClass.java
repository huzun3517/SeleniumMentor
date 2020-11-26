package OmerBeyYoutube._05_SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClass {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        //   JavascriptExecutor js = (JavascriptExecutor) driver;


        driver.findElement(By.cssSelector("span.cookie-choices-buttons>:nth-child(2)")).click();


//isim ve soyisim

        WebElement isim = driver.findElement(By.name("firstname"));
        isim.sendKeys("Ömer");

        WebElement soyisim = driver.findElement(By.name("lastname"));

        soyisim.sendKeys("Özdemir");


        //gender
        WebElement gender = driver.findElement(By.xpath("//input[@value='Male']"));
        //pixel
        // js.executeScript("window.scrollBy(0,100)");
        gender.click();

        List<WebElement> list = driver.findElements(By.cssSelector("div[dir=ltr]>:nth-child(24)>input"));

        for (int i = 0; i < list.size(); i++) {

            list.get(i).click();
            Thread.sleep(500);

        }


//Date

        WebElement date = driver.findElement(By.cssSelector("#datepicker"));

        //     js.executeScript("arguments[0].scrollIntoView();", date);

        date.sendKeys("23.07.2020");


        //profession

        driver.findElement(By.xpath("//input[@value='Automation Tester']")).click();


        //automation tools

        List<WebElement> tools = driver.findElements(By.xpath("(//div[@class='control-group'])[7]//input"));

        for (WebElement tool : tools) {
            tool.click();
            Thread.sleep(500);
        }

        //Continents

        WebElement element = driver.findElement(By.cssSelector("#continents"));

        Select slc = new Select(element);

        slc.selectByVisibleText("Europe");


//selenium Commands

        element = driver.findElement(By.cssSelector("#selenium_commands"));


        slc = new Select(element);

        slc.selectByIndex(0);
        slc.selectByIndex(1);


        Thread.sleep(3000);

        System.out.println("Test Başarılı...");

    //    driver.quit();


    }
}