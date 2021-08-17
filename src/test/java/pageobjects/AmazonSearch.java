package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearch {
    public AmazonSearch(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
