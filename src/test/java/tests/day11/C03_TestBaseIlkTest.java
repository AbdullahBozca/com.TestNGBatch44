package tests.day11;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseIlkTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");
        Thread.sleep(5000);
    }
}
