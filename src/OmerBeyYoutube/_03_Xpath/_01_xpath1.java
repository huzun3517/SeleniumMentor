package OmerBeyYoutube._03_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class _01_xpath1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.de/");
        driver.manage().window().maximize();

/*
                  Xpath, daha spesifik olup dinamik ögeleri rahatlıkla bulmamızı sağlar.
                    Basic xpath = //tagname[@attribute=’value’] ---             //etiketadı[@nitelik = 'değer']

                   1.Absolute Xpath
            /html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]


                   2.Relative Xpath
                   //input[@name='q']
*/
/*
                   3.Contains (ait olmak)
                 Dinamik değişikliklerin olabileceği durumlarda:
                 Xpath //*[contains(@type,'sub')] ----                      //etiketadi(contains(@nitelik,'değer')]         * işareti tüm html kodlarını kapsar.(Tümü)


                 4.Starts-with()
            Aramalarımızda uzun kodları daha kolay bulmamızı sağlar.


                 5.OR, AND
                 OR için iki kısımdan bir tanesinin doğru olması yeterli.
                 AND için iki tarafın da doğru olması gerekiyor.
*/

        driver.findElement(By.xpath("//span[text()='und Bestellungen']")).click();

    }
}