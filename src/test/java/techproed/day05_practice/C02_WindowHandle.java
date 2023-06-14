package techproed.day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C02_WindowHandle extends TestBase {
    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        pause(2);

        // 2- url'in 'amazon' icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        String amazonHandle = driver.getWindowHandle();
        pause(2);

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        String bestbuyHandle = driver.getWindowHandle();
        pause(2);

        // 4- title'in 'Best Buy' icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        pause(2);

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);
        pause(2);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='search']//div)[1]")).getText().contains("java"));
        pause(2);

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestbuyHandle);
        pause(2);

        // 8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//img)[1]")).isDisplayed());
        pause(2);
    }
}
