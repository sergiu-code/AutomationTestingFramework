package com.itstep.automationpractice.utils;

import com.itstep.automationpractice.pages.AbstractPage;
import com.itstep.automationpractice.selenium.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unchecked")
public class ReflectionUtils {


    public static WebElement getWebElement(String fieldName) throws IllegalAccessException {

        AbstractPage pageObject = (AbstractPage) ScenarioContext.getContext(ScenarioDataKey.CURRENT_PAGE.name());
        fieldName = fieldName.replace(" ", "");

        for (Field field : pageObject.getClass().getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase(fieldName)) {
                field.setAccessible(true);
                return (WebElement) field.get(pageObject);
            }
        }
        throw new RuntimeException("WebElement " + fieldName + " is not found in " + pageObject.getClass());
    }

    public static AbstractPage getPageObject(String pageName)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        pageName = pageName.replace(" ", "");
        Class < ? extends AbstractPage > pageClazz = (Class < ? extends AbstractPage >) Class.forName("com.itstep.automationpractice.pages." + pageName);
        return pageClazz.getConstructor(WebDriver.class).newInstance(Browser.getBrowser());
    }

}
