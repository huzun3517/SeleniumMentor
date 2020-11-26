package AhmetT.Proje6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Proje6 {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");

        // Tablo Satır Sayısı
        List<WebElement>satirList = driver.findElements(By.cssSelector("thead.thead-inverse+tbody>tr"));
        System.out.println("Satır sayisi = " + satirList.size());

        // Tablo Sütun Sayısı
        List<WebElement>sutunList = driver.findElements(By.xpath("(//tr[@role='row'])[1]//td"));
        System.out.println("Sütun sayisi = " + sutunList.size());

        // Ofis isimleri
        HashSet<String >ofisList= new HashSet<>();

        for (int i = 1; i <= satirList.size() ; i++) {
            WebElement ofis = driver.findElement(By.xpath("((//tr[@role='row'])[" + i + "]//td)[3]"));
            ofisList.add(ofis.getText());
        }
        System.out.println("Farklı ofis sayısı: " + ofisList.size());
        System.out.println("Ofis isimleri: ");
        System.out.println(ofisList.toString());

        // Age ortalaması
        ArrayList<Integer>agesList = new ArrayList<>();

        for (int i = 1; i <= satirList.size() ; i++) {
            WebElement age = driver.findElement(By.xpath("((//tr[@role='row'])["+ i + "]//td)[4]"));
            agesList.add(Integer.parseInt(age.getText()));
        }
        System.out.println("Personel Yaşları: ");
        System.out.println(agesList.toString());

        int top =0;
        for (int age: agesList){
            top += age;
        }
        int ort = top/agesList.size();
        System.out.println("Age ortalama = " + ort);




        // Salary ortalaması
        ArrayList<Integer >salaryList = new ArrayList<>();

        for (int i = 1; i <= satirList.size() ; i++) {
            WebElement salary = driver.findElement(By.xpath("((//tr[@role='row'])["+ i + "]//td)[6]"));
            salaryList.add(Integer.parseInt(salary.getText().replaceAll("[^0-9]","")));
        }
        System.out.println("Personel Maaşları: ");
        System.out.println(salaryList.toString());

        top = 0;
        ort = 0;

        for (int salary: salaryList){
            top += salary;
        }
        ort = top / salaryList.size();
        String ortStr = String.valueOf(ort);

        System.out.println("Maaş Ortalama = " + "$"+ ortStr.substring(0,ortStr.length()-3)+","+ortStr.substring(ortStr.length()-3));

            System.out.println("Test başarılı...");
            Thread.sleep(3000);
            driver.quit();
        }
}
