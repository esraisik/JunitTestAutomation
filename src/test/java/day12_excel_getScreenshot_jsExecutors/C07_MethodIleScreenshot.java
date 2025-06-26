package day12_excel_getScreenshot_jsExecutors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestbaseEach;

import java.io.IOException;

public class C07_MethodIleScreenshot extends TestbaseEach {

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

        // logout butonunun fotografını cekin
        ReusableMethods.webElementScreenshotIsimli(logoutButonu,"loginTest");


        //logout butonuna basarak sistemden cıkıs yapın
        logoutButonu.click();


    }
}