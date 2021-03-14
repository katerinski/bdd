package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishPage extends BasePage{

    @FindBy(xpath = "//div[@class='itemCount_1ZeG5']")
    private WebElement wishListAmount;

    @FindBy(xpath = "//div[@class='productImageWrapper_3aOXQ']")
    private List<WebElement> wishList;

    @FindBy(xpath = "//button[@aria-label='Delete']")
    private List<WebElement> deleteFromWishListButton;

    @FindBy(xpath = "//button[@class='toBagButton_OatoQ toBagButton_3wcKB']")
    private List<WebElement> moveToCartButton;

    @FindBy(xpath = "//span[@class='_1ovivM0']")
    private WebElement cartPopUp;

    @FindBy(xpath = "//span[@data-test-id='miniBagItemCount']")
    private WebElement cartAmount;

    @FindBy(xpath = "//h2[@class='noItemsPrompt_1TiQf']")
    private WebElement wishListIsEmpty;

    public WishPage(WebDriver driver){ super(driver); }

    public WebElement getWishListAmount() {
        return wishListAmount;
    }

    public String getAmountOfProductsInWishList() {
        return wishListAmount.getText();
    }

    public int countWishList() { return wishList.size(); }

    public void clickDeleteFromWishListButton() {
        deleteFromWishListButton.get(0).click();
    }

    public void clickMoveToCartButton() { moveToCartButton.get(0).click(); }

    public WebElement moveToCartButton() { return moveToCartButton.get(0); }

    public WebElement getCartPopUp() {
        return cartPopUp;
    }

    public String getAmountOfProductsInCart() {
        return cartAmount.getText();
    }

    public WebElement getWishListEmpty() { return wishListIsEmpty; }

    public String getWishListEmptyText() { return wishListIsEmpty.getText(); }
}
