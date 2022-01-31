package tests.day14;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    @Test
    public void cookiesAutomation() {
        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        //cookiesSet.stream().forEach(t-> System.out.println("cookie : "+t.toString()));
        int i=1;
        for (Cookie each :cookiesSet) {
            System.out.println(i+". cookie : "+ each);
            i++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSet.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Cookie cookiei18n=driver.manage().getCookieNamed("18n-prefs");
        System.out.println("18n-prefs değeri : "+cookiei18n);
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"))  ;
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie myCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(myCookie);
        cookiesSet=driver.manage().getCookies();
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        cookiesSet.stream().forEach(t-> System.out.println("cookie : "+t.toString()));
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookiesSet=driver.manage().getCookies();
        cookiesSet.stream().forEach(t-> System.out.println("cookie : "+t.toString()));
        Assert.assertFalse(cookiesSet.contains(driver.manage().getCookieNamed("skin")));
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.size()==0);
        //Collapse
    }
}
