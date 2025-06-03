package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestbaseEach;

public class C05_TestBaseKullanimi extends TestbaseEach {

    /*
        Java'da OOP concept'in en büuük avantajı REUSABILITY'dir

        @BeforeEach - @AfterEach
        @BeforeAll - @AfterAll
       methodlari her class'ta aynı sekilde yeniden yazmak yerine
      baska bir class'ta olusturabilirz.

     Baska bir class'ta bulunan class uyelerine
     ulasmanın en kısa yolu inheritance'dır

     Biz de utilities altında TESTBASE class'i olusturup
     before ve afer methodlarını o class'lara koyabiliriz

     */

    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com/");
        ReusableMethods.bekle(1);
    }
}
