package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.debugger.model.BreakpointId;

import java.util.ArrayList;
import java.util.List;

public class BagSteps  extends CommonFunctions{



    @Given("I am on home page {string}")
    public void openHomePage(String url)
    {
      driver.get(url);
      Assert.assertTrue(driver.findElement(By.className("login_logo")).isDisplayed());
    }

    @When("I do Login with username {string} and password {string}")
    public void doLogin(String username, String password)
    {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login-button")).click();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());

    }

    @When("I choose a product {string}")
    public void chooseProduct(String productName)
    {

       driver.findElement(By.xpath("//div[@data-test=\"inventory-item-name\" and text()='"+productName+"']")).click();
       Assert.assertTrue(driver.findElement(By.name("back-to-products")).isDisplayed());
    }

    @When("I click Add to cart button with badge {string}")
    public void addBag(String badgeValue)
    {
        driver.findElement(By.name("add-to-cart")).click();
        Assert.assertEquals(badgeValue,driver.findElement(By.className("shopping_cart_badge")).getText());

    }

    @When( "I click bag icon")
    public void clickBagIcon()
    {
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }

    @Then("I should see product {string} in the bag")
    public void verifyProductInBag(String expectedProductInBag)
    {
         Assert.assertEquals(expectedProductInBag, driver.findElement(By.className("inventory_item_name")).getText());
    }

    @When("I click remove button in bag")
    public void clickRemoveButton()
    {

        driver.findElement(By.xpath("//button[text()='Remove']")).click();
    }

    @Then("The product {string} should be removed")
    public void verifyRemoveProduct(String removedProduct)
    {
          assertNoSuchElement(driver, By.className("inventory_item_name"));
    }

    @Then("I should see products {string} and {string} in the bag")
    public void verifyMultiProductInBag(String expectedProduct1, String expectedProduct2)
    {
        String expectedProducts[] = {expectedProduct1, expectedProduct2};

        List<WebElement> actualProductsInBag = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));

        List<String> actualProductNames = new ArrayList<>();

        for(WebElement actualProduct : actualProductsInBag)
        {
           actualProductNames.add(actualProduct.getText());

        }

        boolean isEqual = actualProductNames.equals(expectedProduct2);

        /*for(String expectedProduct : expectedProducts)
        {
           System.out.println(actualProductNames);
            System.out.println(expectedProduct);
            Assert.assertTrue(actualProductNames.contains(expectedProduct));
        }*/
    }


    @When("I click back button")
    public void clickBackButton()
    {
       driver.findElement(By.xpath("//button[text()='Back to products']")).click();
       Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }





}
