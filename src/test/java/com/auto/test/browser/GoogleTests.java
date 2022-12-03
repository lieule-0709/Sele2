package com.auto.test.browser;

import com.auto.page.browser.GoogleHomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class GoogleTests extends BrowserTestBase {

    private GoogleHomePage googleHomePage = new GoogleHomePage();

    @Test(dataProvider = "getDataForTest", testName = "google search test", description = "able to search")
    public void Test_google_search(Hashtable data) {
        googleHomePage.search("Selenium");

        assertion.assertTrue(false, "Verify true failed");
        assertion.assertTrue(true, "Verify true passed");

        assertion.assertEquals("aa", "aa", "Verify string equal pass");
        assertion.assertEquals(data.get("test"), "aa", "Verify string equal failed");

        assertion.assertNotEquals("a", "aa", "Verify string not equal pass");
        assertion.assertEquals("aa","aa", "Verify string not equal failed");

        assertion.assertNull(null, "Verify null passed");
        assertion.assertNull("true", "Verify null failed");

        assertion.assertNotNull("fdf", "Verify not null passed");
        assertion.assertNotNull(null, "Verify not null failed");

        assertion.assertAll();
    }
}
