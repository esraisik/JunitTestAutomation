package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C01_Assertions {

    /*
        assertEquals(a,b) ile assertTrue(a==b)
        eger assertions PASSED olursa yukarıdaki method'lar arasında hiç bir fark yoktur

        ANNCAAAKKK aseertions FAILED oldugunda
        assertEquals(a,b) expected (a) ve actual (b) degerlerini karşılastırıp
        aradaki farkı bize gösterir.

        ama assertTrue(a==b) kullanıldıgında
        sadece true bekliyorduk false oldu der

        Bu sebeple MUMKUN OLDUGUNCA assertEquals() kullanmayı tercıh ederiz



     */

    int a = 10;
    int b = 20;
    int c = 30;
    String url1 = "www.testotomasyonu.com";
    String url2 = "www.testotomasyonu.com/";

    @Test
    public  void test01(){
        // c'nin a ile b'nin toplamina esit oldugunu test edin

        Assertions.assertNotEquals(c,b);
        Assertions.assertTrue(c==a+b);
    }


    @Test
    public  void test02(){
        // b'nin a ile c'nin toplamina esit oldugunu test edin

        Assertions.assertEquals(b,a+c);
        //Expected :20
        //Actual   :40

    }


    @Test
    public  void test03(){
        // b'nin a ile c'nin toplamina esit oldugunu test edin

        Assertions.assertTrue(b==a+c);
        //Expected :true
        //Actual   :false
    }

    @Test
    public void test04(){
        // url1 ile url2'nin ayni oldugunu test edin
        Assertions.assertEquals(url1,url2);
        //Expected :https://www.testotomasyonu.com
        //Actual   :https://www.testotomasyonu.com/
    }

    @Test
    public void test05(){
        // url1 ile url2'nin ayni oldugunu test edin
        Assertions.assertTrue(url1.equals(url2));


    }

    @Test
    public void test06(){
        //url1'in "best" kelimesi icermedigini test edin

//        if ( ! url1.contains("best") ){
//            System.out.println("Best testi PASSED");
//        }else  System.out.println("Best testi FAILED");

        Assertions.assertFalse( url1.contains("best")  );

        Assertions.assertTrue( !url1.contains("best") );
        //'assertTrue()' can be simplified to 'assertFalse()'
    }
}
