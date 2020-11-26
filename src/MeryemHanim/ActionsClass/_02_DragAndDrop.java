package MeryemHanim.ActionsClass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

public class _02_DragAndDrop {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://uitestpractice.com/"); // siteyi açtım
        driver.manage().window().maximize();

        WebElement drag = driver.findElement(By.cssSelector("div#draggable"));

        WebElement drop = driver.findElement(By.cssSelector("div#droppable"));

        Actions actions = new Actions(driver);

        Thread.sleep(500);
        actions.dragAndDrop(drag,drop).perform();

        // Sürüklenip bırakıldıktan sonra kutunun içine yerkeşmesini doğrulatma
        WebElement droppedElement = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        Assert.assertEquals("Kutuya yerleşmedi. Hatalı...","Dropped!",droppedElement.getText());

        System.out.println(droppedElement.getText());

        System.out.println("Test başarılıdır");

        Thread.sleep(2000);
        driver.quit();

    }
}
