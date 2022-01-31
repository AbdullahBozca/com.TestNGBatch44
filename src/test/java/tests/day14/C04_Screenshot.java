package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {
    @Test
    public void screenshot() throws InterruptedException {
        driver.get("https://www.google.com");
        //tüm sayfanın screenshot ını almak için
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File tumSayfaScreenshot=new File("src\\tumSayfa.png");
        tumSayfaScreenshot=screenshot.getScreenshotAs(OutputType.FILE);
        WebElement logoElement=driver.findElement(By.xpath("(//img[@alt='Google'])[1]"));
        File logo=new File("src\\logo.png");
        logo=screenshot.getScreenshotAs(OutputType.FILE);
    }
}
