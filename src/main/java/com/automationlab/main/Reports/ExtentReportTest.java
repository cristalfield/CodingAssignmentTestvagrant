package com.automationlab.main.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.springframework.stereotype.Component;

@Component
public class ExtentReportTest {
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    public void startExtentReport(){
        extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test_output/report.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }
    public void createTestCase(String testName){
        extentTest=extentReports.createTest(testName);
    }
    public void passedTest(String testName){
        extentTest.log(Status.PASS,testName);
    }
    public void failedTest(String testName){
        extentTest.log(Status.FAIL,testName);
    }
    public void infoTest(String infoDetails){
        extentTest.info(infoDetails);
    }
    public void generateReport(){
        extentReports.flush();
    }
}
