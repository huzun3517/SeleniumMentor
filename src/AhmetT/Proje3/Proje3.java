package AhmetT.Proje3;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Proje3 {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");

        // Radio Button Demo Male
        WebElement maleButton = driver.findElement(By.xpath("//input[@name='optradio']"));
        maleButton.click();

        // buttonCheck
        WebElement buttonCheck = driver.findElement(By.cssSelector("button#buttoncheck"));
        buttonCheck.click();

        // Male Button Doğrulama
        String beklenen = "Radio button 'Male' is checked";
        RadioButtonDogrulama(beklenen,driver);

        // Radio Button Demo Female
        WebElement femaleButton = driver.findElement(By.xpath("(//input[@name='optradio'])[2]"));

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(femaleButton)).click();

        femaleButton.click();

        // buttonCheck
        buttonCheck.click();

        // Female Button Doğrulama
       beklenen = "Radio button 'Female' is checked";
       RadioButtonDogrulama(beklenen,driver);

       //Group Radio Buttons Demo
        // Ekranı "Group Radio Buttons Demo" yazısına kadar kaydırma
        WebElement element = driver.findElement(By.xpath("//div[text()='Group Radio Buttons Demo']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);

        // Female Button
        WebElement female = driver.findElement(By.xpath("(//input[@name='gender'])[2]"));
        WebElement ageGroup = driver.findElement(By.xpath("(//input[@name='ageGroup'])[2]"));
        Actions actions = new Actions(driver);

        Action action = actions.moveToElement(female).click().build();
        action.perform();

        // Age Group Button
        action = actions.moveToElement(ageGroup).click().build();
        action.perform();

        // get Values Button
        WebElement getValuesButton = driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
        getValuesButton.click();

        // Gelen yazıya kadar bekletildi
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.groupradiobutton")));
        text.click();

        // Male Button
        WebElement male = driver.findElement(By.xpath("//input[@name='gender']"));
        ageGroup = driver.findElement(By.xpath("//input[@name='ageGroup']"));

        action = actions.moveToElement(male).click().build();
        action.perform();

        // Age Group Button
        action = actions.moveToElement(ageGroup).click().build();
        action.perform();

        // get Values Button
        getValuesButton.click();

        // Gelen yazıya kadar bekletildi
        text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.groupradiobutton")));
        text.click();

        //sayfa nın ekran görüntüsü alındı
        TakesScreenshot ts = (TakesScreenshot) driver;
        File ekranDosyasi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranDosyasi,new File("ekranGoruntuleri/proje3.png"));

        System.out.println("Test başarılı...");
        Thread.sleep(3000);
        driver.quit();
    }
    public static void RadioButtonDogrulama(String beklenen,WebDriver driver){
        WebElement message = driver.findElement(By.cssSelector("p.radiobutton"));
        Assert.assertEquals(message.getText(),beklenen);
    }

}
