package com.auto.test.browser;

import com.auto.page.browser.GooglePage;
import org.testng.annotations.Test;

public class GoogleTests extends BrowserTestBase {
    private GooglePage googlePage = new GooglePage();

    @Test(testName = "google test", description = "able to search")
    public void TestCase() {
        googlePage.search("Selenium");
    }
}
