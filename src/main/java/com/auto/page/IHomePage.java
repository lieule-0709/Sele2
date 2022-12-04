package com.auto.page;


import io.qameta.allure.Step;

public interface IHomePage {

    @Step("Open home page")
    void open();

    @Step("Enter value to search")
    void search(Object keyword);

}
