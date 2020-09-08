package com.itstep.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement AddToCart;
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckout;
    @FindBy(xpath = "//span[contains(text(),'Summary')]")
    WebElement summaryCheckout;
    @FindBy(xpath = "//div[@id='layer_cart']//div[@class='clearfix']")
    WebElement cartInfo;
    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']//span[1]")
    WebElement continueShopping;

    public Product(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "http://automationpractice.com/index.php";
    }
}
