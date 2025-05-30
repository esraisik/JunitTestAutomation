package day05_jUnitframework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C05_BeforeAll_AfterAll {

    // 3 farklı test methodu olusturarak asagıdaki testleri gerceklestirin
    // 1- test otomasyonu anasayfaya gidin
    //     Url'in testotomasyonu içerdiğini test edin
    // 2- phone için arama yapın
    //    ve arama sonucunda urun
   //     bulunabildigini test edin
   // 3- ilk urunu tiklayin
   //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin


    /*
        Bu gorev için
        her test methodundan sonra driver'i kapatmak (@AfterEach) mantıklı olmaz


       bunun yerine
       class çalısmaya basladıgında hiç bir method calısmadan önce driver' olusturmak
       ve tum @Test methodları çalısıp bittikten sonra
       çalısacak @test methodu kalmadıgında
       kapatmnak daha mantıklı olur.

       Bu tur birbirinin sonucuna baglı test methodları oldugunda
       JUnit ile methodları tek tek run edebiliriz
        ancak method'un yapmasi gereken islevi yapmasi mumkun olmayabilir

       @BeforeAll ve @AfterAll notasyonu kullanan methodların
       mutlaka static olması gerekir.

     */

    static WebDriver driver;

    @BeforeAll
    static void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

    @Test
    public void test01 (){
        // 1- test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com/");

        //     Url'in testotomasyonu içerdiğini test edin

        ReusableMethods.bekle(2);
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Anasayfa testi PASSED");
        }else System.out.println("Anasayfa testi FAILED");

    }

    @Test
    public void test02(){
        // 2- phone için arama yapın

        WebElement aramaKutusu = driver.findElement(By.id("(//*[@class='search-label'])[1]"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //    ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList =driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        if (actualBulunanUrunSayisi>0) {
            System.out.println("Urun bulma testi PASSED");
        }else System.out.println("Urun bulma testi FAILED");


    }
    @Test
    public void test03(){

        // 3- ilk urunu tiklayin

        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();
        ReusableMethods.bekle(2);
        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        if (actualUrunIsmi.contains(expectedIsimIcerik)){
            System.out.println("Ilk urun isim testi PASSED");
        }else  System.out.println("Ilk urun isim testi FAILED");




    }


}
