package day05_jUnitframework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TestNotasyonu {

    /*
        @Test motasyonu siradan bir methodu
        tek basına Run edilebilir.

        @Test notasyonu sayesinde
        her bir testi bagımsız olarak çalıstırabilecegımız gibi
        class isminin yanındaki run tusu ile
        class'taki TUM test Methodlarını toplu olarak da çalıstırabiliriz

        JUnit @Test method'ların çalısma sırasını
        kendine göre duzenler
        belirlenmıs bir sıralama duzeni yoktur.
        sıralamayı ongöremeyız ve kontrol edemeyız


        eger sıralı calısmasını istediginiz
        test methodları varsa
        isimlerini test01, test02, test03 diye belirlemek gerekir.


     */

    @Test
    public void testOtomasyonuTest () {

        // Web driver olusturup ayarları yapın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com/");

        // url'in testotomasyonu içerdiğini test edin
        String expectedUrlIcerik ="testotomasyonu";
        String actualUrl =driver.getCurrentUrl();


        if(actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Test otomasyonu testi PASSED");
        }else System.out.println("Test otomasyomu testi FAILED");

        driver.quit();
    }

    @Test
    public void youtubeOtomasyonuTest () {

        // Web driver olusturup ayarları yapın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        // testotomasyonu anasayfaya gidin
        driver.get("https://www.youtube.com/");

        // url'in testotomasyonu içerdiğini test edin
        String expectedUrlIcerik ="youtube";
        String actualUrl =driver.getCurrentUrl();


        if(actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");

        driver.quit();
    }

    @Test
    public void wisequarterTest () {

        // Web driver olusturup ayarları yapın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        // testotomasyonu anasayfaya gidin
        driver.get("https://www.wisequarter.com/");

        // url'in testotomasyonu içerdiğini test edin
        String expectedUrlIcerik ="wisequarter";
        String actualUrl =driver.getCurrentUrl();


        if(actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarter testi FAILED");

        driver.quit();
    }
}
