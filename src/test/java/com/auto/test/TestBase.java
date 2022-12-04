package com.auto.test;

import com.auto.utils.Assertion;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.logigear.statics.Selaium;
import com.logigear.utils.ConfigLoader;
import com.logigear.utils.Configuration;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.auto.utils.Constants.AUTO_TEST_FOLDER;
import static com.auto.utils.Constants.ConfigFiles;
import static com.auto.utils.Constants.PLAT_FORM;
import static com.auto.utils.JsonUtils.jsonArrayToObjectArray;

@Listeners(com.auto.testng.TestListener.class)
public class TestBase {
    protected Assertion assertion;
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);
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
        if (jsonArray != null) {
            Object[][] data = jsonArrayToObjectArray(jsonArray);
            return data;

        } else {
            log.info("[Skip]: No test data found for {}", testName);
            return new Object[0][];
        }
    }
}
