import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Autotests {
    WebDriver _globalDriver;

    @BeforeTest
    public void SetupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://elenta.lt/");
        _globalDriver.manage().window().maximize();
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement sutikimas = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]"));
        sutikimas.click();

    }
    @AfterTest
    public void ResetToTitle() throws InterruptedException {
        _globalDriver.get("https://elenta.lt/");
    }

    @Test
    public void testTC0101() throws InterruptedException {
        Thread.sleep(3000);
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[1]/input")).sendKeys("intel");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[2]/input")).click();
        int count = Integer.parseInt(_globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/span")).getText());
        Assert.assertNotEquals(count,0);
    }

    @Test
    public void testCategoryItemClick() throws InterruptedException {
        Thread.sleep(3000);
        WebElement automobiliuKategorijas = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/a[2]"));
        automobiliuKategorijas.click();
        WebElement kiekioLaikiklis = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]/span"));
        int count = Integer.parseInt(kiekioLaikiklis.getText());
        Assert.assertNotEquals(count, 0);
    }


    @Test
    public void firstProblem() throws InterruptedException {
        Thread.sleep(3000);
        WebElement automobiliuKategorijas = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/a[2]"));
        automobiliuKategorijas.click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr/td[1]/input")).sendKeys("peugeot");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr/td[2]/input")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div[1]/h3/a")).click();
        String category = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/span[2]/a/span")).getText();
        Assert.assertTrue(category.contains("moto"));
        String modelis = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/h1/a")).getText();
        Assert.assertTrue(modelis.toLowerCase().contains("peugeot"));
    }

    @Test
    public void secondProblemIsimintinasSkelbimas() throws InterruptedException {
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/a[6]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/ul/li[2]/div[1]/h3/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div[2]/div/div[1]")).click();
        Thread.sleep(5000);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/span[3]/a/span")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/ul/li[5]/div[1]/h3/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div[2]/div/div[3]")).click();
        Thread.sleep(5000);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/a[2]")).click();
        String first = _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div[1]/h3/a")).getText();
        String second = _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[2]/div[1]/h3/a")).getText();
        Assert.assertEquals(first,"Traktorinių variklių purkštuvai");
        Assert.assertEquals(second,"8659-36773, EKSKAVATORIAUS NUOMA, VILNIUS, KAINA 50 EUR");
    }
    @Test
    public void thirdProblemSkelbimoIdejimas() throws InterruptedException {
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/a[1]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[6]/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/input")).sendKeys("LG GH24NSD1 Diskasukis ");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/span/textarea")).sendKeys("Pagrindiniai GH24NSD1 parametrai lietuviškai:\n" +
                "\n" +
                "Optinis įrenginys: DVD±RW\n" +
                "Palaikomos diskų rūšys: CD-R, CD-RW, DVD+R, DVD+RW, DVD-R, DVD-RW, DVD+R DL, DVD-R DL, DVD-RAM\n" +
                "Sąsaja: SATA\n" +
                "Disko įkrovimas: Dėklo (tray) mechanizmas\n" +
                "Montavimas: Horizontalus\n" +
                "Maksimalus CD įrašymo greitis: 48x\n" +
                "Maksimalus DVD įrašymo greitis: 24x\n" +
                "Matmenys:\n" +
                "Plotis: 14,6 cm\n" +
                "Aukštis: 4,13 cm\n" +
                "Gylis: 16,5 cm\n" +
                "Svoris: 700 g\n" +
                "Spalva: Juoda\n" +
                "Operacinės sistemos: Palaikoma Windows XP, Vista, 7 (32 ir 64 bitų versijos)\n" +
                "Garantija: 24 mėn.\n" +
                "Paskirtis: Stacionarūs kompiuteriai. ");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/input")).sendKeys("10");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[5]/input")).sendKeys("+37065868577");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[7]/input[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/input[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/input[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr[12]/td[2]/a")).click();
        String confirmation = _globalDriver.findElement(By.xpath("/html/body/div[1]/h4")).getText();
        Assert.assertEquals(confirmation,"SKELBIMAS RODOMAS");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li/div[3]/form[4]/input")).click();

        }


    @Test
    public void ForthProblemWithImage() throws InterruptedException {
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/a[1]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[6]/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/input")).sendKeys("LG GH24NSD1 Diskasukis ");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/span/textarea")).sendKeys("Pagrindiniai GH24NSD1 parametrai lietuviškai:\n" +
                "\n" +
                "Optinis įrenginys: DVD±RW\n" +
                "Palaikomos diskų rūšys: CD-R, CD-RW, DVD+R, DVD+RW, DVD-R, DVD-RW, DVD+R DL, DVD-R DL, DVD-RAM\n" +
                "Sąsaja: SATA\n" +
                "Disko įkrovimas: Dėklo (tray) mechanizmas\n" +
                "Montavimas: Horizontalus\n" +
                "Maksimalus CD įrašymo greitis: 48x\n" +
                "Maksimalus DVD įrašymo greitis: 24x\n" +
                "Matmenys:\n" +
                "Plotis: 14,6 cm\n" +
                "Aukštis: 4,13 cm\n" +
                "Gylis: 16,5 cm\n" +
                "Svoris: 700 g\n" +
                "Spalva: Juoda\n" +
                "Operacinės sistemos: Palaikoma Windows XP, Vista, 7 (32 ir 64 bitų versijos)\n" +
                "Garantija: 24 mėn.\n" +
                "Paskirtis: Stacionarūs kompiuteriai. ");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/input")).sendKeys("10");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[5]/input")).sendKeys("+37065868577");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[7]/input[2]")).click();
        Thread.sleep(3000);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/label/input[1]")).sendKeys("C:\\Users\\Sergejus\\Downloads\\disk.JPG");
        Thread.sleep(3000);
        String confirmationRemove = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/input[2]")).getAttribute("title");

        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/input[2]")).click();

        Assert.assertEquals(confirmationRemove,"Pašalinti nuotrauką");

        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/input[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/input[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr[12]/td[2]/a")).click();
        String confirmation = _globalDriver.findElement(By.xpath("/html/body/div[1]/h4")).getText();
        Assert.assertEquals(confirmation,"SKELBIMAS RODOMAS");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li/div[3]/form[4]/input")).click();

    }













}