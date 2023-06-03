package techproed.day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.Utils;
import org.openqa.selenium.WebDriver;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Utils.chromeDriver(15);

        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 20 giriniz ---> ikinci kutucuga 30 giriniz
        WebElement kutucuk = driver.findElement(By.xpath("//*[@id='number1']"));
        kutucuk.sendKeys("20", Keys.TAB,Keys.TAB,"30");
        Thread.sleep(2000);

        // calculate'e tıklayınız
        driver.findElement(By.xpath("//*[@id='calculate']")).click();

        // sonucu yazdırınız
        System.out.println(driver.findElement(By.xpath("//div[3]//p")).getText());
        Thread.sleep(2000);

        // sayfayi kapatiniz
        driver.close();

    }
}
