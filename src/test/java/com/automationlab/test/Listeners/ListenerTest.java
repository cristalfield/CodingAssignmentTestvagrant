package com.automationlab.test.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("Starting.........\n"+result.getMethod());
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("Success.....\n"+result.getMethod());
    }
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName());
    }
    public void onTestSkipped(ITestResult result) {
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }
    public void onStart(ITestContext context) {
    }
    public void onFinish(ITestContext context) {
    }
}
