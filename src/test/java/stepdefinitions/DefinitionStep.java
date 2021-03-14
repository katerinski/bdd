package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionStep {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    SearchResultsPage searchResultsPage;
    WishPage wishPage;
    ProductPage productPage;
    CartPage cartPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks footer visibility")
    public void checkFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User checks main logo visibility")
    public void checkMainLogoVisibility() {
        homePage.isMainLogoVisible();
    }

    @And("User checks women button visibility")
    public void checkWomenButtonVisibility() {
        homePage.isWomenButtonVisible();
    }

    @And("User checks men button visibility")
    public void checkMenButtonVisibility() {
        homePage.isMenButtonVisible();
    }

    @And("User checks search input visibility")
    public void checkSearchInputVisibility() {
        homePage.isSearchInputVisible();
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @When("User clicks sign in button")
    public void clickSignInButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInButton());
        homePage.clickSignInButton();
    }

    @And("User checks sign in button visibility in popup")
    public void checkInPopupSignInButtonVisibility() {
        homePage.isSignInPopUpButtonVisible();
    }

    @And("User checks join button visibility in popup")
    public void checkInPopupJoinButtonVisibility() {
        homePage.isJoinButtonPopUpVisible();
    }

    @And("User closes sign in popup")
    public void closeSignInPopup() {
        homePage.clickSignInPopupCloseButton();
    }

    @And("User checks wish button visibility")
    public void checkWishButtonVisibility() {
        homePage.isWishButtonVisible();
    }

    @And("User checks cart visibility")
    public void checkCartVisibility() {
        homePage.isCartButtonVisible();
    }

    @And("User checks country button visibility")
    public void checkCountryButtonVisibility() {
        homePage.isCountryButtonVisible();
    }

    @When("User clicks country button")
    public void clickCountryButton() {
        homePage.clickCountryButton();
    }

    @And("User checks that country popup visible")
    public void checkThatCountryPopupVisible() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCountrySelectionPopUp());
        assertTrue(homePage.isCountrySelectionPopUpVisible());
    }

    @Then("User checks country popup header is {string}")
    public void checkCountryPopupHeaderIsHeader(final String expectedText) {
        assertEquals( expectedText, homePage.getCountrySelectionPopUpHeader().getText());
    }

    @When("User makes search by keyword {string}")
    public void makeSearchByKeyword(final String keyword) {
        homePage.enterTextToSearchInput(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User clicks wish list on first product")
    public void clickWishListOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        searchResultsPage.clickWishListOnFirstProduct();
    }

    @When("User clicks wish button")
    public void clickWishButton() {
        searchResultsPage.clickWishButton();
        wishPage = pageFactoryManager.getWishPage();
        wishPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that amount of products in wish list are {string}")
    public void checkAmountOfProductsInWishList(String expectedAmount) throws InterruptedException {
        wishPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishPage.getWishListAmount());
        sleep(1500);
        assertEquals(expectedAmount, wishPage.getAmountOfProductsInWishList());
    }

    @And("User clicks wish list on second product")
    public void clickWishListOnSecondProduct() {
        searchResultsPage.clickWishListOnSecondProduct();
    }

    @And("User counts amount of products in wish list and checks if it equals {string}")
    public void countAmountOfProductsInWishList(String expectedAmount) {
        wishPage = pageFactoryManager.getWishPage();
        wishPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishPage.getWishListAmount());
        int am = wishPage.countWishList();
        String count = Integer.toString(am);
        String amount = wishPage.getAmountOfProductsInWishList();
        assertTrue(amount.contains(count));
        assertEquals(expectedAmount, wishPage.getAmountOfProductsInWishList());
    }

    @And("User removes one product from wish list")
    public void removeOneProductFromWishList() {
        wishPage.clickDeleteFromWishListButton();
    }

    @And("User moves one product from wish list to cart")
    public void moveOneProductToCart() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        wishPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishPage.moveToCartButton());
        wishPage.clickMoveToCartButton();
    }

    @Then("User checks that amount of products in cart are {string}")
    public void checkAmountOfProductsInCart(String expectedAmount) {
        wishPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,wishPage.getCartPopUp());
        assertEquals(expectedAmount, wishPage.getAmountOfProductsInCart());
    }

    @And("User checks that wishlist is {string}")
    public void checkWishlistIsEmpty(String text) {
        wishPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishPage.getWishListEmpty());
        assertTrue(wishPage.getWishListEmptyText().contains(text));
    }

    @And("User clicks Add to Cart button on product")
    public void clickAddToCartButtonOnProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();

    }

    @And("User checks that add to cart popup visible")
    public void checkAddToCartPopupVisible() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getCartPopUp());
        assertTrue(productPage.isCartPopUpVisible());
    }

    @Then("User checks that in cart is {string}")
    public void checkAmountOfProductInCart(String expectedAmount) {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getCartPopUp());
        assertEquals(expectedAmount, productPage.getAmountOfProductsInCart());
    }

    @And("User clicks Checkout button")
    public void clickCheckoutButton() {
        productPage.clickCheckoutButton();
    }

    @When("User clicks View Cart Button")
    public void clickViewCartButton() {
        productPage.clickViewCartButton();
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks Remove Button")
    public void userClicksRemoveButton() {
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getRemoveButton());
        cartPage.clickRemoveButton();
    }

    @Then("User checks that cart is {string}")
    public void checkThatCartIsEmpty(String text) {
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getCartIsEmpty());
        assertTrue(cartPage.getCartIsEmptyText().contains(text));
    }

    @And("User clicks sign in popup button")
    public void clickSignInPopupButton() {
        homePage.clickSignInPopUpButton();
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks Email address input is visible")
    public void checkEmailInputIsVisible() {
        assertTrue(signInPage.isUsernameInputVisible());
    }

    @And("User checks Password input is visible")
    public void checkPasswordInputIsVisible() {
        assertTrue(signInPage.isPasswordInputVisible());
    }

    @And("User fill in Email address input with {string}")
    public void fillInEmailInput(String email) {
        signInPage.fillInUsernameInput(email);
    }

    @And("User fill in Password input with {string}")
    public void fillInPasswordInputWithWrongPassword(String wrongPassword) {
        signInPage.fillInPasswordInput(wrongPassword);
    }

    @When("User clicks Sign in button")
    public void clickSignInButtonOnSignInPage() {
        signInPage.clickSignInButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks {string} is shown")
    public void checkErrorMessageIsShown(String errorMessage) {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getErrorMessage());
        assertTrue(signInPage.getErrorMessageText().contains(errorMessage));
    }

    @When("User clicks join popup button")
    public void clickJoinPopupButton() {
        homePage.clickJoinPopUpButton();
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks Email address for registration input is visible")
    public void checkEmailForRegistrationInputIsVisible() {
        assertTrue(signInPage.isEmailInputVisible());
    }

    @And("User fill in Email address for registration input with {string}")
    public void fillInEmailForRegistrationInput(String email) {
        signInPage.fillInEmailInput(email);
    }

    @And("User checks First Name input is visible")
    public void checkFirstNameInputIsVisible() {
        assertTrue(signInPage.isFirstNameInputVisible());
    }

    @And("User checks Last Name input is visible")
    public void checkLastNameInputIsVisible() {
        assertTrue(signInPage.isLastNameInputVisible());
    }

    @And("User checks Birth Day input is visible")
    public void checkBirthDayInputIsVisible() {
        assertTrue(signInPage.isBirthDaySelectVisible());
    }

    @And("User checks Birth Month input is visible")
    public void checkBirthMonthInputIsVisible() {
        assertTrue(signInPage.isBirthMonthVisible());
    }

    @And("User checks Birth Year input is visible")
    public void checkBirthYearInputIsVisible() {
        assertTrue(signInPage.isBirthYearVisible());
    }

    @And("User fill in First Name input with {string}")
    public void fillInFirstNameInput(String firstName) {
        signInPage.fillInFirstNameInput(firstName);
    }

    @And("User fill in Last Name input with {string}")
    public void fillInLastNameInput(String lastName) {
        signInPage.fillInLastNameInput(lastName);
    }

    @And("User fill in Birth Day input with {string}")
    public void fillInBirthDayInput(String day) {
        signInPage.selectBirthDay(day);
    }

    @And("User fill in Birth Month input with {string}")
    public void fillInBirthMonthInput(String month) {
        signInPage.selectBirthMonth(month);
    }

    @And("User fill in Birth Year input with {string}")
    public void fillInBirthYearInput(String year) {
        signInPage.selectBirthYear(year);
    }

    @When("User clicks Join button")
    public void clickJoinButton() {
        signInPage.clickJoinButton();
    }

    @Then("User checks sign in was successful and {string} is shown")
    public void checkSignInMessageIsShown(String message) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInMessage());
        assertTrue(homePage.signInMessageText().contains(message));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
