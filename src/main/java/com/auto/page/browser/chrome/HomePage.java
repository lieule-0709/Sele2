package com.auto.page.browser.chrome;

import com.auto.page.IHomePage;
import com.logigear.element.Element;
import io.qameta.allure.Step;

public class HomePage implements IHomePage {

    private final Element foodyLogo = new Element("xpath=//a[@alt='foody-logo']");
    private final Element searchTextBox = new Element("name=q");
    private final Element searchButton = new Element("xpath=//div[@id='FoodySearchApp']//span[contains(@class, 'fa fa-search')]");
    private final Element loginButton = new Element("id=accountmanager");
    private final Element profileNameLbl = new Element("className=fname");


    @Step("Open home page")
    public void open() {
//        if (closePopupButton.exists()) {
//            closePopupButton.click();
//        }
    }

    @Step("Enter value to search")
    public void search(Object keyword) {
        searchTextBox.enter(keyword.toString(), true);
        searchButton.click();
    }

    @Step("Click on login button")
    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isDisplayed(){
        return foodyLogo.isDisplayed();
    }

    public String getProfileName(){
        return profileNameLbl.getText();
    }

}
