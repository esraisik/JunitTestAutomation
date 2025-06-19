package day12_excel_getScreenshot_jsExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestbaseEach;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenshotTumSayfa  extends TestbaseEach {

    @Test
    public void test01() throws IOException {

        // testotomasyonu ana sayfaya gidin
        driver.get("https:/www.testotomasyonu.com/");

        //phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        //arama sonucunda urun bulunabildiğini test edin

        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucu = "o Products Founds";
        String actualAramaSonucu = sonucYaziElementi.getText();

        Assertions.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);

        ReusableMethods.bekle(1);
        //1. adim tss objesi olusturalım
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2. adim resmi kaydedecegimiz File'ı olusturalım
        File asilResim =new File("target/screenshots/tumSayfaScreenshot.jpeg");

        //3.adim screenshot'i alip gecici i dosya olarak kaydedelim
        File geciciDosya =tss.getScreenshotAs(OutputType.FILE);

        // 4. adim gecici dosyayı asıl dosyaya kopyalayalım

        FileUtils.copyFile(geciciDosya,asilResim);


        // tum sayfanın screenshot'ını alın

    }
}
