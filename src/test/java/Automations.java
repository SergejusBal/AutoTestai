
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        // Move element
        WebElement dragOne = _globalDriver.findElement(By.id("draggable"));
        Actions actions = new Actions(_globalDriver);

        Point beforeMove = dragOne.getLocation();

        actions.clickAndHold(dragOne).moveByOffset(400, 600).release().perform();

        Point afterMove = dragOne.getLocation();

        Assert.assertEquals(beforeMove.getX() + 400, afterMove.getX());
        Assert.assertEquals(beforeMove.getY() + 600, afterMove.getY());

    }

    @Test
    public void constrainMovement() throws InterruptedException {
        Thread.sleep(2000);
        _globalDriver.get("https://www.way2automation.com/way2auto_jquery/draggable.php#load_box");
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        //  Switch to iframe here
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        //Add frame
        _globalDriver.switchTo().frame(iframe);
        Actions actions = new Actions(_globalDriver);

        //Vertical drag
        WebElement dragVertically = _globalDriver.findElement(By.xpath("/html/body/div[1]"));
        Point beforeMove = dragVertically.getLocation();
        actions.clickAndHold(dragVertically).moveByOffset(100, 100).release().perform();
        Point afterMove = dragVertically.getLocation();

        Assert.assertNotEquals(beforeMove.getX() + 100, afterMove.getX());

        //Horizontal drag
        WebElement dragHorizontally = _globalDriver.findElement(By.xpath("/html/body/div[2]"));
        beforeMove = dragHorizontally.getLocation();
        actions.clickAndHold(dragHorizontally).moveByOffset(100, 100).release().perform();
        afterMove = dragHorizontally.getLocation();

        Assert.assertNotEquals(beforeMove.getY() + 100, afterMove.getY());

        //Move out of the box drag
        WebElement moveOutOfTheBox = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[1]"));
        boolean testFlag = false;
        try {
            actions.clickAndHold(moveOutOfTheBox).moveByOffset(1000, 1000).release().perform();
        }catch (Exception e){
            testFlag = true;
        }
        Assert.assertTrue(testFlag);
        actions.release();
        //Move out of the box drag
        WebElement moveOutOfTheSmallBox = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/p"));
        testFlag = false;
        try {
            actions.clickAndHold(moveOutOfTheSmallBox).moveByOffset(1000, 1000).release().perform();
        }catch (Exception e){
            testFlag = true;
        }
        Assert.assertTrue(testFlag);
        actions.release();

    }

    @Test
    public void dragAndDropToBox() throws InterruptedException {
        Thread.sleep(2000);
        _globalDriver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        //  Switch to iframe here
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        //Add frame
        _globalDriver.switchTo().frame(iframe);
        Actions actions = new Actions(_globalDriver);

        WebElement elementToDrag = _globalDriver.findElement(By.xpath("/html/body/div[1]"));
        WebElement elementToDropIn = _globalDriver.findElement(By.xpath("/html/body/div[2]"));


        actions.dragAndDrop(elementToDrag,elementToDropIn).perform();

        String resultText = _globalDriver.findElement(By.xpath("/html/body/div[2]/p")).getText();

        Assert.assertEquals(resultText,"Dropped!");

    }

    @Test
    public void dragAndDropToMultipleBox() throws InterruptedException {
        Thread.sleep(2000);
        _globalDriver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]/a")).click();
        //  Switch to iframe here
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        //Add frame
        _globalDriver.switchTo().frame(iframe);
        Actions actions = new Actions(_globalDriver);

        WebElement elementToDrag = _globalDriver.findElement(By.id("draggable"));
        WebElement elementToDropToOne = _globalDriver.findElement(By.id("droppable"));
        WebElement elementToDropToTwo = _globalDriver.findElement(By.id("droppable2"));
        WebElement elementToDropToTree = _globalDriver.findElement(By.id("droppable-inner"));
        WebElement elementToDropToFour = _globalDriver.findElement(By.id("droppable2-inner"));

        actions.dragAndDrop(elementToDrag,elementToDropToOne).perform();
        actions.clickAndHold(elementToDrag).moveToElement(elementToDropToTwo).moveByOffset(0,-50).release().perform();
        actions.dragAndDrop(elementToDrag,elementToDropToTree).perform();
        actions.dragAndDrop(elementToDrag,elementToDropToFour).perform();

        String resultTextOne = _globalDriver.findElement(By.xpath("/html/body/div[2]/p")).getText();
        String resultTextTwo = _globalDriver.findElement(By.xpath("/html/body/div[2]/div/p")).getText();
        String resultTextThree = _globalDriver.findElement(By.xpath("/html/body/div[3]/p")).getText();
        String resultTextFour = _globalDriver.findElement(By.xpath("/html/body/div[3]/div/p")).getText();

        Assert.assertEquals(resultTextOne,"Dropped!");
        Assert.assertEquals(resultTextTwo,"Dropped!");
        Assert.assertEquals(resultTextThree,"Dropped!");
        Assert.assertEquals(resultTextFour,"Dropped!");

    }


    @Test
    public void resizeSimple() throws InterruptedException {
        Thread.sleep(2000);
        _globalDriver.get("https://www.way2automation.com/way2auto_jquery/resizable.php#load_box");
       // _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]/a")).click();
        //  Switch to iframe here
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        //Add frame
        _globalDriver.switchTo().frame(iframe);
        Actions actions = new Actions(_globalDriver);


        WebElement dragButton = _globalDriver.findElement(By.xpath("/html/body/div/div[3]"));
        Point beforeResize = dragButton.getLocation();
        actions.clickAndHold(dragButton).moveByOffset(100,100).release().perform();

        Point afterResize = dragButton.getLocation();

        Assert.assertEquals(afterResize.getX(),beforeResize.getX()+100);

    }


    @Test
    public void resizeAnimated() throws InterruptedException {
        Thread.sleep(2000);
        _globalDriver.get("https://www.way2automation.com/way2auto_jquery/resizable.php#load_box");
         _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        //  Switch to iframe here
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        //Add frame
        _globalDriver.switchTo().frame(iframe);
        Actions actions = new Actions(_globalDriver);


        WebElement dragButton = _globalDriver.findElement(By.xpath("/html/body/div/div[3]"));
        Point beforeResize = dragButton.getLocation();
        actions.clickAndHold(dragButton).moveByOffset(200,200).release().perform();
        Point afterResize = dragButton.getLocation();

        boolean testFlag = false;
        try {
            Assert.assertEquals(afterResize.getX(),beforeResize.getX()+200);
        }catch (AssertionError e){
            testFlag = true;
        }
        Assert.assertTrue(testFlag);

        Thread.sleep(1000);
        afterResize = dragButton.getLocation();
        Assert.assertEquals(afterResize.getX(),beforeResize.getX()+200);
    }

    @Test
    public void selectable() throws InterruptedException {
        Thread.sleep(2000);
        _globalDriver.get("https://www.way2automation.com/way2auto_jquery/resizable.php#load_box");
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[4]/a")).click();
        //  Switch to iframe here
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        //Add frame
        _globalDriver.switchTo().frame(iframe);
        Actions actions = new Actions(_globalDriver);

    }



    @Test
    public void accordion() throws InterruptedException {
        Thread.sleep(2000);
        _globalDriver.get("https://www.way2automation.com/way2auto_jquery/accordion.php#load_box");
        //  Switch to iframe here
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        //Add frame
        _globalDriver.switchTo().frame(iframe);
       // click on one part
        _globalDriver.findElement(By.id("ui-id-3")).click();

        WebElement openedSection =  _globalDriver.findElement(By.id("ui-id-4"));

        String displayValue = openedSection.getAttribute("Display");

        Assert.assertEquals("block",displayValue);

    }





}
