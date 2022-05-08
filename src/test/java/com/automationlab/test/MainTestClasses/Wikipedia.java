package com.automationlab.test.MainTestClasses;

import com.automationlab.main.Reports.ExtentReportTest;
import com.automationlab.main.SetUP.Operations;
import com.automationlab.main.Utilities.LoadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
public class Wikipedia {
    @Autowired
    public ExtentReportTest extentReportTest;
    @Autowired
    public Operations operations;
    @Autowired
    public LoadProperties loadProperties;
    public String wikipediaTestBase(){
        extentReportTest.createTestCase(loadProperties.getProps().getProperty("WIKIPEDIA_TEST"));
        extentReportTest.infoTest("User entered Wikipedia url");
        operations.getURL("WIKIPEDIA");
        String expected="Wikipedia, the free encyclopedia";
        if(operations.getPageTitle().equals(expected)){
            extentReportTest.passedTest("Wikipedia website launched successfully");
            Assert.assertEquals(operations.getPageTitle(),expected);
        }else {
            extentReportTest.failedTest("Website Title not expected : "+operations.getPageTitle());
            Assert.assertEquals(operations.getPageTitle(),expected);
        }
        extentReportTest.infoTest("Searching with Pushpa movie in Search Box");
        operations.getElement("WIKIPEDIASEARCH_ID").sendKeys("pushpa");
        operations.implicitWait();
        operations.getElement("WIKISUGGESTION_XPATH").click();
        extentReportTest.passedTest("Pushpa movie selected from Suggestion dropdown.");
        operations.implicitWait();
        extentReportTest.infoTest("Getting information about Release Date");
        String releaseDate=operations.getElement("WIKITABLEDATE_XPATH").getText();
        String countryName=operations.getElement("WIKITABLECOUNTRY_XPATH").getText();
        String releaseDateCountry=releaseDate.concat(" "+"("+countryName+")");
        extentReportTest.passedTest("Release Date is : "+releaseDateCountry);
        return releaseDateCountry;
    }
}
