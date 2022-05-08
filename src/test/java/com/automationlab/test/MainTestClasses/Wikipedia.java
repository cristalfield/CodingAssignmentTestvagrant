package com.automationlab.test.MainTestClasses;

import com.automationlab.main.Reports.ExtentReportTest;
import com.automationlab.main.SetUP.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Wikipedia {
    @Autowired
    public ExtentReportTest extentReportTest;
    @Autowired
    public Operations operations;
    public void wikipediaTestBase(){
        extentReportTest.createTestCase("Wikipedia Test");
        operations.getURL("WIKIPEDIA");
        operations.getElement("WIKIPEDIASEARCH_ID").sendKeys("pushpa");
        operations.implicitWait();
        operations.getElement("WIKISUGGESTION_XPATH").click();
        operations.implicitWait();
        System.out.println(operations.getElement("WIKITABLEDATE_XPATH").getText());
        System.out.println(operations.getElement("WIKITABLECOUNTRY_XPATH").getText());
    }
}
