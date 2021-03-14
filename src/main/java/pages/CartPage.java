package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//h2[@class='empty-bag-title']")
    private WebElement cartIsEmpty;

    public CartPage(WebDriver driver) { super(driver); }

    public void clickRemoveButton() { removeButton.click(); }

    public WebElement getRemoveButton() { return  removeButton; }

    public WebElement getCartIsEmpty() { return cartIsEmpty; }

    public String getCartIsEmptyText() { return cartIsEmpty.getText(); }

}