package com.auto.test.browser;

import com.auto.page.IHomePage;
import com.auto.page.ILoginPage;
import com.auto.page.PageFactory;
import com.auto.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Login extends TestBase {

    private IHomePage homePage;
    private ILoginPage loginPage;

    @BeforeClass
    public void before() {
        homePage = PageFactory.getHomePage();
        loginPage = PageFactory.getLoginPage();
    }

    @Test(dataProvider = "getDataForTest", testName = "Enter value to search", description = "Login successfully")
    public void C02_Login(Hashtable data) {
        homePage.open();
        homePage.clickLoginButton();

        loginPage.login(data.get("userName"), data.get("password"));

        assertion.assertEquals(homePage.getProfileName(), data.get("profileName"), "VP: Verify user can login successfully");

        assertion.assertAll();
    }

}
