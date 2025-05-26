package day04_mavenProjeKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_OzelWebDriverVerilirse {

    public static void main(String[] args) {


        // şirket tarafından verilen webdriver'i kullanarak
        // asagıdaki testi yapın

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //testotomasyonu anasayfasına gidin
         driver.get("https://www.testotomasyonu.com/");


        //phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        //ilk urune tıklayın
        driver.findElement(By.xpath(" (//*[@*='prod-img'])[1]"  ))
                .click();

        //acılan ilk urun sayfasındaki urunisminde
        // case sensetive olmadan "phone" gectiğini test edin
        WebElement ilkUrunisimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsim = ilkUrunisimElementi.getText().toLowerCase();
        // case sensitive olmamasi icin kucuk harfe cevirdim

        if (actualUrunIsim.contains(expectedUrunIsimIcerik)){
            System.out.println("Ilk urun isim testi PASSED");
        }else System.out.println("Ilk urun isim testi FAILED");

        // sayfayi kapatin

        ReusableMethods.bekle(2);
        driver.quit();





    }
}
