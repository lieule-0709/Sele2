package com.auto.test.browser;

import com.auto.data.enums.Key;
import com.auto.utils.Assertion;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.logigear.statics.Selaium;
import com.logigear.utils.ConfigLoader;
import com.logigear.utils.Configuration;
import jdk.nashorn.internal.runtime.Context;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;

import static com.auto.utils.Constants.AUTO_TEST_FOLDER;
import static com.auto.utils.Constants.CHROME;
import static com.auto.utils.Constants.ConfigFiles;
import static com.auto.utils.Constants.PLAT_FORM;
import static com.auto.utils.JsonUtils.jsonArrayToObjectArray;
import static com.auto.utils.PropertiesHelper.getProperty;

@Listeners(com.auto.testng.TestListener.class)
public class BrowserTestBase {
    protected Assertion assertion;
    private static final Logger log = LoggerFactory.getLogger(BrowserTestBase.class);
    Configuration config;

    @BeforeClass
    public void beforeAll() {
        log.info("Running test on {}", PLAT_FORM);

        config = ConfigLoader.fromJsonFile(ConfigFiles.get(PLAT_FORM));
        Selaium.setConfig(config);

        Selaium.open("");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTestCase() {
        assertion = new Assertion();
    }

    @AfterClass
    public void afterAll() {
        Selaium.closeWebDriver();
    }

    @DataProvider()
    public Object[][] getDataForTest(ITestNGMethod context) {
        String DataFilePath = AUTO_TEST_FOLDER + this.getClass().getPackage().getName().replace(".", "/") + "/data.json";
        Object[][] data = getData(String.format("%s_%s", this.getClass().getSimpleName(), context.getMethodName()), DataFilePath);
        return data;
    }

    public static Object[][] getData(String testName, String dataFilePath) {
        //Read json file data using Gson library
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(dataFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonObject jsonObject = new Gson().fromJson(br, JsonObject.class);

        //Get test data for the specific test case
        JsonArray jsonArray = jsonObject.getAsJsonArray(testName);
        Object[][] data = jsonArrayToObjectArray(jsonArray);
        return data;
    }
}
