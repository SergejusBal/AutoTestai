
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Automations {

    WebDriver _globalDriver;
    @BeforeMethod
    public void setupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver();
        _globalDriver.manage().window().maximize();
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


//    @AfterMethod
//    public void resetToTitle() throws InterruptedException {
//        if (_globalDriver != null) {
//            _globalDriver.quit();
//        }
//    }


    @Test
    public void dragAndDrop() throws InterruptedException {
        Thread.sleep(1000);

        //Switch to iframe here
        _globalDriver.get("https://www.way2automation.com/way2auto_jquery/draggable.php#load_box");
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        //Add frame
        _globalDriver.switchTo().frame(iframe);

        WebElement dragOne = _globalDriver.findElement(By.id("draggable"));
        Actions actions = new Actions(_globalDriver);

        actions.clickAndHold(dragOne)
                .moveByOffset(200, 600)
                .release()
                .perform();

        dragOne.getAttribute("po")



    }








}
