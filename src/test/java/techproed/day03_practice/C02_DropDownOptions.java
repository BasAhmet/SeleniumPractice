package techproed.day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_DropDownOptions {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        System.out.println(select.getFirstSelectedOption().getText());

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        Assert.assertTrue(select.getOptions().size()==28);

        // dropdown'daki optionların tamamını yazdırın
        select.getOptions().forEach(w-> System.out.println(w.getText()));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
