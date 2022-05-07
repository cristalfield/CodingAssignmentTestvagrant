package com.automationlab.test.TestClasses;

import com.automationlab.main.MainApplication.CodingAssignmentTestvagrantApplication;
import com.automationlab.main.SetUP.Operations;
import com.automationlab.test.Listeners.ListenerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@SpringBootTest(classes = CodingAssignmentTestvagrantApplication.class)
@Listeners(ListenerTest.class)
public class CodingAssignmentTestvagrantApplicationTests extends AbstractTestNGSpringContextTests {
	@Autowired
	public Operations operations;


	@BeforeClass
	public void run(){
		operations.SetupDriver("safari").get("https://www.google.com");
		System.out.println("Hello");
	}
	@Test
	public void getResult(){
		System.out.println("Result printed");
	}
}
