package OmerBeyYoutube._11_Testler;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class test3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.tutorialsninja.com/demo/index.php?route=common/home");

        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // SEARCH
        WebElement search = driver.findElement(By.cssSelector("input.form-control.input-lg"));
        search.sendKeys("Iphone");

        // ARATMAYA TIKLATMA
        WebElement ara = driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg"));
        ara.click();

        // LİSTBUTTON TIKLATMA
        WebElement listButton = driver.findElement(By.cssSelector("button#list-view"));
        listButton.click();

        // ADD TO CART TIKLATMA
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[onclick*=cart]"));
        addToCartButton.click();

        Thread.sleep(1000);

        // ALERT TEXT INI ALDIK
        WebElement alert = driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible"));
        System.out.println(alert.getText());

        String myAlert = "Success: You have added iPhone to your shopping cart!\n" +
                "×";

        // ASSERT İLE ALERT MESAJINI DOGRULATMA
        Assert.assertEquals(myAlert,alert.getText()); //1.Yol
        System.out.println("Test 1 geçmiştir...");

        Assert.assertTrue(alert.getText().contains("Success: You have added iPhone")); // 2.yol
        System.out.println("Test 2 geçmiştir...");

        // CART BUTTON --> SEPETE TIKLATMA
        WebElement cartButton = driver.findElement(By.cssSelector("span#cart-total"));
        cartButton.click();

        // TOTAL PRICE --> SEPETTEKI URUNUN FİYATI
        WebElement totalPrice = driver.findElement(By.cssSelector("table.table.table-bordered>tbody>tr:last-of-type>td:last-of-type"));
        System.out.println(totalPrice.getText());

        // ASSERT İLE SEPETE EKLENEN URUNUN FIYATININ SEPETTEKI FIYATA YANSIMASI
        String myTotal = "$123.20";

        Assert.assertEquals(myTotal,totalPrice.getText());

        System.out.println("Fiyat karta yansımıştır...");

        Thread.sleep(3000);

        // REMOVE BUTTON
        WebElement removeButton = driver.findElement(By.xpath("//button[@title='Remove']"));
        removeButton.click();

        Thread.sleep(1000);

        // CART BUTTON --> SEPETE TIKLATMA
        WebElement cartButton2 = driver.findElement(By.cssSelector("span#cart-total"));
        cartButton2.click();

        Thread.sleep(2000);

        // REMOVE MESSAGE
        WebElement removeMessage = driver.findElement(By.cssSelector("p.text-center"));
        System.out.println(removeMessage.getText());

        //ASSERT İLE KARTTAN ÜRÜNÜN SİLİNDİĞİNİ DOĞRULATMA
        Assert.assertTrue(removeMessage.getText().contains("empty"));

        System.out.println("Kartınız boş...");

        driver.quit();
    }
}