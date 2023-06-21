package techproed.day07_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        pause(2);

        // arama motoruna 'Oppo' yazıp aratın
        xpath("//*[@id='searchData']").sendKeys("Oppo", Keys.ENTER);
        pause(2);

        // ilk ürüne tıklayın
        xpath("(//*[@class='imgHolder  cargoCampaign '])[1]").click();
        pause(2);

        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertTrue(driver.getTitle().contains("Türkiye") );
        pause(2);

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        System.out.println(driver.getTitle());
        pause(2);
    }
}
