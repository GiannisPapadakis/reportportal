package com.gp.workshop.testng;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


@Slf4j
public class WebListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Started Test " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Successful Test " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("Failed Test " + iTestResult.getName());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("Suite started " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("Suite finished " + iTestContext.getName());
    }

}
