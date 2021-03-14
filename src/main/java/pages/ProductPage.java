package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(),'Add to bag')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='_1ovivM0']")
    private WebElement cartPopUp;

    @FindBy(xpath = "//span[@data-test-id='miniBagItemCount']")
    private WebElement cartAmount;

    @FindBy(xpath = "//a[@data-test-id='checkout-link']//span[@class='_1M-cSy1']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//a[@data-test-id='bag-link']//span[@class='_1M-cSy1']")
    private WebElement viewCartButton;

    public ProductPage(WebDriver driver){ super(driver); }

    public void clickAddToCartButton() { addToCartButton.click(); }

    public WebElement getCartPopUp() { return cartPopUp; }

    public boolean isCartPopUpVisible() {return cartPopUp.isDisplayed(); }

    public String getAmountOfProductsInCart() {
        return cartAmount.getText();
    }

    public void clickCheckoutButton() { checkoutButton.click(); }

    public void clickViewCartButton() { viewCartButton.click(); }
}
