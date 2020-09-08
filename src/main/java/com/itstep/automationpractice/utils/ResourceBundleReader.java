package com.itstep.automationpractice.utils;

import java.util.ResourceBundle;

public class ResourceBundleReader {
    private static ResourceBundle resourceBundle;

    public ResourceBundleReader() {
        resourceBundle = ResourceBundle.getBundle("application");

    }

    public static ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            new ResourceBundleReader();
        }
        return resourceBundle;
    }
}

