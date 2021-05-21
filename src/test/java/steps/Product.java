package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class Product extends Base {

    String sku = "3781460";

    private Base base;

    public Product (Base base) { this.base = base; }

    @Given("^I access the Cobasi page in Portuguese$")
    public void iAccessTheCobasiPageInPortuguese() {
        base.driver.get(base.url);
    }

    @When("^I query \"([^\"]*)\"$")
    public void iQuery(String product) {
        // Wait added to load all elements
        WebDriverWait wait = new WebDriverWait(base.driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

        base.driver.findElement(By.id("lgpd__button")).click();

        base.driver.findElement(By.name("q")).sendKeys(product + Keys.ENTER);
    }

    @Then("^The page title contains the expression \"([^\"]*)\"$")
    public void thePageTitleContainsTheExpression(String product) {
        assertEquals(base.driver.getTitle(), product);
    }

    @When("^I select \"([^\"]*)\"$")
    public void iSelect(String product)  {
        base.driver.findElement(By.id("nm-product-" + sku)).click();
    }

    @Then("^The page title is \"([^\"]*)\"$")
    public void thePageTitleIs(String product) {
        assertTrue(base.driver.getTitle().contains(product));
    }

    @And("^The product name is \"([^\"]*)\"$")
    public void theProductNameIs(String product) {
        assertTrue(base.driver.findElement(By.cssSelector("h1.product__name")).getText().equals(product));
    }

    @And("^The price is \"([^\"]*)\"$")
    public void thePriceIs(String price) {
        assertTrue(base.driver.findElement(By.cssSelector(".d-block.price__por")).getText().contains(price));
    }
}
