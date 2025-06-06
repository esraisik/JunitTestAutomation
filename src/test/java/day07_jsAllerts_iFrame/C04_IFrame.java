package day07_jsAllerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestbaseEach;

public class C04_IFrame extends TestbaseEach {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/discount adresine gidin

        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin

                //electronics products yazısını unique olarak locate etmemize ragmn kullanamadık
                // HTML kodları inceleyince kullanmak istediğimiz webelementin
                //bir iframe(gömülü HTML sayfa) içerisinde olduğunu belirledik
                //bir iframe içersindeki elementi kullanabilmek için
                // once o iframe'e geciş yapmamız gerekir




        WebElement electronicsiframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsiframeElementi);


        WebElement elecronicsProductYaziElement = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellElementi = driver.findElement(By.id("pictext1"));

        String expectedUrunIsmi="DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Sale up tı 50% yazısının görunur oldugunu test edin

        // iframe içine geciş yapınca biz driver'ı oradan cıkarıncaya  kadar
        // driver o iframe'în icinde kalır
        // driver'i içinde oldugu iframe'den cıkarmak için

        //driver.switchTo().parentFrame();
        //iç içe birden fazla katman olarak iframe'ler varsa
        // bir ust katmana cıkartır

        driver.switchTo().defaultContent();
        //iç içe birden fazla katman olarak iframe'ler varsa
        //direkt anasayfata cıkartır.

        WebElement saleUpYaziElementi = driver.findElement(By.xpath("//*[text()='Sale Up To 50%']"));

        Assertions.assertTrue(saleUpYaziElementi.isDisplayed());

        //5- Fashion bolumundeki ilk urune tıklayın
        //   fashion bolumu ayrı bir iframe içersinde oldugundan once o iframe'e gecis yapmalıyız

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        // artık ilk urun ısmınde "Men Slim Fit" gevtiğini test edin
        WebElement fashionIlkElement = driver.findElement(By.xpath("(//*[@class='overlay'])[1]"));
        //bu xpath 3 element bulabiliyor
        //AANCAAKK bız fashion iframe içinde oldugumuzdan
        //o iframe içinde olan tek bir elementi bize getirir

        fashionIlkElement.click();

        String expectedIsimIcerik= "Men Slim Fit";
        String actualIsimIcerik =fashionIlkElement.getText();











    }
}
