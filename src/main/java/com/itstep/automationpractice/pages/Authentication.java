package com.itstep.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Authentication extends AbstractPage {

    @FindBy(xpath = "//form[@id='create-account_form']//span[1]")
    WebElement createAnAccount;
    @FindBy(id = "login_form")
    WebElement loginForm;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(id = "SubmitLogin")
    WebElement SignIn;
    @FindBy(id = "email_create")
    WebElement emailAddress;



    public Authentication(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "controller=authentication&back=my-account";
    }
}
