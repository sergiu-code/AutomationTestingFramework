package com.itstep.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout extends AbstractPage {

    @FindBy(xpath = "//td[@class='cart_description']//a[contains(text(),'Printed Dress')]")
    WebElement printedDress;
    @FindBy(xpath = "//span[@class='label label-success']")
    WebElement InStock;
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedToCheckout;
    @FindBy(xpath = "//span[contains(text(),'Summary')]")
    WebElement summary;
    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    WebElement signIn;
    @FindBy(id = "SubmitLogin")
    WebElement submit;
    @FindBy(xpath = "//li[@class='step_current third']//span[contains(text(),'Address')]")
    WebElement address;
    @FindBy(xpath = "//li[@class='step_current four']//span[contains(text(),'Shipping')]")
    WebElement shipping;
    @FindBy(className = "delivery_options_address")
    WebElement deliveryOption;
    @FindBy(id = "cgv")
    WebElement termsOfService;
    @FindBy(xpath = "//span[contains(text(),'Payment')]")
    WebElement payment;
    @FindBy(xpath = "//p[@class='fancybox-error']")
    WebElement message;
    @FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
    WebElement close;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement processAddress;
    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement processCarrier;

    public Checkout(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "/index.php?controller=order";
    }
}
