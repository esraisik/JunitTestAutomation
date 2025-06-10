package day08_windowSwitch_ActionClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestbaseEach;

public class C01_KontrolluWindowDegistirme extends TestbaseEach {

    @Test
    public void test01 (){

            /*

            Eger bize verilen gorevde
            yeni bir Tab veya yeni bir Window acilmasi isteniyorsa
            driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.WINDOW);
            ile yeni bir Tab veya Window acip, driver'i yeni window'a otomatik olarak gecirebiliriz

            Eger testimiz sirasinda birden fazla window aciliyorsa
            driver'i istedigimiz window'a gecirmek icin
            hedef window'un WindowHandle degerini girmeliyiz
            driver.switchTo().window(wisequarterWhd);

            Eger birden fazla window aciyorsak ve geri donmemiz gerekecekse
            acilan her window'un window handle degerini kaydetmek
            faydali olacaktir.

         */



        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com/");


        // whd'ini kaydedin ve yazdirin
        String testOtomasyonuwhd = driver.getWindowHandle();
        System.out.println("test otomasyonu whd :" + testOtomasyonuwhd);

        // yeni bir tab acip, yeni tab'da wisequarter sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");


        // whd'ini kaydedin ve yazdirin
        String wisequarteruwhd = driver.getWindowHandle();
        System.out.println("wisequarter whd :" + wisequarteruwhd);


        // yeni bir window acarak, arabam.com sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.arabam.com");


        // whd'ini kaydedin ve yazdirin
        String arabamcomwhd = driver.getWindowHandle();
        System.out.println("arabamcom whd :" + arabamcomwhd);

        // wisequarter'in acik oldugu window'a donun
        // ve url'in wisequarter icerdigini test edin

        driver.switchTo().window(wisequarteruwhd);
        String expectedUrlIcerik= "wisequarter";
        String actualUrlIcerik = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);

        // testotomasyonu'nun acik oldugu window'a donun
        // ve url'in testotomasyonu icerdigini test edin

        driver.switchTo().window(testOtomasyonuwhd);

        expectedUrlIcerik= "testotomasyonu";
        actualUrlIcerik = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);




    }
}




