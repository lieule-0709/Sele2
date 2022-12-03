package com.auto.test.browser;

import com.auto.page.browser.GooglePage;
import com.auto.testng.TestListener;
import com.auto.utils.Assertion;
import com.google.gson.JsonObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleTests extends BrowserTestBase {

    private GooglePage googlePage = new GooglePage();

    @Test(testName = "google search test", description = "able to search")
    public void Test_google_search() {
        googlePage.search("Selenium");

        assertion.assertTrue(false, "Verify true failed");
        assertion.assertTrue(true, "Verify true passed");

        assertion.assertEquals("aa", "aa", "Verify string equal pass");
        assertion.assertEquals("a", "aa", "Verify string equal failed");

        assertion.assertNotEquals("a", "aa", "Verify string not equal pass");
        assertion.assertEquals("aa","aa", "Verify string not equal failed");

        assertion.assertNull(null, "Verify null passed");
        assertion.assertNull("true", "Verify null failed");

        assertion.assertNotNull("fdf", "Verify not null passed");
        assertion.assertNotNull(null, "Verify not null failed");

        assertion.assertAll();
    }
}
