# grocery-admin-automation-framework

UI automation framework for a grocery admin web application, built with Selenium WebDriver, Java and TestNG.

##What it covers
-Page Object Model structure with PageFactory
-Data-driven test execution using Apache POI
-TestNG suite with reporting
-Maven build, with Jenkins CI/CD integration

##How to run
1.Clone the repo
2.mvn clean test
3.Reports generated under test-output/

##Key result
The regression suite runs in parallel across TestNG threads. Moving to parallel execution cut runtime significantly, after fixing a WebDriver thread-safety issue where shared driver instances caused browser conflicts between tests.
Author
Ashna P, QA Automation Tester
