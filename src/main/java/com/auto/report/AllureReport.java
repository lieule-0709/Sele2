package com.auto.report;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

public class AllureReport {

    public static void testStep(boolean condition, String message){
        if (condition) {
            Allure.step(message, Status.PASSED);
        } else {
            Allure.step(message, Status.FAILED);
        }
    }

}
