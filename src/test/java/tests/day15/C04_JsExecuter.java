package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuter extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        //driver.manage().deleteAllCookies();
        //1. adım jsExecuter objesi oluşturulup driver cast edilir
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        //2. adım ilgili web elementi locate edilir
        WebElement sellElement=driver.findElement(By.xpath("//a[normalize-space()='Sell']"));
        //3. adım: ilgili script ve argüment ile executeScript methodu çalıştırılır
        jse.executeScript("arguments[0].click();",sellElement);
        Thread.sleep(3000);
    }
}
