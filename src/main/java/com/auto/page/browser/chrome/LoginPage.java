package com.auto.page.browser.chrome;

import com.auto.page.ILoginPage;
import com.logigear.element.Element;
import com.logigear.statics.Selaium;
import io.qameta.allure.Step;

public class LoginPage implements ILoginPage {

    private final Element userNameInput = new Element("id=Email");
    private final Element passwordInput = new Element("id=Password");
    private final Element loginButton = new Element("id=bt_submit");

    @Step("Open Login page")
    public void open() {
        Selaium.driver().getWebDriver().navigate().to("https://id.foody.vn/account/login?returnUrl=https://www.foody.vn/");
    }

    @Step("Login")
    public void login(Object userName, Object password){
        userNameInput.enter(userName.toString());
        passwordInput.enter(password.toString());
        loginButton.click();
    }

}
