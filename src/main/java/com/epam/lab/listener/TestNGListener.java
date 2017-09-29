package com.epam.lab.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    public static final Logger LOGGER = Logger.getLogger(TestNGListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info(iTestResult.getName()+" test case started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("The name of the testcase passed is :" + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("The name of the testcase failed is :" + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("The name of the testcase Skipped is :" + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
