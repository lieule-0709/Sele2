package com.auto.test.browser;

import com.auto.data.enums.Key;
import com.auto.utils.Assertion;
import com.logigear.statics.Selaium;
import com.logigear.utils.ConfigLoader;
import com.logigear.utils.Configuration;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.auto.utils.Constants.CHROME;
import static com.auto.utils.Constants.ConfigFiles;
import static com.auto.utils.Constants.PLAT_FORM;
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
}
