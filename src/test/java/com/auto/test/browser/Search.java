package com.auto.test.browser;

import com.auto.page.IHomePage;
import com.auto.page.PageFactory;
import com.auto.page.browser.chrome.HomePage;
import com.auto.test.TestBase;
import com.auto.utils.Assertion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Search extends TestBase {

    private IHomePage homePage;

    @Test(dataProvider = "getDataForTest", testName = "Enter value to search", description = "able to search")
    public void C01_Search(Hashtable data) {
        homePage.open();
        assertion.assertTrue(homePage.isDisplayed(), "VP: Verify home page is displayed");

        homePage.search(data.get("keywords"));
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
    @BeforeClass
    public void before() {
        homePage = PageFactory.getHomePage();
    }

//
//    @AfterClass
//    public void after() {
//        // Do somethings
//    }
}
