package day08_windowSwitch_ActionClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestbaseEach;

import java.util.Set;

public class C02_KontrolsuzAcilanWindow extends TestbaseEach {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement yaziElementi =driver.findElement(By.tagName("h3"));

        String expectedYazi = "Opening a new window";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle ="The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);
        ReusableMethods.bekle(2);

        String ilkWindowWhd = driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();
        ReusableMethods.bekle(5);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        System.out.println("Click here'a bastiktan sonra title :" + driver.getTitle() );
         /*
            driver.getWindowHandle();
            methodu içerisinde oldugu window'un window handle degerini bize getirir
            ve biz de kaydedebilirz

            bir window'un whd'iri kaydettikten sonra
            nerede olursak olalım
            driver.switchTo().window(hedefWindowWHDi); ile bu window'a geciş yapabiliriz

            Kontolsuz window acıldıgında
            driver beklemedigi bir durum oldugundan
            yeni window'a gecmez, eski window'da kalır

            yeni window'a gecemediğimiz için
            yeni window'un whd'ini alamayız

          */

        Set<String> tumWhdSeti = driver.getWindowHandles();
        System.out.println("ILk window Handle degeri :" + ilkWindowWhd);
        System.out.println("Tum Window Handle Degeri Seti : " + tumWhdSeti);

        String ikinciWindowWhd="";

        for(String each : tumWhdSeti) {
          if(! each.equals(ilkWindowWhd))  {
              ikinciWindowWhd= each;
          }
        }

        driver.switchTo().window(ikinciWindowWhd);
        System.out.println("Bulmaca cozdukten sonra title :" + driver.getTitle() );


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        yaziElementi= driver.findElement(By.tagName("h3"));
        expectedYazi = "New Window";
        actualYazi =yaziElementi.getText();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu test edin

        driver.switchTo().window(ilkWindowWhd);
        expectedTitle= "The Internet";
        actualTitle =driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);



    }
}
