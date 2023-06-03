package techproed.day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import techproed.Utils;

import java.util.logging.SocketHandler;

public class C02 {
    public static void main(String[] args) {
        WebDriver driver = Utils.chromeDriver(15);

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);

        // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin
        driver.findElement(By.xpath("//*[@id='nav-xshop']/a[2]")).click();
        String customerTitle = driver.getTitle();
        driver.findElement(By.xpath("//*[@id='nav-xshop']/a[3]")).click();
        String registeryTitle = driver.getTitle();
        if (customerTitle.contains("Amazon")) {
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED : " + customerTitle);
        }
        if (registeryTitle.contains("Amazon")) {
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED : " + registeryTitle);
        }

        // pencereyi kapatiniz
        driver.close();
    }
}
