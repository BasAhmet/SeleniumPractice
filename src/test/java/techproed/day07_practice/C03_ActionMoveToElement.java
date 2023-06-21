package techproed.day07_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C03_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        actions.moveToElement(xpath("//*[@id='icp-nav-flyout']//div")).perform();
        pause(2);

        // Change country/region butonuna basiniz
        xpath("(//*[@id='icp-flyout-mkt-change']//div)[1]").click();
        pause(2);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        Select select = new Select(xpath("(//*[@id='icp-dropdown'])[1]"));
        select.selectByVisibleText("Turkey (Türkiye)");
        pause(1);

        actions.sendKeys(Keys.ENTER).perform();
        //xpath("(//*[@class='a-text-bold'])[3]").click();

        pause(2);

        // Go to website butonuna tiklayiniz
        xpath("//*[@id='icp-save-button']//input").click();
        pause(2);

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));
    }
}
