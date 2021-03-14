package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//li[@id='loginErrorMessage']")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@id='register']")
    private WebElement joinButton;

    @FindBy(xpath = "//input[@name='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='FirstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='LastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//select[@name='BirthDay']")
    private WebElement birthDaySelect;

    @FindBy(xpath = "//select[@name='BirthMonth']")
    private WebElement birthMonthSelect;

    @FindBy(xpath = "//select[@name='BirthYear']")
    private WebElement birthYearSelect;

    public SignInPage(WebDriver driver) { super(driver); }

    public boolean isUsernameInputVisible() { return usernameInput.isDisplayed(); }

    public boolean isEmailInputVisible() { return emailInput.isDisplayed(); }

    public boolean isPasswordInputVisible() { return passwordInput.isDisplayed(); }

    public boolean isFirstNameInputVisible() { return firstNameInput.isDisplayed(); }

    public boolean isLastNameInputVisible() { return lastNameInput.isDisplayed(); }

    public boolean isBirthDaySelectVisible() { return birthDaySelect.isDisplayed(); }

    public boolean isBirthMonthVisible() { return birthMonthSelect.isDisplayed(); }

    public boolean isBirthYearVisible() { return birthYearSelect.isDisplayed(); }

    public void fillInUsernameInput(String username) { usernameInput.sendKeys(username);}

    public void fillInEmailInput(String email) { emailInput.sendKeys(email);}

    public void fillInFirstNameInput(String firstName) { firstNameInput.sendKeys(firstName);}

    public void fillInLastNameInput(String lastName) { lastNameInput.sendKeys(lastName);}

    public void selectBirthDay(String birthDay) { birthDaySelect.sendKeys(birthDay, Keys.ENTER);}

    public void selectBirthMonth(String birthMonth) { birthMonthSelect.sendKeys(birthMonth, Keys.ENTER);}

    public void selectBirthYear(String birthYear) { birthYearSelect.sendKeys(birthYear, Keys.ENTER);}

    public void fillInPasswordInput(String password) { passwordInput.sendKeys(password);}

    public void clickSignInButton() { signInButton.click(); }

    public WebElement getErrorMessage() {return errorMessage; }

    public String getErrorMessageText() { return errorMessage.getText(); }

    public void clickJoinButton() { joinButton.click(); }
}
