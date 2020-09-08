package com.itstep.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends AbstractPage {

    @FindBy(className = "account")
    WebElement viewMyCustomerAccount;
    @FindBy(xpath = "//span[contains(text(),'sergiu balan')]")
    WebElement fullName;
    @FindBy(className = "logout")
    WebElement logOut;


    @Override
    public String getPageUrl() {
        return "?controller=my-account";
    }

    public MyAccount(WebDriver driver) {
        super(driver);
    }
}
