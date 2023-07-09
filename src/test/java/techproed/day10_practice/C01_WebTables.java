package techproed.day10_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        xpath("//*[@id='details-button']").click();
        xpath("//*[@id='proceed-link']").click();
        xpath("//*[@id='navLogon']/a").click();
        xpath("//*[@id='UserName']").sendKeys("manager", Keys.TAB,"Manager1!",Keys.ENTER);
    }

    @Test
    public void test01() {
        // Email baslıgındaki tüm elementleri(sutun) yazdırın.
        girisYap();
        int body = driver.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 1; i < body+1; i++) {
            System.out.println(xpath("//tbody/tr[" + i + "]/td[3]").getText());
        }
    }
}
