package OmerBeyYoutube._04_CssSelector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class CssSelector {

    public static void main(String[] args) {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");
        driver.manage().window().maximize();


        //todo   CHİLD BULARAK  ve basit hali


         //input[class=gNO89b]

        //  html > body > div> style
        //  html>body>div>div


        /*todo      #id

         Başına # koyarız.

    Ya da    div[id=footer]
             #footer
             div#footer
*/



/*    todo  CLASS
        .RNmpXc
        input[class=RNmpXc]

    input.gLFyf.gsfi
    Birden fazla class var ise aralarına nokta koyuyoruz.


    todo   CONTAİNS

    input[id*='user']
    input[id*='name']
    input[class*=gLFyf]
    input[class*=gLF]
    maxlength text kısmı
    input[maxlength*='4']


    todo Starting the text ve Child mantıgı

    div[class^='R']
    input[maxlength^='207']

    div#searchform.jhp.big>nth-child(1)
    div.sfbg>:first-child
    div.J9leP>:nth-child(1)
    div#searchform>:nth-child(3)
    div#tophf>:nth-child(2)

    todo     ending with
     $
    input[id$='name']
    id = Search form
    div[id$='form']
    div[id$=b]


    todo nth-of-type , first-of-type
    ul.erkvQe>li:first-of-type
    ul.erkvQe>li:last-of-type
    ul.erkvQe>li:nth-of-type(2)
    ul.erkvQe>:last-of-type
*/
    }
}
