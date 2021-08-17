package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearch {
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;

    @FindBy(xpath = "//a[contains(text(), 'Next')]")
    WebElement btnNextPage;

    @FindBy(xpath = "//span[@cel_widget_id='MAIN-SEARCH_RESULTS-2']")
    WebElement thirdElement;

    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']")
    WebElement resultList;


    public AmazonSearch(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setSearch(String searchString) {
        searchBar.sendKeys(searchString);
    }

    public void clickNextPage() {
        btnNextPage.click();
    }

    private WebElement getElementByIndex(int elementIndex) {
        List<WebElement> list = new ArrayList<>();
        list = resultList.findElements(By.xpath("child::*[" + (elementIndex + 1) + "]//h2/a"));
        return list.get(0);
    }

    public void clickProductX(int elementIndex) {
        getElementByIndex(elementIndex).click();
    }
}

