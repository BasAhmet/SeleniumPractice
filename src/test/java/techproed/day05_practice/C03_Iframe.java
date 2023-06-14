package techproed.day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import javax.swing.*;

public class C03_Iframe extends TestBase {
    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id='movie_player']/div[4]/button")).click();

        // Videoyu calistirdiginizi test ediniz
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='movie_player']//a)[29]")).isDisplayed());

        // 'Powerful, but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='Powerful_but_easy_to_misuse']")).isDisplayed());

    }
}
