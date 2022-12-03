package com.auto.utils;

import com.auto.report.AllureReport;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Set;


public class Assertion {
    SoftAssert softAssert;

    public Assertion() {
        softAssert = new SoftAssert();
    }

    public void assertTrue(boolean condition, String message) {
        softAssert.assertTrue(condition, message);
        AllureReport.testStep(condition, message);
    }

    public void assertFalse(boolean condition, String message) {
        softAssert.assertFalse(condition, message);
        AllureReport.testStep(!condition, message);
    }

    public void assertEquals(Object actual, Object expected, String message) {
        softAssert.assertEquals(actual, expected, message);
        AllureReport.testStep(compareJson(actual, expected), message);
    }

    public void assertNotEquals(Object actual, Object expected, String message) {
        softAssert.assertEquals(actual, expected, message);
        AllureReport.testStep(!compareJson(actual, expected), message);
    }

    public void assertNull(Object object, String message) {
        softAssert.assertNull(object, message);
        AllureReport.testStep(object == null, message);
    }

    public void assertNotNull(Object object, String message) {
        softAssert.assertNotNull(object, message);
        AllureReport.testStep(object != null, message);
    }

    public static boolean compareJson(Object a, Object b) {
        if (a instanceof JSONObject && b instanceof JSONObject) {
            JSONObject a1 = (JSONObject) a;
            JSONObject b1 = (JSONObject) b;
            Set<String> keyA = a1.keySet();
            Set<String> keyB = b1.keySet();
            if (!keyA.equals(keyB))
                return false;
            for (String key : keyA) {
                if (!compareJson(b1.get(key), a1.get(key)))
                    return false;
            }
            return true;
        } else if (a instanceof JSONArray && b instanceof JSONArray) {
            JSONArray a1 = (JSONArray) a;
            JSONArray b1 = (JSONArray) b;
            if (a1.length() != b1.length())
                return false;
            for (int i = 0; i < a1.length(); i++) {
                if (!compareJson(b1.get(i), a1.get(i)))
                    return false;
            }
            return true;
        } else if (a instanceof String && b instanceof String) {
            String a1 = (String) a;
            String b1 = (String) b;
            return a1.equalsIgnoreCase(b1);
        } else
            return a.equals(b);
    }

    public void assertAll() {
        softAssert.assertAll();
    }

}
