package day08_windowSwitch_ActionClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestbaseEach;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestbaseEach {

    @Test
public void test01() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
            driver.get("https://the-internet.herokuapp.com/windows");

            String ilkWindowWhd = driver.getWindowHandle();

        // sayfadaki elemental selenium linkini tiklayin

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))
                           .click();

        // acilan yeni window'a gecip

        String ikinciWindowWhd ="";

        Set<String> acikButunWindowlwrinWhd = driver.getWindowHandles();

        for( String each :acikButunWindowlwrinWhd) {
            if (! each.equals(ilkWindowWhd)) {
                ikinciWindowWhd=each;
            }
        }
        driver.switchTo().window(ikinciWindowWhd);

        // buyuk basligin "Elemental Selenium" oldugunu test edin

        String expectedYazi ="Elemental Selenium";
        String  actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);



    }



}
