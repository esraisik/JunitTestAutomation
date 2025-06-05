package day07_jsAllerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestbaseEach;

public class C03_BasicAuthentication extends TestbaseEach {

    @Test
    public void test01(){

        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        // Username    : membername
        //  password     : sunflower

       // driver.get("https://testotomasyonu.com/basicauth");
        //sadece url'e gidersek UI ile kullanıcı adı ve sifre girmemiz gerekir.
        //ancak otomasyon ile gittiğimizde
        //kullanıcı adı ve sifresi bölumunu locate edemediğimizden kullanamayız
        //bunun yerine kullandığımız url'in sahibi olan sirketin
        // bize vercegi kullanıcı adı ve sifresini
        //yine sirketin bize tarif edecegi yöntemle url'e eklemeiıyız

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");


        //4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement basicAuthYaziElementi = driver.findElement(By.tagName("h1"));
        Assertions.assertTrue(basicAuthYaziElementi.isDisplayed());









    }
}
