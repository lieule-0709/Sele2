package com.auto.testng;

import com.auto.utils.Constants;
import com.auto.utils.ExecutionContext;
import com.auto.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Properties;


public class TestListener implements ITestListener {

    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        log.info("Tests started on {}", Constants.PLAT_FORM);
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test case \"{} - {}\" is started", result.getMethod().getMethodName(),
                result.getMethod().getDescription());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Add Environment information to Allure report
        Properties properties = new Properties();
        properties.putAll(ExecutionContext.getEnvironments());
        FileUtils.savePropertiesToFile(properties, Constants.ENV_ALLURE_FILE);
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

}

