package com.itstep.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends AbstractPage {

    @FindBy(id = "search_query_top")
     WebElement search;
    @FindBy(className = "login")
     WebElement login;
    @FindBy(css = "#homefeatured>li:nth-child(3)")
    WebElement product;
    @FindBy(xpath = "//ul[@id='homefeatured']//li[3]//span[contains(text(),'Add to cart')]")
    WebElement addToCart;
    @FindBy(xpath = "//div[@class='shopping_cart']/a[1]")
    WebElement shoppingCart;
    @FindBy(xpath = "//div[@id='layer_cart']//div[@class='clearfix']")
    WebElement cartInfo;
    @FindBy(xpath = "//div[@class='cart_block_list']")
    WebElement itemProduct;
    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']//span[1]")
    WebElement continueShopping;
    @FindBy(xpath = "//ul[@id='homefeatured']//li[3]//span[contains(text(),'More')]")
    WebElement more;

    public Home(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "/index.php";
    }

}
