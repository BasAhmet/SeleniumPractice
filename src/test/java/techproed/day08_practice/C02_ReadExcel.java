package techproed.day08_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız.
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        int row = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println(row);
        for (int i = 1; i < row; i++) {
            System.out.println((i) + ". Başkent : " + workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }


    }

}
