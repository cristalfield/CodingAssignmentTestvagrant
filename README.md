# CodingAssignmentTestvagrant
Test Framework using Spring Boot architecture.

Spring boot we used because it helps to inject dependency in easier way.

All the setup and utility classes are available in "com.automationlab.main" package.
All main test classes and properties file are available in "com.automationlab.test" package.

locators.properties => used for storing the locators

pages.properties => used to store url of specific website

testcase.properties => used to store test case name since BDD not used

We used Extent Report for test report generation, and it's available under below folder
###                    "test_output"

Use below command to execute test from command line
####                    mvn clean test

*Note, We couldn't integrate screenshot as the time was short.
