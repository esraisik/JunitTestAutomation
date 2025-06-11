package day08_windowSwitch_ActionClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestbaseEach;

import java.util.Set;

public class C04_HedefUrlileWindowDegistirme extends TestbaseEach {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tiklayin

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))
                .click();

        // acilan yeni window'a gecip
        String hedefUrl = "https://elementalselenium/";

        // acik olan tum window'ların whd'lerini kaydedelim

        Set<String> tumWindowlarinWhd = driver.getWindowHandles();

        // bir for-each loop ile tum whd'lerini gozden gecirip
        // her windowhandle degerinin sayfasına gecelim
        // eger gectiğimiz sayfada url hedefUrl'e esit ise
        //loop'u bitirelim

        for(String eachWhd :tumWindowlarinWhd) {
            driver.switchTo().window(eachWhd);
            if (driver.getCurrentUrl().equals(hedefUrl)) {
                break;
            }
        }

        // buyuk basligin "Elemental Selenium" oldugunu test edin

        String expectedYazi ="Elemental Selenium";
        String  actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);



        ReusableMethods.bekle(3);





    }
}
