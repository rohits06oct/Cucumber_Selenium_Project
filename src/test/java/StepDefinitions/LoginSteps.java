package StepDefinitions;

import Managers.chromeDriverCall;
import PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver;
    String email;
    String password = "Test@1234";
    LoginPage loginPage = new LoginPage();

    public LoginSteps() {
        driver = chromeDriverCall.driver;
    }

    @Given("Open the URL")
    public void urlOpen() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Given("Open the create account page")
    public void createAccount() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @When("Fill all required details for account creation")
    public void fillRequiredDetails() {
        loginPage.fillFirstName("TestFirst");
        loginPage.fillLastName("TestLast");
        email = loginPage.fillEmail("@yopmail.com");
        loginPage.fillPassword(password);
        loginPage.fillConfirmPassword(password);
    }

    @When("Click on header Sign-In button")
    public void clickHeaderSignInButton() {
        loginPage.clickOnHeaderSignInButton();
    }

    @When("Click on the Create Account button")
    public void clickAccountCreate() {
        loginPage.clickOnCreateAccountButton();
    }

    @When("Fill user created username and password")
    public void fillUserNamePassword() {
        loginPage.fillSignInUserName(email);
        loginPage.fillSignInPassword(password);
    }

    @When("Click on Sign-In button")
    public void clickSignInButton() {
        loginPage.SignInButton();
    }

    @Then("Validate user successfully inside his account")
    public void userUnderAccount() {
        String expectedEmail = loginPage.userUnderAccount();
        Assert.assertEquals(email, expectedEmail);
    }

}
