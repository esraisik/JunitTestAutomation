package day09_ActionsClass_FileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistTesti {

    @Test
    public void tese01(){

        //day09 package'i altında deneme.txt dosyasının
        //var oldugunu test edin

          /*
            Selenium'da tum islerimizi WebDriver ile yapiyoruz
            Olusturdugumuz driver objesi bizim adimiza
            istedigimiz tum islemleri yapiyor

            ANNNNCAAAAK WebDriver adindan da anlasilacagi gibi
            Web'de kullanilabilir, bilgisayarimizdaki fiziki dosyalara erisemez

            Bilgisayarimizdaki dosyalara erismek icin Java'dan yardim aliriz
            Java ile dosyaya ulasabilmemiz icin ise
            dosyanin dosyayolunu bilmeliyiz
         */

        String denemeDosyaYolu ="src/test/java/day09_ActionsClass_FileTestleri/deneme.txt";
        System.out.println(  Files.exists(Paths.get(denemeDosyaYolu))  ); // true


        String yanlisDosyaYolu ="src/test/java/day09_ActionsClass_FileTestleri/deneme1.txt";
        System.out.println(Files.exists(Paths.get(yanlisDosyaYolu))); // false


        Assertions.assertTrue(  Files.exists(Paths.get(denemeDosyaYolu))); //PASSED

        //day09 package'i altında deneme1.txt dosyasının
        //var olmadigini test edin

        Assertions.assertFalse( Files.exists(Paths.get(yanlisDosyaYolu)));  // PASSED

        // downloads klasöründe deneme.txt dosyasının var oldugunu teset edin

        String downloadsDenemeDosyaYolu = "C:\\Users\\pc2\\Downloads\\deneme.txt";

        Assertions.assertTrue( Files.exists(Paths.get(downloadsDenemeDosyaYolu)));







    }



}
