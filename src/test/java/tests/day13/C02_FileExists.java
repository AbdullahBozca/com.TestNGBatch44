package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));
        String path = System.getProperty("user.home")+"\\Desktop\\Deneme";
        System.out.println(path);
        System.out.println("user.dir : "+System.getProperty("user.dir"));
        //masaüstünde deneme klasöründe not_defteri.txt dosyası var mı test et
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Deneme\\not_defteri.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        //projemizde pom.xml olduğunu test edin
        //C:\Users\Bozca\IdeaProjects\com.TestNgBatch44\pom.xml
        String pomPath=System.getProperty("user.dir")+"\\pom.xml";
        System.out.println(Files.exists(Paths.get(pomPath)));
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));
    }
}
