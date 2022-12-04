package com.auto.page.browser.chrome;

import com.auto.page.IHomePage;
import com.logigear.element.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final Element acceptCookieButton = new Element("xpath=//span[.='Continue']");
    private final Element searchTextBox = new Element("name=keywords");

    public void open(){
        if(acceptCookieButton.isDisplayed()){
            acceptCookieButton.click();
        }
    }

    public void search(Object keyword) {
        searchTextBox.waitForExist();
        Boolean a = searchTextBox.exists();
        searchTextBox.enter(keyword.toString(), true);
    }

}
