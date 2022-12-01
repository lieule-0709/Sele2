package com.auto.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Map<String, String> ConfigFiles = new HashMap<>();
    public static final String ENV_ALLURE_FILE = "allure-results/environment.properties";

    public static final String CHROME = "chrome";
    public static final String ACCOUNT = "account";

    public static final int LOADING_TIME = 5;
    public static final int LONG_TIME = 60;

    static {
        ConfigFiles.put(ACCOUNT, "src/test/resources/data/accounts.json");
    }
}
