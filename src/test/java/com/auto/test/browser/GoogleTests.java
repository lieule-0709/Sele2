package com.auto.test.browser;

import com.auto.page.browser.GooglePage;
import com.auto.testng.TestListener;
import com.auto.utils.Assertion;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleTests extends BrowserTestBase {

    private GooglePage googlePage = new GooglePage();

    @Test(testName = "google search test", description = "able to search")
    public void Test_google_search() {
        googlePage.search("Selenium");

//        assertion.assertTrue(false, "Verify user can create new item successfully");

        assertion.assertEquals("aab", "aa", "test");

        assertion.assertAll();
    }
}
