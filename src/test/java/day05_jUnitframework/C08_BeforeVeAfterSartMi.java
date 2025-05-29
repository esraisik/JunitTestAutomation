package day05_jUnitframework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C08_BeforeVeAfterSartMi {

    // Tek test methodu olusturarak asagıdaki testleri gerceklestirin
    // 1- test otomasyonu anasayfaya gidin
    //     Url'in testotomasyonu içerdiğini test edin
    // 2- phone için arama yapın
    //    ve arama sonucunda urun
    //     bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    WebDriver driver;

    /*
        Verilen görev tek bir test methodu ile yapılacak bir görev olsa da

        Webdriver'i olusturma ve kapatma işlemini ayrı bir setup() ve teardown() ile
        yapmayı tercih ederiz

        eger tek bir test methodunun içinde
         webdriver olusturma ve sonunda driver'i kapatma işlemlerini yaparsak
         Test failed oldugunda exception olustugu için
         kodun çalısması durur ve son satırdaki driver.quit() calısmaz

         ozellıkle toplu çalıstırmalarda
         kapanmayan browserlarin olması
         guzel olmaz

     */

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown (){
        driver.quit();
    }

    @Test
    public void urunTesti(){


        // 1- Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        //    Url'in testotomasyonu icerdigini test edin
        ReusableMethods.bekle(2);

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(  actualUrl.contains(expectedUrlIcerik) ,"Url beklendigi gibi degil" );

        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(2);

        //    ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='prod-img']"));
        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualBulunanUrunSayisi > 0,"Arama sonucunda urun bulunamadi");

        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();
        ReusableMethods.bekle(2);

        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin
        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik),"Urun ismi phone icermiyor");
    }






}
