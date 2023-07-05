package techproed.day08_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws FileNotFoundException {
        // Ulkeler dosyasındaki 3.satırdaki indexin, 3. sutunundaki indexinin
        int satir = 3;
        int sutun = 3;

        // "Cezayir" oldugunu test eden method olusturunuz.
        String sorguVerisi = "Cezayir";
        Assert.assertEquals(getData(3, 3), sorguVerisi);

    }
    public String getData(int satir, int sutun){
        try {
            FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
            Workbook workbook = WorkbookFactory.create(fis);
            String data = workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun).toString();
            System.out.println(data);
            return data;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
