package com.itstep.automationpractice.steps;

import com.itstep.automationpractice.pages.AbstractPage;
import com.itstep.automationpractice.selenium.Browser;
import com.itstep.automationpractice.utils.ReflectionUtils;
import com.itstep.automationpractice.utils.ScenarioContext;
import com.itstep.automationpractice.utils.ScenarioDataKey;
import com.itstep.automationpractice.utils.ScreenshotUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class MyStepdefs {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Actions delete = new Actions(Browser.getBrowser());
    private final Actions hover = new Actions(Browser.getBrowser());

    @Given("user navigates to {string} page")
    public void userNavigatesToPage(String url) {
        Browser.getBrowser().navigate().to(url);
        logger.info("User navigates to {} page ", url);
    }

    @And("user is on the {string} page")
    public void userIsOnPage(String pageName) throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            InterruptedException {

        Thread.sleep(5000);
        AbstractPage page = ReflectionUtils.getPageObject(pageName);
        ScreenshotUtils.takeScreenshot(pageName);
        MatcherAssert.assertThat(Browser.getBrowser().getCurrentUrl(), containsString(page.getPageUrl()));
        ScenarioContext.setContext(ScenarioDataKey.CURRENT_PAGE.name(), page);
        logger.info("User is on the {} page ", pageName);
    }

    @When("user clicks to {string} button")
    public void userClicksToButton(String buttonName) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(buttonName);
        ScreenshotUtils.takeScreenshotOfElement(buttonName, button);
        button.click();
        logger.info("User clicks {} button ", buttonName);
    }

    @And("user types new email into {string} field")
    public void userTypesNewEmail(String emailElement) throws IllegalAccessException {
        WebElement email = ReflectionUtils.getWebElement(emailElement);
        email.sendKeys((String) ScenarioContext.getContext("New Email"));
        ScreenshotUtils.takeScreenshotOfElement(emailElement, email);
        logger.info("User type an new email in {} field", emailElement);

    }


    @And("user selects the Mr. {string}")
    public void userSelectsGender(String gender) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(gender);
        ScreenshotUtils.takeScreenshotOfElement(gender, element);
        element.click();
        logger.info("User selected {} gender ", gender);

    }


    @And("email is displayed into {string} field")
    public void emailIsDisplayedInTheEmailField(String isEmail) throws IllegalAccessException {
        WebElement emailToValidate = ReflectionUtils.getWebElement(isEmail);
        MatcherAssert.assertThat(emailToValidate.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(isEmail, emailToValidate);
        logger.info("the email is displayed in {} field ", isEmail);
    }

    @And("user select the {string}, {string} and {string}")
    public void userSelectDateOfBirth(String days, String months, String years) throws IllegalAccessException {
        WebElement day = ReflectionUtils.getWebElement(days);
        new Select(day).selectByIndex(10);
        ScreenshotUtils.takeScreenshotOfElement(days, day);
        WebElement month = ReflectionUtils.getWebElement(months);
        new Select(month).selectByVisibleText("February ");
        ScreenshotUtils.takeScreenshotOfElement(months, month);
        WebElement year = ReflectionUtils.getWebElement(years);
        new Select(year).selectByValue("1993");
        ScreenshotUtils.takeScreenshotOfElement(years, year);
        logger.info("User selected {}, {}, {} ", days, months, years);
    }


    @And("user selects a state into the {string} field")
    public void userSelects(String selectValue) throws IllegalAccessException {
        WebElement state = ReflectionUtils.getWebElement(selectValue);
        new Select(state).selectByVisibleText("Florida");
        ScreenshotUtils.takeScreenshotOfElement(selectValue, state);
        logger.info("User selects the {} ", selectValue);


    }

    @And("user types first name into {string} field")
    public void userTypesFirstName(String customerFirstName) throws IllegalAccessException {
        WebElement firstName = ReflectionUtils.getWebElement(customerFirstName);
        firstName.sendKeys((String) ScenarioContext.getContext("FirstName"));
        ScreenshotUtils.takeScreenshotOfElement(customerFirstName, firstName);
        logger.info("User types first name into {} field ", customerFirstName);
    }

    @And("user types last name into {string} field")
    public void userTypesLastName(String customerLastName) throws IllegalAccessException {
        WebElement lastName = ReflectionUtils.getWebElement(customerLastName);
        lastName.sendKeys((String) ScenarioContext.getContext("LastName"));
        ScreenshotUtils.takeScreenshotOfElement(customerLastName, lastName);
        logger.info("User types last name into {} field ", customerLastName);
    }

    @And("user types new password into {string} field")
    public void userTypesNewPassword(String passwordElement) throws IllegalAccessException {
        WebElement password = ReflectionUtils.getWebElement(passwordElement);
        password.sendKeys((String) ScenarioContext.getContext("New Pass"));
        ScreenshotUtils.takeScreenshotOfElement(passwordElement, password);
        logger.info("User types new password into {} field ", passwordElement);
    }

    @And("user types an address into {string} field")
    public void userTypesAddress(String addressElement) throws IllegalAccessException {
        WebElement address = ReflectionUtils.getWebElement(addressElement);
        address.sendKeys("Stefan cel Mare 121");
        ScreenshotUtils.takeScreenshotOfElement(addressElement, address);
        logger.info("user types address into {} field ", addressElement);
    }

    @And("user types a city into {string} field")
    public void userTypesCity(String cityElement) throws IllegalAccessException {
        WebElement city = ReflectionUtils.getWebElement(cityElement);
        city.sendKeys("Miami");
        ScreenshotUtils.takeScreenshotOfElement(cityElement, city);
        logger.info("user types city into {} field ", cityElement);
    }

    @And("user types a postal code into {string} field")
    public void userTypesPostalCode(String postCode) throws IllegalAccessException {
        WebElement zipCode = ReflectionUtils.getWebElement(postCode);
        zipCode.sendKeys("33101");
        ScreenshotUtils.takeScreenshotOfElement(postCode, zipCode);
        logger.info("User types postal code into {} field ", postCode);
    }

    @And("user types a phone number into {string} field")
    public void userTypesPhoneNumber(String phone) throws IllegalAccessException {
        WebElement mobile = ReflectionUtils.getWebElement(phone);
        mobile.sendKeys("045896632");
        ScreenshotUtils.takeScreenshotOfElement(phone, mobile);
        logger.info("User types a phone number into {} field ", phone);
    }

    @And("user types a first name for address into {string} field")
    public void userTypesFirstNameForAddress(String element) throws IllegalAccessException {
        WebElement firstName = ReflectionUtils.getWebElement(element);
        delete.contextClick(firstName).sendKeys(firstName, "Sergiu").perform();
        ScreenshotUtils.takeScreenshotOfElement(element, firstName);
        logger.info("User types first name for address into {} field ", element);
    }

    @And("user types a last name for address into {string} field")
    public void userTypesLastNameForAddress(String element) throws IllegalAccessException {
        WebElement lastName = ReflectionUtils.getWebElement(element);
        delete.contextClick(lastName).sendKeys(lastName, "BalaN").perform();
        ScreenshotUtils.takeScreenshotOfElement(element, lastName);
        logger.info("user types last name for address into {} field ", element);
    }

    @And("user types a registered email into {string} field")
    public void userTypesAnRegisteredEmail(String field) throws IllegalAccessException {
        WebElement registeredEmail = ReflectionUtils.getWebElement(field);
        ScreenshotUtils.takeScreenshotOfElement(field, registeredEmail);
        registeredEmail.sendKeys("sergiu.balan@getnada.com");
        logger.info("User types a valid email into {} field", field);

    }

    @And("user types a registered password into {string} field")
    public void userTypesARegisteredPassword(String field) throws IllegalAccessException {
        WebElement password = ReflectionUtils.getWebElement(field);
        ScreenshotUtils.takeScreenshotOfElement(field, password);
        password.sendKeys("sergiubalan");
        logger.info("User types a valid email into {} field", field);
    }

    @And("{string} is displayed")
    public void IsDisplayed(String elementName) throws IllegalAccessException, InterruptedException {
        WebElement element = ReflectionUtils.getWebElement(elementName);
        Thread.sleep(3000);
        MatcherAssert.assertThat(element.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(elementName, element);
        logger.info("{} is displayed", elementName);

    }

    @Then("{string} button is displayed")
    public void ButtonIsDisplayed(String buttonName) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(buttonName);
        MatcherAssert.assertThat(button.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(buttonName, button);
        logger.info("{} button is displayed", buttonName);
    }

    @And("{string} button is on the right of the product")
    public void ButtonIsOnTheRightOfTheProduct(String buttonName) {
        WebElement product = Browser.getBrowser().findElement(By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']"));
        Browser.getBrowser().findElement(withTagName("span").toRightOf(product));
        ScreenshotUtils.takeScreenshotOfElement(buttonName, product);
        logger.info("{} button is on the right of the product", buttonName);
    }

    @And("product {string} is {string}")
    public void productInStock(String productName, String status) throws IllegalAccessException {
        WebElement product = ReflectionUtils.getWebElement(productName);
        MatcherAssert.assertThat(product.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(productName, product);
        WebElement inStock = ReflectionUtils.getWebElement(status);
        MatcherAssert.assertThat(inStock.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(status, inStock);
        logger.info("Product {} is {}", productName, status);
    }

    @And("{string} of user is displayed")
    public void fullNameOfCustomerIsDisplayed(String fullName) throws IllegalAccessException {
        WebElement name = ReflectionUtils.getWebElement(fullName);
        MatcherAssert.assertThat(name.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(fullName, name);
        logger.info("{} of user is displayed", fullName);

    }

    @And("user is on the {string} step")
    public void userIsOnTheStep(String stepName) throws IllegalAccessException, InterruptedException {
        WebElement step = ReflectionUtils.getWebElement(stepName);
        Thread.sleep(2000);
        MatcherAssert.assertThat(step.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(stepName, step);
        logger.info("User is on the {} step", stepName);
    }

    @And("user agrees to the {string}")
    public void TermsOfService(String elementName) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(elementName);
        ScreenshotUtils.takeScreenshotOfElement(elementName, element);
        element.click();
        logger.info("User agrees to the {}", elementName);
    }

    @Then("a pop-up {string} is displayed")
    public void aPopUpMessageIsDisplayed(String elementName) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(elementName);
        MatcherAssert.assertThat(element.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(elementName, element);
        logger.info("A pop-up {} 'You must agree to the terms of service before continuing.' is displayed", elementName);
    }

    @And("user selects a {string}")
    public void userSelectsAProduct(String productName) throws IllegalAccessException {
        WebElement product = ReflectionUtils.getWebElement(productName);
        ScreenshotUtils.takeScreenshotOfElement(productName, product);
        product.click();
        logger.info("User selects a {}", productName);
    }

    @Then("an {string} is displayed")
    public void anInfoCartIsDisplayed(String elementName) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(elementName);
        MatcherAssert.assertThat(element.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(elementName, element);
        logger.info("An {} is displayed", elementName);
    }

    @When("user clicks to {string} button for proceed to checkout")
    public void userClicksToProcessAddressButtonForProceedToCheckout(String buttonName) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(buttonName);
        ScreenshotUtils.takeScreenshotOfElement(buttonName, button);
        button.click();
        logger.info("User clicks {} button ", buttonName);
    }

    @When("user select a {string}")
    public void userSelectAProduct(String elementName) throws IllegalAccessException, InterruptedException {
        WebElement element = ReflectionUtils.getWebElement(elementName);
        hover.moveToElement(element).perform();
        ScreenshotUtils.takeScreenshotOfElement(elementName, element);
        logger.info("User moves the mouse to a {}", elementName);

    }

    @Then("user selects {string}")
    public void userSelectsShoppingCart(String elementName) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(elementName);
        hover.moveToElement(element).perform();
        ScreenshotUtils.takeScreenshotOfElement(elementName, element);
        logger.info("User selects the {}", elementName);
    }

    @And("the {string} is displayed")
    public void theProductNameIsDisplayed(String elementName) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(elementName);
        MatcherAssert.assertThat(element.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement(elementName, element);
        logger.info("The {} is displayed", elementName);

    }

    @And("Add to cart button is to the left of {string} button")
    public void ButtonIsAboveOnTheButton(String buttonName) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(buttonName);
        Browser.getBrowser().findElement(withTagName("span").toLeftOf(button));
        ScreenshotUtils.takeScreenshotOfElement(buttonName, button);


    }
}
