package pageobjects;

import io.cucumber.messages.Messages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(id = "add-to-cart-button")
    WebElement btnAddToCart;

    public ProductPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isAbleToAddToCart() throws NoSuchElementException {
        return btnAddToCart.isDisplayed();
    }
}
