package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;
import util.DriverType;

import java.util.concurrent.TimeUnit;

public class AmazonSearchSteps {
    WebDriver driver;

    @Given("the user navigates to www.amazon.com")
    public void the_user_navigates_to_www_amazon_com() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }

    @Given("Searches for {string}")
    public void searches_for(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("navigates to the second page")
    public void navigates_to_the_second_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("selects the third item")
    public void selects_the_third_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("assert that the item would be available for purchase \\(the user would be able to add it to the car)")
    public void assert_that_the_item_would_be_available_for_purchase_the_user_would_be_able_to_add_it_to_the_car() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
