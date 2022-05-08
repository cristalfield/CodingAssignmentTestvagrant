package com.automationlab.test.TestClasses;

import com.automationlab.main.MainApplication.CodingAssignmentTestvagrantApplication;
import com.automationlab.main.Reports.ExtentReportTest;
import com.automationlab.main.SetUP.Operations;
import com.automationlab.test.MainTestClasses.CompareDate;
import com.automationlab.test.MainTestClasses.IMDB;
import com.automationlab.test.MainTestClasses.Wikipedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SpringBootTest(classes = {CodingAssignmentTestvagrantApplication.class,
		CodingAssignmentTestvagrantApplicationTests.class})
@ComponentScan("com.automationlab.test")
public class CodingAssignmentTestvagrantApplicationTests extends AbstractTestNGSpringContextTests {
	@Autowired
	public Operations operations;
	@Autowired
	public ExtentReportTest extentReportTest;
	@Autowired
	public IMDB imdb;
	@Autowired
	public Wikipedia wikipedia;
	@Autowired
	public CompareDate compareDate;
	public String imdbString;
	public String wikipediaString;
	@BeforeClass
	public void drierSetup(){
		extentReportTest.startExtentReport();
		operations.SetupDriver("chrome");
	}
	@Test(priority = 0)
	public void IMDBTest(){
		imdbString=imdb.IMDBTestBase();
	}
	@Test(priority = 1)
	public void wikipediaTest(){
		wikipediaString=wikipedia.wikipediaTestBase();
	}
	@Test(priority = 2)
	public void matchDate(){
		compareDate.compareTwoDate(imdbString,wikipediaString);
	}
	@AfterClass
	public void tearDownBrowser(){
		extentReportTest.generateReport();
		operations.tearDown();
	}
}
