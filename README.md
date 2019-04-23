# Test Cases:

- [ ] TC1: Verify important information and labels in the Sample application
- [ ] TC2: Verify message upon entering invalid city
- [ ] TC3: Verify weather details displayed upon entering a valid city
- [ ] TC4: Verify weather details displayed upon entering a valid city in top navigation bar

# Prerequisites:
- Java JDK 1.8 should be installed (You can download latest stable version from [here](https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html))
- IDE (Intellij/Eclipse) should be installed

[I'm an inline-style link](https://www.google.com)

# Solution:
- [ ] This BDD framework has been developed using Cucumber and UI test cases automated using Selenium
- [ ] This is a maven project. The project should be imported as a maven project into the respective IDE (Intellij/Eclipse)
- [ ] In the root folder select pom.xml and do import maven dependencies
- [ ] Feature file is defined in folder 
```
openweather_integrationtests(project root folder)
│   README.md 
│
└───src
│   └───test
│       └───resources
│       |   └───testrunner
|       |               VerifyLabels.feature
|       └───java
│           └───testrunner
|                       Stepdefs.java
```
**src/test/resources/testrunner** and respective step definitions in folder **src/test/java/testrunner

- [ ] To execute test cases open any terminal, navigate to the root folder and run following command in terminal:
        `mvn test`
- [ ] The framework has been designed in Page Object Model, however, since most of the test cases pertain to the first page, hence, only one page class has been used.
- [ ] The framework supports cross-browser execution for Chrome and Firefox
- [ ] Change the node value **systemPropertyVariables/browser** in **pom.xml** to **chrome** or **firefox** to execute the tests in respective browser

# TODO:
- [ ] Would have added test execution for Internet Explorer as well
- [ ] Would have added Reporting mechanism using **Extent Report**
- [ ] Would have moved the hard-coded expected labels in method **verifyLabels** of class **OpenWeatherMapPage** to xml/yml file
