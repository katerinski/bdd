package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//a[@data-testid='asoslogo']")
    private WebElement mainLogo;

    @FindBy(xpath = "//a[@id='women-floor']")
    private WebElement womenButton;

    @FindBy(xpath = "//a[@id='men-floor']")
    private WebElement menButton;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='_3iH_8F6 -rhP1cz gBrrjX4 _2nHArcS']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']//a[@data-testid='signin-link']")
    private WebElement signInButtonPopUp;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']//a[@data-testid='signup-link']")
    private WebElement joinButtonPopUp;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']//span[@class='_1xgEXu7 -rhP1cz gBrrjX4 _2nHArcS']")
    private WebElement signInPopUpCloseButton;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']//span")
    private WebElement wishButton;

    @FindBy(xpath = "//a[@data-testid='miniBagIcon']//span")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class='_25L--Pi']/button[@data-testid='country-selector-btn']")
    private WebElement countryButton;

    @FindBy(xpath = "//section[@data-testid='country-selector-form']")
    private WebElement countrySelectionPopUp;

    @FindBy(xpath = "//h1[@id='country-title']")
    private WebElement countrySelectionPopUpHeader;

    @FindBy(xpath = "//span[@class='tiqiyps']")
    private WebElement signInMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isMainLogoVisible() { mainLogo.isDisplayed(); }

    public void isWomenButtonVisible() {
        womenButton.isDisplayed();
    }

    public void isMenButtonVisible() { menButton.isDisplayed(); }

    public void isSearchInputVisible() { searchInput.isDisplayed(); }

    public void enterTextToSearchInput(final String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void isSignInButtonVisible() {
        signInButton.isDisplayed();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getSignInButton() { return signInButton;}

    public void isSignInPopUpButtonVisible() {
        signInButtonPopUp.isDisplayed();
    }

    public void clickSignInPopUpButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInButtonPopUp);
    }

    public void clickJoinPopUpButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", joinButtonPopUp);
    }

    public void isJoinButtonPopUpVisible() {
        joinButtonPopUp.isDisplayed();
    }

    public void clickSignInPopupCloseButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInPopUpCloseButton);
    }

    public void isWishButtonVisible() {
        wishButton.isDisplayed();
    }

    public void isCartButtonVisible() {
        cartButton.isDisplayed();
    }

    public void isCountryButtonVisible() {
        countryButton.isDisplayed();
    }

    public void clickCountryButton() {
        countryButton.click();
    }

    public WebElement getCountrySelectionPopUpHeader() { return countrySelectionPopUpHeader; }

    public WebElement getCountrySelectionPopUp() { return countrySelectionPopUp; }

    public boolean isCountrySelectionPopUpVisible() { return countrySelectionPopUp.isDisplayed(); }

    public WebElement getSignInMessage() { return signInMessage; }

    public String signInMessageText() {return signInMessage.getText(); }
}
