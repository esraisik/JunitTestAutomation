package day09_ActionsClass_FileTestleri;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestbaseEach;

public class C08_DosyaIndirmeTesti extends TestbaseEach {

    @Test
    public void test01(){

        //1. https://the-internet.herokuapp.com/download adresine gidelim.
         driver.get("https://the-internet.herokuapp.com/download");

        //2. download jpeg dosyasını indirelim
        driver.findElement(By.xpath("//*[.='wallpaperflare.com_wallpaper (25).jpg']"))
                .click();
        ReusableMethods.bekle(2);

        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim
           String dinamikDosyaYolu = System.getProperty("user.home") + "\\Download\\//*[.='wallpaperflare.com_wallpaper (25).jpg']";










    }
}
