package Automation.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private WebDriver driver;

    /* */
    private By accountSections = By.cssSelector("#center_column span");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getAccountsSectionCount(){
        return driver.findElements(accountSections).size();
    }

    public List<String> getAccountSectionsList(){

        List<String> accountList= new ArrayList<>();
        List<WebElement> accountHeaderList = driver.findElements(accountSections);

        for (WebElement e: accountHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountList.add(text);

        }

        return accountList;
    }

    public String getAccountPageTitle(){
        return driver.getCurrentUrl();
    }
}
