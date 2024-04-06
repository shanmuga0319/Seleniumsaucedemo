package functionLibrary;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.time.Duration;

public class CommonFunctions {

    public static WebDriver driver;
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    public void closeBrowser()
    {
        driver.quit();
    }
    public void assertNoSuchElement(WebDriver driver, By by)
    {
        try
        {
            WebElement element = driver.findElement(by);
            Assert.fail();
        }
        catch (NoSuchElementException e)
        {
            Assert.assertTrue(true);
        }
    }

    public void type(WebElement  element, String text)
    {
        element.sendKeys(text);
    }

    public void waitTime(WebDriver driver, Duration duration)
    {
        driver.manage().timeouts().implicitlyWait(duration);
    }

    public WebElement findElement(WebDriver driver, By by)
    {
        return driver.findElement(by);
    }

    public void clickElement(WebDriver driver, By by)
    {
        findElement(driver, by).click();
    }


}
