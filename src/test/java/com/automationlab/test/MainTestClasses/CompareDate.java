package com.automationlab.test.MainTestClasses;

import com.automationlab.main.Reports.ExtentReportTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.Objects;

@Component
public class CompareDate {
    @Autowired
    public ExtentReportTest extentReportTest;
    public void compareTwoDate(String date1,String date2){
        String[] first=date1.split(" ",5);
        String[] second=date2.split(" ",5);
        System.out.println(first.length);
        int flag=0;
        for (String s : first) {
            for (String value : second) {
                if (Objects.equals(s, value)) {
                    flag++;
                }
            }
        }
        extentReportTest.createTestCase("Verification Test");
        extentReportTest.infoTest("Validating the dates");
        if(flag==4){
            extentReportTest.passedTest("Both Release dates are same: "+date1+","+date2);
            Assert.assertTrue(true);
        }else {
            extentReportTest.failedTest("Both Release dates are not same :"+date1+","+date2);
            Assert.fail("Release date not same");
        }
    }
}
