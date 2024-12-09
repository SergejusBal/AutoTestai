import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class VinotekaTests {


    WebDriver _globalDriver;

    @BeforeMethod
    public void SetupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://vynoteka.lt/");
        _globalDriver.manage().window().maximize();
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement sutikimas = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));
        sutikimas.click();
        checkAndClickPopUp();
        checkAndClickSlapukai();

    }

    @AfterMethod
    public void ResetToTitle() throws InterruptedException {
        if (_globalDriver != null) {
            _globalDriver.quit();
        }
    }

    @Test(priority = 1)
    public void registration() throws InterruptedException {
        Thread.sleep(5000);
        String name = "John103";
        //Go to registration panel
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[1]/div/button")).click();
        //Fill registration fields
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[1]/div/div[1]/input")).sendKeys(name);
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[2]/div/div/input")).sendKeys("Tom");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[4]/div/div[1]/input")).sendKeys(name +".TOm@gmail.com");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[5]/div/div[1]/input")).sendKeys("65684411" );
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[6]/div/div/input")).sendKeys("Test123456");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[7]/div/div/input")).sendKeys("Test123456");
        //Set imput parameters in "Gimimo metai"
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[1]/button/span[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[2]/div/div/button[18]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[1]/button/span[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[2]/div/div/button[10]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[1]/button/span[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[2]/div/div/button[7]")).click();
        //Mark "terms and services"
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[8]/div[1]/div/label/span")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[8]/div[2]/div/label/span")).click();
        //Click "REGISTRUOTIS"
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/button")).click();
        //After 30 s click skip
        Thread.sleep(35000);
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/button")).click();

        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/a")).click();

        String result = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/span")).getText();
        Assert.assertTrue(result.contains(name));

    }
    @Test(priority = 2)
    public void loginTest() throws InterruptedException {
        Thread.sleep(5000);
        String name = "John103";
        // Go to login panel
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button")).click();
        //Fill login fields
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/form/div[1]/div/input")).sendKeys(name +".TOm@gmail.com");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/form/div[2]/div/input")).sendKeys("Test123456");
        //Set stay connected for 7 days
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/form/div[3]/label")).click();
        //click prisijungti
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/form/div[4]/button")).click();
        //Go to user panel
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/a")).click();

        String result = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/span")).getText();
        Assert.assertTrue(result.contains(name));

    }

    @Test
    public void testAddToBasket() throws InterruptedException {
        Thread.sleep(5000);
//        Select Wine
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[1]/div/div[1]/div/nav/div[1]/div/button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[1]/div/div[1]/div/nav/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div/nav/div[1]")).click();
//        Add two wine products to basket
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div/div[1]/div[4]/div[1]/div/div/div[3]/div[2]/div[2]/button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div/div[1]/div[4]/div[2]/div/div/div[3]/div[2]/div[2]/button")).click();
//        Go to wine basket
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/div[4]/nav/div[2]/button")).click();
//        Get basket
        String firstItem = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/div[4]/nav/div[2]/div/div/div[2]/div[1]/div/div[1]/a")).getText();
        String secondItem = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/div[4]/nav/div[2]/div/div/div[2]/div[2]/div/div[1]/a")).getText();

        System.out.println(firstItem);
        System.out.println(secondItem);

        Assert.assertTrue(firstItem.contains("Marina Alta"));
        Assert.assertTrue(secondItem.contains("Masso Antico"));

    }

    @Test
    public void seachBarTest() throws InterruptedException {
        Thread.sleep(5000);
        // Enter "Jeeper" ir search panel
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[1]/div/input")).sendKeys("Jeeper");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[1]/button")).click();
//        Select Second product
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div/div[1]/div[4]/div[2]/div/div/div[2]/a")).click();
//        go to product page
        String result = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/section[1]/div/div/div/div/div/div[2]/div[1]/h3")).getText();

        Assert.assertTrue(result.contains("Rinkinys "));

    }

    @Test
    public void testNewProduct() throws InterruptedException {
        Thread.sleep(2000);
        // go to new products
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[1]/div/div[2]/div/nav/div[2]/div/button")).click();
        // click new wines
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[1]/div/div[2]/div/nav/div[2]/div/div/div/div/div[1]/div/div/div/div/nav/div[2]/a")).click();
        //Select wine tape
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div[1]/div/span[1]/button")).click();
        // Select "ramus"
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div[1]/div/span[2]/div/div[1]/div/div[1]/label/span/span")).click();
        // select first
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div/div[1]/div[4]/div[1]/div/div/div[2]/a/span")).click();
        //
        String result = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/section[1]/div/div/div/div/div/div[2]/div[1]/h3")).getText();

        Assert.assertTrue(result.contains("Rinkinys "));

    }

    private void checkAndClickPopUp(){
        WebDriverWait wait = new WebDriverWait(_globalDriver,Duration.ofSeconds(100));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                WebElement element = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.id("omnisend-form-63ff1f31b40d6530aba59a6d-form-close-icon"))
                );
                element.click();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    private void checkAndClickSlapukai(){
        WebDriverWait wait = new WebDriverWait(_globalDriver,Duration.ofSeconds(100));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                WebElement element = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/a[2]"))
                );
               element.click();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }




}
