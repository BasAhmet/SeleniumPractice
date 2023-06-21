package techproed.day07_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_ActionsDragAndDrop extends TestBase {
    @Test
    public void test01() {
        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");
        pause(2);

        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        WebElement dragMe = xpath("//*[@id='draggable']");
        WebElement dropHere = xpath("//*[@id='droppable']");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe,dropHere).perform();
        pause(2);

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        Assert.assertTrue(dropHere.getText().equals("Dropped!"));
    }
}
