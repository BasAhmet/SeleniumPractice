package techproed.day08_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {
    @Test
    public void test01() throws IOException {

        //Ulkeler dosyasindaki tum datalari Map'e aliniz ve yazdiriniz

        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String,String> ulkeBaskent = new TreeMap<>();
        int row = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        for (int i = 1; i < row ; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = "";
            for (int j = 1; j < 4 ; j++) {
                value = value + workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString() + "|";
            }
            ulkeBaskent.put(key,value);
        }
        System.out.println(ulkeBaskent);

    }
}
