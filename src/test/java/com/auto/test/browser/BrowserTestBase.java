package com.auto.test.browser;

import com.auto.utils.Assertion;
import com.logigear.statics.Selaium;
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

@Listeners(com.auto.testng.TestListener.class)
public class BrowserTestBase {
    protected Assertion assertion;
    private static final Logger log = LoggerFactory.getLogger(BrowserTestBase.class);
    Configuration config;

    @BeforeClass
    @Parameters("platform")
    public void beforeAll(@Optional String platform) {
        platform = java.util.Optional.ofNullable(platform).orElse("chrome");
        log.info("Running test on {}", platform);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        config = Configuration.defaultConfig(platform);
        config.setStartMaximized(true);
        config.setBaseUrl("https://www.google.com");
        config.setCapabilities(options);
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
