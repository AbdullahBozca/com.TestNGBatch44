package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_senkronizasyon extends TestBase {
    @Test
    public void test() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    driver.findElement(By.xpath("//button[text()='Enable']")).click();
    WebElement disableYazisi=driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
    Assert.assertTrue(disableYazisi.isDisplayed());
    }
}
