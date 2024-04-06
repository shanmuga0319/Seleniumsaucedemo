import functionLibrary.CommonFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    CommonFunctions commonFunctions = new CommonFunctions();
    @Before
    public void beforeTest()
    {
        commonFunctions.openBrowser();
    }

    @After
    public void afterTest()
    {
        commonFunctions.closeBrowser();
    }
}
