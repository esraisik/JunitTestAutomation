package day09_ActionsClass_FileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestbaseEach;

public class C02_FormDoldurma extends TestbaseEach {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']"))
                .click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim
        /*
            Formdaki tum kutuları tek tek locate etmek yerine
            Firstname kutusuna click yapıp isim gönderelim
            sonraki kutulara gecisi de TAB tusu ile yapabiliriz

         */

        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);

        actions.click(firstNameKutusu)
                .sendKeys("Cansu")
                .sendKeys(Keys.TAB)
                .sendKeys("Altinsoy")
                .sendKeys(Keys.TAB)
                .sendKeys("cansualtinsoy@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        //ve Sign Up butonuna basalim
        driver.findElement(By.id("btn-submit-form")).click();



        //5- Kaydin olusturuldugunu test edin

        //Kayıt yapinca bizi otomatık olarak giriş sayfasına yonlendiriyor
        //kaydın olustugunu test edebilmek için
        // giris yapalım

        WebElement emailKutusu =driver.findElement(By.id("email"));
        WebElement paasswordKutusu =driver.findElement(By.id("password"));
        WebElement submitButonu =driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("cansualtinsoy@gmail.com");
        paasswordKutusu.sendKeys("12345");
        submitButonu.click();

        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        logoutButonu.click();
        ReusableMethods.bekle(3);










    }
}
