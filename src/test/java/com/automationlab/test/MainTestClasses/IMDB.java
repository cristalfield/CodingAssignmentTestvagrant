package com.automationlab.test.MainTestClasses;

import com.automationlab.main.Reports.ExtentReportTest;
import com.automationlab.main.SetUP.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;
@Component
public class IMDB {
    @Autowired
    public ExtentReportTest extentReportTest;
    @Autowired
    public Operations operations;
    public void IMDBTestBase(){
        extentReportTest.createTestCase("User able to fetch Pushpa Movie details from IMDB website successfully");
        extentReportTest.infoTest("User entered IMDB url");
        operations.getURL("IMDB");
        String expected="IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
        if(operations.getPageTitle().equals(expected)){
            extentReportTest.passedTest("IMDB website launched successfully");
            Assert.assertEquals(operations.getPageTitle(),expected);
        }else {
            extentReportTest.failedTest("Website Title not expected : "+operations.getPageTitle());
            Assert.assertEquals(operations.getPageTitle(),expected);
        }
        extentReportTest.infoTest("Searching with Pushpa movie in Search Box");
        operations.getElement("SEARCH_ID").sendKeys("pushpa");
        operations.implicitWait();
        operations.getElement("SUGGESTION_XPATH").click();
        extentReportTest.passedTest("Pushpa movie selected from Suggestion dropdown.");
        extentReportTest.infoTest("Getting information about Release Date");
        extentReportTest.passedTest("Release Date is : "+operations.getElement("RELEASE_XPATH").getText());
    }
}
