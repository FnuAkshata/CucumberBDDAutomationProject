package Automation.Practice.stepDefinition;

import Automation.Practice.Pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginStepDef {

    public WebDriver driver;
    public String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("User is on the automationpractice login page")
    public void userOnTheAutomationpracticeLoginPage() {

        DriverFactory.getDriver().get("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
//        throw new io.cucumber.java.PendingException();
    }

    @Given("^I have entered the valid username and password$")
    public void i_have_entered_the_valid_username_and_password() throws Throwable {
        loginPage.enterUsername("Saha@emil.com");
        loginPage.enterPassword("Saha@123");
//        throw new PendingException();
    }

    @Given("^I have entered invalid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_have_entered_invalid_something_and_something(String username, String password) throws Throwable {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
//        throw new PendingException();
    }

    @When("^user gets the title of the page$")
    public void user_gets_the_title_of_the_page() throws Throwable {
        title = loginPage.getLoginPageTitle();
        System.out.println("GTitle of the page is: " + title);
//        throw new io.cucumber.java.PendingException();

    }


    @When("^I click on the login button$")
    public void i_click_on_the_login_button() throws Throwable {
        loginPage.clickOnSignIn();
//        throw new PendingException();
    }


    @When("^I click on the \"([^\"]*)\" link$")
    public void i_click_on_the_something_link(String strArg1) throws Throwable {
//        throw new PendingException();
        loginPage.clickForgotPwdLink();
    }

    @Then("^page title should be \"([^\"]*)\"$")
    public void page_title_should_be_something(String expectedTitleName) throws Throwable {
        Assert.assertTrue(title.contains(expectedTitleName));
//        throw new io.cucumber.java.PendingException();
    }

    @Then("^I should be logged in successfully$")
    public void i_should_be_logged_in_successfully() throws Throwable {
//        throw new PendingException();
        Assert.assertTrue(loginPage.checkSignOutButton());
    }

    @Then("^I should be redirected to the password reset page$")
    public void i_should_be_redirected_to_the_password_reset_page() throws Throwable {
//        throw new PendingException();
        Assert.assertTrue(loginPage.getForgotPwdUrl().contains("controller=password"));
    }




}
