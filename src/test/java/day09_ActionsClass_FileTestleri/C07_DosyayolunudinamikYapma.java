package day09_ActionsClass_FileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_DosyayolunudinamikYapma {

    @Test
    public void test01(){

        // downloads klasöründe deneme.txt dosyasının var oldugunu teset edin

        String downloadsDenemeDosyaYolu = "C:\\Users\\pc2\\Downloads\\deneme.txt";

        Assertions.assertTrue( Files.exists(Paths.get(downloadsDenemeDosyaYolu)));


          /*

            /Users/ahmetbulutluoz       /Users/ahmetbulutluoz        /Downloads/deneme.txt
            \\Users\\Cansu              C:\Users\Cansu               \\Downloads\\deneme.txt
            C:\\Users\\Hamza            C:\Users\Hamza               \\Downloads\\deneme.txt
            C:\\Users\\coban            C:\Users\coban               \\Downloads\\deneme.txt
            C:\\Users\\GS               C:\Users\GS                  \\Downloads\\deneme.txt

         */

        String dinamikAnaDosyaYolu = System.getProperty("user.home");
        System.out.println(dinamikAnaDosyaYolu); // C:\Users\pc2

        // downloads klasöründe deneme.txt dosyasının var oldugunu teset edin

         /*
            eger dosya yolunu normal olarak yazarsak
            /Users/ahmetbulutluoz/Downloads/deneme.txt
            sadece dosya yolunu olusturan kisinin bilgisayarinda calisir
            baska bilgisayarlarda calismaz

            Java ortak calisabilmemiz icin
            her kisinin bilgisayarinda farkli olan bastaki kismi
            alabilecegimiz bir kod hazirlamistir

            herkeste farkli olan kisim  :  /Users/ahmetbulutluoz
            herkeste ortak olan kisim   :  /Downloads/deneme.txt


         */

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\deneme.txt";
        Assertions.assertTrue( Files.exists(Paths.get(dinamikDosyaYolu)));


        //day09 package'i altında deneme.txt dosyasının
        //var oldugunu test edin


        String denemeDosyaYolu ="src/test/java/day09_ActionsClass_FileTestleri/deneme.txt";
        System.out.println(  Files.exists(Paths.get(denemeDosyaYolu))  ); // true


        /*
                C:\Users\pc2\IdeaProjects\Team148_JUnit\src\test\java\day09_ActionsClass_FileTestleri\deneme.txt


         */

        System.out.println(System.getProperty("user.dir"));
        // herkeste farkli olan kısım :  C:\Users\pc2\IdeaProjects\Team148_JUnit
        // herkeste ayni olan kısım   :  \src\test\java\day09_ActionsClass_FileTestleri\deneme.txt


        String dinamikProjeDosyaYolu = System.getProperty("user.dir");
        dinamikDosyaYolu= dinamikProjeDosyaYolu + "\\src\\test\\java\\day09_ActionsClass_FileTestleri\\deneme.txt";
        Assertions.assertTrue( Files.exists(Paths.get(dinamikDosyaYolu)));






    }
}
