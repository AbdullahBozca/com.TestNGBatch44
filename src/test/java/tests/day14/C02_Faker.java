package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {
    @Test
    public void facebookKayitTest() throws InterruptedException {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        driver.manage().deleteAllCookies();
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.click(isimKutusu).sendKeys(faker.name().firstName()).
        //“surname” giris kutusuna bir soyisim yazin
        //WebElement soyisim=driver.findElement(By.xpath("//input[@name='lastname']"));
        sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
        //“email” giris kutusuna bir email yazin
        sendKeys(Keys.TAB).sendKeys(email).
        //“email” onay kutusuna emaili tekrar yazin
        sendKeys(Keys.TAB).sendKeys(email).
        //Bir sifre girin
        sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
        //Tarih icin gun secin
                sendKeys("1").sendKeys(Keys.TAB).
                sendKeys("Ağu").sendKeys(Keys.TAB).
                sendKeys("1988").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                //sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement erkek=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement kadın=driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertTrue(erkek.isSelected());
        Assert.assertFalse(kadın.isSelected());
        //Sayfayi kapatin
        Thread.sleep(5000);
    }
}
