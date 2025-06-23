package day12_excel_getScreenshot_jsExecutors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestbaseEach;

public class C05_MethodIleGetScreenshot extends TestbaseEach {

    @Test
    public void test01 (){


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

        //tum sayfa screenshot alın

        ReusableMethods.tumSayfaScreenshotIsimli(driver,"aramatesti");

        //ilk urunu tiklayın
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // acılan sayfadaki urun isminde case sensetive olmadan phone bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik ="phone";
        String actualIsimIcerik = ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualIsimIcerik.contains(expectedIsimIcerik));

        ReusableMethods.tumSayfaScreenshotTarihli(driver);






    }

}
