package Automation.Practice.stepDefinition;

import Automation.Practice.Pages.AccountPage;
import Automation.Practice.Pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountStepDef {

    private AccountPage accountPage;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


    @Given("User has already logged in to application")
    public void userHasAlreadyLoggedinToApplication(DataTable credTable) {
        List<Map<String,String> > credList=  credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver().get("http://automationpractice.pl/index.php?controller=my-account");
        accountPage = loginPage.doLogin(userName,password);
    }

    @Given("user is on Account page")
    public void user_is_on_account_page() {

        String title = accountPage.getAccountPageTitle();
        System.out.println("Account page title: "+title);
    }
    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable ) {
        List<String> expAccountSectionList = sectionsTable.asList();
        System.out.println("Expected accounts section list: " +expAccountSectionList);

        List<String> actualAccountSectionList = accountPage.getAccountSectionsList();
        System.out.println("Actual accounts section list: " +actualAccountSectionList);

        Assert.assertEquals(expAccountSectionList,actualAccountSectionList);

    }
    @Then("Account section count should be {int}")
    public void account_section_count_should_be(Integer actualSectionCount) {
        Assert.assertTrue(accountPage.getAccountsSectionCount()==actualSectionCount);

    }

}
