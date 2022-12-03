package com.auto.utils;

import com.auto.data.enums.Key;

import java.util.HashMap;
import java.util.Map;

import static com.auto.utils.PropertiesHelper.getProperty;

public class Constants {
    public static final Map<String, String> ConfigFiles = new HashMap<>();
    public static final String ENV_ALLURE_FILE = "allure-results/environment.properties";

    public static final String CHROME = "chrome";
    public static final String CHROME_HEADLESS = "chromeHeadless";
    public static final String ACCOUNT = "account";

    public static final int LOADING_TIME = 5;
    public static final int LONG_TIME = 60;

    public static final String PLAT_FORM = getProperty(Key.PLAT_FORM);

    public static final String PROPERTIES_FILE = "src/test/resources/configuration.properties";

    static {
        ConfigFiles.put(ACCOUNT, "src/test/resources/data/accounts.json");
        ConfigFiles.put(CHROME, "src/test/resources/data/chrome.json");
        ConfigFiles.put(CHROME_HEADLESS, "src/test/resources/data/chromeHeadless.json");
    }
}
