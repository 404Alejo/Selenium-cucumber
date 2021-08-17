package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pageobjects.AmazonSearch;
import pageobjects.ProductPage;
import util.DriverFactory;
import util.DriverType;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class AmazonSearchSteps {
    WebDriver driver;
    AmazonSearch amazonSearch;
    ProductPage productPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        amazonSearch = new AmazonSearch(driver);
        productPage = new ProductPage(driver);
    }

    @Given("the user navigates to www.amazon.com")
    public void the_user_navigates_to_www_amazon_com() {
        driver.get("https://www.amazon.com");
    }

    @Given("Searches for {string}")
    public void searches_for(String string) {
        amazonSearch.setSearch("Alexa \n");
    }

    @Given("navigates to the second page")
    public void navigates_to_the_second_page() {
        amazonSearch.clickNextPage();
        // todo assert page 2
    }

    @Given("selects the third item")
    public void selects_the_third_item() {
        amazonSearch.clickProductX(3);
        // todo add exeption handler out of index
        // todo add assert change page to product details
    }

    @Then("assert that the item would be available for purchase \\(the user would be able to add it to the car)")
    public void assert_that_the_item_would_be_available_for_purchase_the_user_would_be_able_to_add_it_to_the_car() {
        try {
            assertTrue(productPage.isAbleToAddToCart());
        } catch (NoSuchElementException e) {
            assertTrue(false);
        }
    }

    @After
    public void tidyUp() {
        driver.close();
    }
}
