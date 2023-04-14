package Automation.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailAddress = By.id("email");
    private By password = By.id("passwd");
    private By signIn = By.id("SubmitLogin");
    private By forgotPwdLink = By.cssSelector("a[title='Recover your forgotten password']");
    private By signOut = By.cssSelector("a[class='logout']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public void enterUsername(String email){
        driver.findElement(emailAddress).sendKeys(email);
    }

    public void enterPassword(String pasword){
        driver.findElement(password).sendKeys(pasword);
    }

    public void clickOnSignIn()
    {
        driver.findElement(signIn).click();
    }

    public boolean checkSignOutButton(){
        return driver.findElement(signOut).isDisplayed();
    }

    public boolean checkForgotPwdUrl(){
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void clickForgotPwdLink()
    {
        driver.findElement(forgotPwdLink).click();
    }

    public String getForgotPwdUrl(){
       return driver.getCurrentUrl();
    }

    public AccountPage doLogin(String un, String pw)
    {
        System.out.println("Login with : "+un+ "and " +pw);
        driver.findElement(emailAddress).sendKeys(un);
        driver.findElement(password).sendKeys(pw);
        driver.findElement(signIn).click();
        return new AccountPage(driver);
    }
}

