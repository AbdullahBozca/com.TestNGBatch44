package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Scanner;

public class C01_MouseKullanimi extends TestBase {
    @Test
    public void amazonList() throws InterruptedException {
        //amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        //hello sign in elementinin üzerinde mouse bekletin
        Actions actions=new Actions(driver);
        WebElement account = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(account).perform();
        Thread.sleep(5000);
        //açılan menude new list linkine tıklayın
        WebElement listElement=driver.findElement(By.xpath("//span[normalize-space()='Create a List']"));
        actions.click(listElement).perform();
        Thread.sleep(5000);
        // new list sayfasının açıldığını test edin
        //System.out.println(driver.findElement(By.xpath("//span[normalize-space()='Your Lists']")).getText());
        Assert.assertTrue(driver.getTitle().contains("Your List"));
    }


}
