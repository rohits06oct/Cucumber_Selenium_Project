package PageObjects;

import Managers.chromeDriverCall;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage {

    WebDriver driver = chromeDriverCall.driver;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastname;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement confirmpassword;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private WebElement createaccountbutton;

    @FindBy(xpath = "//div[@class='panel header']//li[@class='customer-welcome']//button")
    private WebElement headerWelcomeName;

    @FindBy(xpath = "//div[@class='box-content']//p")
    private WebElement accountInfo;

    @FindBy(xpath = "//div[@class='panel header']//li[@class='authorization-link']")
    private WebElement signInButtonHeader;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailSignIn;

    @FindBy(xpath = "//fieldset//input[@id='pass']")
    private WebElement passwordSignIn;

    @FindBy(xpath = "//fieldset//button[@id='send2']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//li[@class='customer-welcome active']//a[contains(@href,'logout')]")
    private WebElement logoutButton;

    public void fillFirstName(String first) {
        firstName.isEnabled();
        firstName.clear();
        firstName.sendKeys(first);
    }

    public void fillLastName(String last) {
        lastname.isEnabled();
        lastname.clear();
        lastname.sendKeys(last);
    }

    public String fillEmail(String lastEmail) {
        email.isEnabled();
        email.clear();
        Date date = new Date();
        String epoch = "Test"+ date.getTime() +lastEmail;
        email.sendKeys(epoch);
        return epoch;
    }

    public void fillPassword(String pass) {
        password.isEnabled();
        password.clear();
        password.sendKeys(pass);
    }

    public void fillConfirmPassword(String pass) {
        confirmpassword.isEnabled();
        confirmpassword.clear();
        confirmpassword.sendKeys(pass);
    }

    public void clickOnCreateAccountButton() {
        createaccountbutton.isEnabled();
        createaccountbutton.click();
    }

    public String userUnderAccount() {
        String actualEmail = "";
        try {
            headerWelcomeName.isDisplayed();
            String accountDetails = accountInfo.getText();
            System.out.println(accountDetails);
            String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(accountDetails);
            actualEmail = matcher.group();
        } catch (Exception ignored){
            ignored.printStackTrace();
        }
        return actualEmail;
    }

    public void clickOnHeaderSignInButton() {
        signInButtonHeader.isDisplayed();
        signInButtonHeader.isEnabled();
        signInButtonHeader.click();
    }

    public void fillSignInUserName(String email) {
        emailSignIn.isEnabled();
        emailSignIn.clear();
        emailSignIn.sendKeys(email);
    }

    public void fillSignInPassword(String password) {
        passwordSignIn.isEnabled();
        passwordSignIn.clear();
        passwordSignIn.sendKeys(password);
    }

    public void SignInButton() {
        buttonSignIn.isDisplayed();
        buttonSignIn.isEnabled();
        buttonSignIn.click();
    }

    public void logoutButton() {
        headerWelcomeName.isDisplayed();
        headerWelcomeName.isEnabled();
        headerWelcomeName.click();
        logoutButton.isDisplayed();
        logoutButton.isEnabled();
        logoutButton.click();
    }

}
