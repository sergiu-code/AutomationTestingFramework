package com.itstep.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreation extends AbstractPage {

    @FindBy(xpath = "//label[contains(@for,'id_gender') and normalize-space()='Mr.']")
    WebElement gender;
    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;
    @FindBy(id = "customer_lastname")
    WebElement customerLastName;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(id = "days")
    WebElement days;
    @FindBy(id = "months")
    WebElement months;
    @FindBy(id = "years")
    WebElement years;
    @FindBy(id = "firstname")
    WebElement firstName;
    @FindBy(id = "lastname")
    WebElement lastName;
    @FindBy(id = "address1")
    WebElement address;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "id_state")
    WebElement state;
    @FindBy(id = "postcode")
    WebElement postCode;
    @FindBy(id = "id_country")
    WebElement country;
    @FindBy(id = "phone_mobile")
    WebElement phoneMobile;
    @FindBy(xpath = "//span[contains(text(),'Register')]")
    WebElement register;

    public AccountCreation(final WebDriver driver) {
        super(driver);
    }


    @Override
    public String getPageUrl() {
        return "/index.php?controller=authentication&back=my-account";
    }
}
