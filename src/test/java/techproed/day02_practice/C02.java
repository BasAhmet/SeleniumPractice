package techproed.day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    @Test
    public void test01() {
        // https://www.techproeducation.com/ sayfasina gidin
        driver.get("https://www.techproeducation.com/");

        // Title ve Url'ini alın ve yazdıran
        String actualTitleTech = driver.getTitle();
        System.out.println("Title : " + actualTitleTech);

        String actualUrlTech = driver.getCurrentUrl();
        System.out.println("Url : " + actualUrlTech);

        // Title'in "Techpro" kelimesini içerip içermedigini test edin
        Assert.assertTrue(actualTitleTech.contains("Techpro"));

        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(actualUrlTech.contains("techproeducation"));

        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com/");

        // Title'ini alın ve yazdırın
        String actualAmazonTitle = driver.getTitle();
        System.out.println(actualAmazonTitle);

        // Title'in "more" kelimesini içerip içermedigini test edin
        String expectedAmazonTitle = "more";
        Assert.assertTrue("Title "+ expectedAmazonTitle +" içermiyor ",actualAmazonTitle.contains(expectedAmazonTitle));

        // techproeducation.com'a geri dönün
        driver.navigate().back();

        // sayfaya yenileyin
        driver.navigate().refresh();

        //amazon.com'a tekrar gelin
        driver.navigate().forward();
    }
}
