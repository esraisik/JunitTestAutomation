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

public class C06_Assertion {

    // 3 farklı test methodu olusturarak asagıdaki testleri gerceklestirin
    // 1- test otomasyonu anasayfaya gidin
    //     Url'in testotomasyonu içerdiğini test edin
    // 2- phone için arama yapın
    //    ve arama sonucunda urun
    //     bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin


    /*
        jUnit bir test methodunun
        PASSED veya FAILED olmasına
        kodların sorunsuz olarak çalısıp bitip bitmemesine göre karar verir

        Biz if-else ile test yaparsak
        İf-else FAILED yazdırda bile
        kodlar problem olmadan  çalısmaya devaam ettiği için
        methodun sonunda JUnit test PASSED olarak algılar
        ve yesil tik koyar

        Ozellikle toplu test calısmalarda
        konsolu inceleyip bir suru
        yazı arasında test PASSED veya
        test FAILEd sonucunu aramak ve kac testin
        FAILED oldugunu hesaplamak neredeyse imkansızdır.

        Eger if ile test yapıyorsak
        ve failed oldugunda junıt'in de bunu algılamasını istiyorsak
        throw keyword'u ile kontrollu olaral exceptiın olusturabiliriz.

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
        System.out.println(actualUrl);


        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Anasayfa testi PASSED");
        }else System.out.println("Anasayfa testi FAILED");
       // throw new RuntimeException("actualurl expectedUrl'den farkli");

    }

    @Test
    public void test02(){
        // 2- phone için arama yapın

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //    ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList =driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        if (actualBulunanUrunSayisi>0) {
            System.out.println("Urun bulma testi PASSED");
        }else System.out.println("Urun bulma testi FAILED");
       // throw new RuntimeException("Urun bulunamadı");


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
      //  throw new RuntimeException();




    }

}
