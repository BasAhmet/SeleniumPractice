package techproed.day10_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusuna Nutella yazip aratın
        xpath("//*[@id='twotabsearchtextbox']").sendKeys("Nutella", Keys.ENTER);

        // ilk ürüne tıklayın
        xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]").click();

        // tüm sayfanın fotografını cekin
        TakesScreenshot ts = (TakesScreenshot) driver;
        File kayit = new File("src/test/java/techproed/day10_practice/tamSayfa.jpg");
        File photo = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(photo,kayit);

    }
}
