package com.auto.page;


import io.qameta.allure.Step;

public interface IHomePage {
    void open();
    void search(Object keyword);
    void clickLoginButton();
    boolean isDisplayed();
    String getProfileName();
}
