package techproed.day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import javax.swing.*;

public class C01_Iframe extends TestBase {
    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");
        pause(1);

        // Videoyu görecek kadar asagiya ininiz
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        pause(1);

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0);
        xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']").click();
        pause(5);

        // videoyu durdurunuz
        WebElement playButton = xpath("//*[@class='ytp-play-button ytp-button']");
        playButton.click();
        pause(1);

        // videoyu tam ekran yapınız
        WebElement fullScreen = xpath("//*[@class='ytp-fullscreen-button ytp-button']");
        fullScreen.click();
        pause(1);

        // videoyu calıstırınız
        playButton.click();
        pause(1);

        // videoyu kucultunuz
        fullScreen.click();
        pause(1);

        // videoyu durdurunuz
        playButton.click();
        pause(1);

        // Videoyu calistirdiginizi test ediniz
        Assert.assertFalse(xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']").isDisplayed());
        pause(1);

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        Assert.assertTrue(xpath("//h1").isDisplayed());
    }
}
