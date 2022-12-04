package com.auto.test.browser;

import com.auto.page.IHomePage;
import com.auto.page.PageFactory;
import com.auto.page.browser.chrome.HomePage;
import com.auto.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class GoogleTests extends TestBase {

    private HomePage homePage = new HomePage();

    @Test(dataProvider = "getDataForTest", testName = "Enter value to search", description = "able to search")
    public void test_search(Hashtable data) {
        int a = 1;
        homePage.open();
        homePage.search(data.get("keywords"));

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

//    private UserModel user;
//    private ILoginPage loginPage;
//
//
//    @Test(description = "Able to create new item")
//    public void C14580() {
//        // 1. Login to system
//        loginPage.login(user);
//
//        // 2. Open items page
//    }
//
//    @BeforeClass
//    public void before() {
//        homePage = PageFactory.getHomePage();
//    }
//
//    @AfterClass
//    public void after() {
//        // Do somethings
//    }
}
