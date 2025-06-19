package day12_excel_getScreenshot_jsExecutors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void writeExcelTesti () throws IOException {


        //3) Adimlari takip ederek Sayfa1’deki1.satira kadar gidelim
        String dosyaYolu="src/test/java/day11_webtable_exelOtomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //4) 1.satır 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue(1500000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(250000);

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue(54000);

        //bos olan ilk satıra
        //ingilizce ulke ismi JavaRepublic ingilizce baskent olarak Selenium yazdıralım

        int ilkBosSatirIndexi = sayfa1.getLastRowNum()+1;

        sayfa1.createRow(ilkBosSatirIndexi);
        sayfa1.getRow(ilkBosSatirIndexi).createCell(0).setCellValue("JavaRepublic");
        sayfa1.getRow(ilkBosSatirIndexi).createCell(1).setCellValue("Selenium");

        //9) Dosyayi kaydedelim
        /*
            Biz yaptıgımız tum degişiklikleri
            workbook uzerınde yaptık

            workbook objesi fizi excel dosayasından
            FileInputstream ile aldıgımız bilgilerle olusturuldu
            ve excel'ın bir kopyası oldu

            eger workbook uzerinde yaptıgımız degısıklıklerı
            excel dosyasına işlemek istiyorsak
            kaydetme islemi yapmamız gerekir

            ONEMLİ NOT :
            workbook'da yaptıgımız degisiklikleri
            excel'e kaydetme islemi yapmadan once
            excel dosyasının kapalı oldugundan emın olmak zorundasınız
         */
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);

        //10)Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();


    }

}
