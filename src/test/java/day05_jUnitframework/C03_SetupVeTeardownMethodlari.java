package day05_jUnitframework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_SetupVeTeardownMethodlari {

    /*
        Java'da tekrar eden kodları sevmeyız

        Bir test methodu olusturuldugunda
        basta olusturmamız gereken driver objesi
         ve sondaki kapatma işlemi
         tum methodlar için lazım

         her test methodunda bunları tekrar tekrar olusturmak yerine
         method yapıp methodcall ile kullanmayı tercıh edebiliriz

     */
    WebDriver driver;
    public void setup(){
        // Web driver olusturup ayarları yapın
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void teardown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void testOtomasyonuTest () {

        setup();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com/");

        // url'in testotomasyonu içerdiğini test edin
        String expectedUrlIcerik ="testotomasyonu";
        String actualUrl =driver.getCurrentUrl();


        if(actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Test otomasyonu testi PASSED");
        }else System.out.println("Test otomasyomu testi FAILED");

        teardown();
    }

    @Test
    public void youtubeOtomasyonuTest () {

      setup();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.youtube.com/");

        // url'in testotomasyonu içerdiğini test edin
        String expectedUrlIcerik ="youtube";
        String actualUrl =driver.getCurrentUrl();


        if(actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");

       teardown();
    }

    @Test
    public void wisequarterTest () {

        setup();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.wisequarter.com/");

        // url'in testotomasyonu içerdiğini test edin
        String expectedUrlIcerik ="wisequarter";
        String actualUrl =driver.getCurrentUrl();


        if(actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarter testi FAILED");

        teardown();
    }
}
