package techproed.day10_practice;

import org.junit.Test;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_WebTables extends TestBase {
    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        xpath("//*[@id='details-button']").click();
        xpath("//*[@id='proceed-link']").click();
        xpath("//*[@id='navLogon']/a").click();
        xpath("//*[@id='UserName']").sendKeys("manager", Keys.TAB,"Manager1!",Keys.ENTER);
    }
    @Test
    public void test01() {
        // input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i dinamik olarak yazdırın.
        girisYap();
        int satir = 7;
        int sutun = 4;
        System.out.println(xpath("//tbody/tr[" + satir + "]/td[" + sutun + "]").getText());
    }
}
