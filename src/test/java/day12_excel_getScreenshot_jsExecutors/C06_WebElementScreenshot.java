package day12_excel_getScreenshot_jsExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestbaseEach;

import java.io.File;
import java.io.IOException;

public class C06_WebElementScreenshot extends TestbaseEach {

    @Test
    public void test01() throws IOException {

        // Testotomasyonu sayfasına gidelim
        driver.get("https:/www.testotomasyonu.com/");

        //Account linkine tıklayalım
       driver.findElement(By.xpath("//span[.='Account']"))
               .click();

        //kullanıcı adı olarak wise@gmail.com girin
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys("wise@gmail.com");

        // password olarak 123456 girin
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys("123456");

        // sign in butonuna basark sisteme giriş yapın
        driver.findElement(By.id("submitlogin"))
                .click();

        // giriş yapılabildiğini test etmek için
        //Logout butonunun görunur oldugunu test edin
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));
        Assertions.assertTrue(logoutButonu.isDisplayed());



        // Logout butonunun fotografını cekin

        //1. screenshot alacagımız webelementi locate edip kaydedelim
        //   bız yukarda logout butonunu locaate ettık


        // 2. adim resmi kaydedecegimiz File'ı olusturalım
        File asilResim =new File("target/screenshots/webElementScreenshot.jpeg");

        //3.adim webElementi kullanarak screenshot'i alip gecici i dosya olarak kaydedelim
        File geciciDosya =logoutButonu.getScreenshotAs(OutputType.FILE);

        // 4. adim gecici dosyayı asıl dosyaya kopyalayalım

        FileUtils.copyFile(geciciDosya,asilResim);

        //logout butonuna basarak sistemden cıkıs yapın
        logoutButonu.click();





    }
}
