package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C02_MouseAction01 extends TestBase {
    //1- Yeni bir class olusturalim: MouseActions1
    @Test
    public void mouseActions() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlanElement=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlanElement).perform();
        //4- Alert’te cikan yazinin “You selected a context menu”

        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(actualYazi,expectedYazi);
        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        String ilkSayfaHandle= driver.getWindowHandle();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String acilanSayfadaHandle= "";
        Set<String> handleSeti=driver.getWindowHandles();
        for (String each: handleSeti
             ) {
            if (!each.equals(ilkSayfaHandle))
                acilanSayfadaHandle=each;
        }
        driver.switchTo().window(acilanSayfadaHandle);
        WebElement acilanSayfaElement= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(acilanSayfaElement.getText(),"Elemental Selenium");


    }

}
