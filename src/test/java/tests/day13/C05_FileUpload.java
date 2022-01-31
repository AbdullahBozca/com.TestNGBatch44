package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement fileSecButon=driver.findElement(By.id("file-upload"));
        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Deneme\\not_defteri.txt";
        //sendKeys() ile dinamik path i dosyaseç butonuna yollayalım
        fileSecButon.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim
        WebElement sncYazi=driver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']"));
        Assert.assertTrue(sncYazi.isDisplayed());
        Thread.sleep(8000);
    }
}
