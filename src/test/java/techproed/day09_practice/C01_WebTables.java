package techproed.day09_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.Collections;
import java.util.List;

public class C01_WebTables extends TestBase {
    @Test
    public void test01() {
        // girisYap methodu olusturun
                // https://www.hotelmycamp.com adresine gidin
                // Log in butonuna tıklayın
                // Username: manager
                // Password: Manager1!
        girisYap();

        // sutun sayısını yazdırın
        int sutun = driver.findElements(By.xpath("//thead//th")).size();
        System.out.println("Sütun Sayısı : " + sutun);
        System.out.println("*********************");

        // tum body'i yazdirin
        System.out.println(driver.findElement(By.xpath("//tbody")).getText());
        System.out.println("*********************");

        // body'de bulunan satır sayısını yazdırın
        List<WebElement> body = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Satır Sayısı : " + body.size());
        System.out.println("*********************");

        // body'de bulunan satırları yazdırın
        for (WebElement w : body) {
            System.out.println(w.getText());
        }
        System.out.println("*********************");

        // 4.satırdaki elementleri yazdırın
        List<WebElement> satir4 = driver.findElements(By.xpath("//tbody/tr[4]/td"));
        for (WebElement w : satir4) {
            System.out.println(w.getText());
        }
    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        xpath("//*[@id='details-button']").click();
        xpath("//*[@id='proceed-link']").click();
        xpath("//*[@id='navLogon']/a").click();
        xpath("//*[@id='UserName']").sendKeys("manager", Keys.TAB,"Manager1!",Keys.ENTER);
    }
}
