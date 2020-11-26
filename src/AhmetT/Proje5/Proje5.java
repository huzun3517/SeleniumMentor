package AhmetT.Proje5;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Proje5 {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html");

        //Dual List Box Example
        // Sol ve Sağdaki menüyü listeledik
        List<WebElement> solElementList = driver.findElements(By.cssSelector("div.well.text-right>div+ul>li"));
        List<WebElement> sagElementList = driver.findElements(By.xpath("//div[@class='well']//div/following-sibling::ul//li"));

        // HashSet oluşturup listedeki elemanları içine attık ki tekrar edenleri almasın
        HashSet<String> tumList = new HashSet<>();

        for (WebElement sol : solElementList)
            tumList.add(sol.getText());

        for (WebElement sag : sagElementList)
            tumList.add(sag.getText());
        System.out.print("Tüm Liste aynı elemanlar 1.kez yazıldı: ");
        System.out.println(tumList.toString());


        ArrayList<String>solListe = new ArrayList<>();
        for (WebElement sol: solElementList)
            solListe.add(sol.getText());

        ArrayList<String>sagListe = new ArrayList<>();
        for (WebElement sag: sagElementList)
            sagListe.add(sag.getText());

        //ortak olmayanlar
        List<String>ortakolmayanlar1 = new ArrayList<>(solListe);
        ortakolmayanlar1.removeAll(sagListe);

        List<String>ortakolmayanlar2 = new ArrayList<>(sagListe);
        ortakolmayanlar2.removeAll(solListe);

        ortakolmayanlar1.addAll(ortakolmayanlar2);
        System.out.print("Ortak olmayanlar: ");
        System.out.println(ortakolmayanlar1.toString());

        // ortak elemanlar
        List<String>ortakolanlar = new ArrayList<>(solListe);
        ortakolanlar.retainAll(sagListe);
        System.out.print("Ortak elemanlar: ");
        System.out.println(ortakolanlar.toString());

            System.out.println("Test başarılı...");
            Thread.sleep(3000);
            driver.quit();
        }
}
