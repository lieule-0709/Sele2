package com.auto.page.browser;

import com.logigear.element.Element;
import io.qameta.allure.Step;

public class GoogleHomePage {
    private final Element searchTextBox = new Element("name=q");

    @Step("Enter value to search")
    public void search(String keyword) {
        searchTextBox.enter(keyword);
    }
}
