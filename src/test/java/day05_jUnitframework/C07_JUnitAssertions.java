package day05_jUnitframework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
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

public class C07_JUnitAssertions {

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

        Assertions.assertTrue( actualUrl.contains(expectedUrlIcerik),"url beklendiği gibi değil" );


    }

    @Test
    public void test02(){
        // 2- phone için arama yapın

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //    ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList =driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualBulunanUrunSayisi>0,"Arama sonucunda urun bulunamadı");



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

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik), "urun ismi phone içermiyor");




    }

}

