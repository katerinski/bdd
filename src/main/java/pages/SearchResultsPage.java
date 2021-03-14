package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']/span")
    private List<WebElement> wishListIcon;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']//span")
    private WebElement wishButton;

    private final WebElement wishIcon2;
    {
        assert false;
        wishIcon2 = wishListIcon.get(1);
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWishListOnFirstProduct() {
        wishListIcon.get(0).click();
    }

    public void clickWishListOnSecondProduct() { wishIcon2.click(); }

    public void clickWishButton() { wishButton.click(); }
}
