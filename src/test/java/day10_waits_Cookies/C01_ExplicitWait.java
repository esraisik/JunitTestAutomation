package day10_waits_Cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ExplicitWait {

    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

    WebDriver driver;

    @Test
    public void implicitlyWaitTesti (){
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tıklayın
        WebElement enableButonu = driver.findElement(By.xpath("(//button[@type='button'])[2]"));

        enableButonu.click();
        // ve textbox etkin oluncaya kadar bekleyin
        //testimiz implicitlyWaitTest oldugu için
        // implicitly wait'in yeterli olup olmadıgını anlamak için
        // ekstra bekleme koymadık

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        ReusableMethods.bekle(5);
        Assertions.assertTrue(textBox.isEnabled());
        /*
            implicitlyWait() iki durumda bekleme yapar
            1- sayfanın yuklenmesi
            2-bir webelementin locate edilmesi için

            görevin 4.maddesinde textbox'ın etkin olmasını beklememiz gerekiyor
            ancak bu bekleme implicitlyWait()'in görev kapsamında yok
            bu sebeple implicitlyWait() ile yaptıgımızda
            4. görev faıled olacaktır

            Tesitin passed olması için mutlaka ekstra bekleme gerekir

            AANCCAAKK
            5. görevde görunmeyen elementin görunur olmasını
            ve locate edilmesini implicitlyWait() bekler

            yaniii
            özetle implicitlyWait() 4. görevi gerceklestirmemizi saglayamazken
            5. görev için yeterli olur.

            4. görevin gerceklesmessi için t,Thread.sleep() kullandık

         */

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        ReusableMethods.bekle(1);
        driver.quit();

    }

    @Test
    public void explicitWaitTesti(){

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tıklayın
        WebElement enableButonu = driver.findElement(By.xpath("(//button[@type='button'])[2]"));

        enableButonu.click();
        // ve textbox etkin oluncaya kadar bekleyin
        //explicitlyWait ile bekleyelim

            //1.adim bir wait objesi olustur
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));

            //2. adim MUMKUNSE beklenecek objeyi locate edip bir web elemen olarak kaydedi
            //        textbox'i locate edebiliyoruz ve yukarıda locate edip kaydettik

            // 3.adim wait objesine neyi bekleyecegını söyleyin
        wait.until(ExpectedConditions.elementToBeClickable(textBox));


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue(textBox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());




        ReusableMethods.bekle(1);
        driver.quit();
    }


}
