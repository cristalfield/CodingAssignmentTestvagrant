package com.automationlab.main.MainApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.automationlab.main")
public class CodingAssignmentTestvagrantApplication {
	public static void main(String[] args) {
		SpringApplication.run(CodingAssignmentTestvagrantApplication.class, args);
	}

}
