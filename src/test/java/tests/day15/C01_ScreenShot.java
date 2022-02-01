package tests.day15;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;

public class C01_ScreenShot extends TestBase{
    @Test
    public void nutellaTesti() throws IOException {
        driver.get("https://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='sg-col-inner']")).getText().contains("nutella"));
//lets take ss of whole page
        TakesScreenshot takenScreenshot = (TakesScreenshot) driver;
        File WholePage = new File("target/screenShot/wholePage.png");
        File geciciResim = takenScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,WholePage);

    }
}
