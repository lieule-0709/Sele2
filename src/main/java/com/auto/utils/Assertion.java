package com.auto.utils;

import com.auto.report.AllureReport;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Assertion {
    SoftAssert softAssert;

    public Assertion() {
        softAssert = new SoftAssert();
    }

    public void assertTrue(boolean condition, String message) {
        softAssert.assertTrue(condition, message);

        if (condition) {
            Allure.step(message);
        } else {
            Allure.step(message, Status.FAILED);
        }
    }

    public void assertFalse(boolean condition, String message) {
        softAssert.assertFalse(condition, message);

        if (condition) {
            Allure.step(message, Status.FAILED);
        } else {
            Allure.step(message);
        }
    }

    public void assertEquals(Object actual, Object expected, String message) {
        softAssert.assertEquals(actual, expected, message);

        if (actual.equals(expected)) {
            Allure.step(message);
        } else {
            Allure.step(message, Status.FAILED);
        }
    }

    public void assertAll() {
        softAssert.assertAll();
    }

}
