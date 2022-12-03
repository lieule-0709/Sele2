package com.auto.page.imp.chrome;

import com.auto.data.enums.Navigation;
import com.auto.page.IGoogleHomePage;
import com.logigear.element.Element;
import io.qameta.allure.Step;

public class GoogleHomePage implements IGoogleHomePage {
    private final Element searchTextBox = new Element("name=q");

    @Step("Enter value to search")
    public void search(String keyword) {
        searchTextBox.enter(keyword);
    }

    @Override
    public void openPage(Navigation subPage) {

    }
}
