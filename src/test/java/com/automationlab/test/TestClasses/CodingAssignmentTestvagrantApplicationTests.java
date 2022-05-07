package com.automationlab.test.TestClasses;

import com.automationlab.main.MainApplication.CodingAssignmentTestvagrantApplication;
import com.automationlab.main.SetUP.Operations;
import com.automationlab.test.Listeners.ListenerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest(classes = CodingAssignmentTestvagrantApplication.class)
@Listeners(ListenerTest.class)
public class CodingAssignmentTestvagrantApplicationTests extends AbstractTestNGSpringContextTests {
	@Autowired
	public Operations operations;
	@BeforeClass
	public void drierSetup(){
		System.out.println("Launching Browser....");
		operations.SetupDriver("safari");
	}
	@Test(priority = 0)
	public void pageNavigate(){
		operations.getURL("IMDB");
	}
	@AfterTest
	public void tearDownBrowser(){
		operations.tearDown();
	}
}
