package com.auto.report;

import com.logigear.statics.Selaium;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

import static com.auto.utils.DateTimeHelper.currentDateTime;

public class StepListener implements StepLifecycleListener {

    private static final Logger log = LoggerFactory.getLogger(StepListener.class);

    @Override
    public void beforeStepStart(StepResult result) {
        log.info("[Step]: " + result.getName() + " is starting");
    }

    @Override
    public void beforeStepStop(final StepResult result) {

        if (result.getStatus().equals(Status.FAILED) || result.getStatus().equals(Status.BROKEN) && Selaium.driverContainer().isAlive()) {
            log.info("[Failed]: Taking screenshot...");
            ByteArrayInputStream input = new ByteArrayInputStream(Selaium.takeScreenShot(OutputType.BYTES));
            Allure.addAttachment(String.format("Screenshot %s:", currentDateTime()), input);
        }

    }

    @Override
    public void afterStepStop(StepResult result) {
        log.info("[Step]: " + result.getName() + " ended");
    }

}
