

## Getting Started
You need to have installed:

* [Maven](https://maven.apache.org/) - Dependency Management
* [IntelliJ](https://www.jetbrains.com/idea/download/) - IDE
* [Java 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) - JDK
* [Chrome](https://www.google.com/intl/nl_ALL/chrome/) - Browser
* The Cucumber for Java plugin within IntelliJ  - Go to settings under file, select plugins, browser repositories
  and search for Cucumber for Java. Install and restart the IDE
* Gherkin plugin within IntelliJ - Same steps as above.

```
Open the POM.xml as a project in IntelliJ
Within the src/test -> resources folder you will find the cucumber feature NavigateValoriWebsite.feature
Within the src/test/java/runner you will find the test runner. Right click and select run to run the tests.
In target/cucumber-reports you will find the report generated by the runners.

If you have the cucumber for java plugin installed you can also just right click the individual feature files and select Run.
```

## Exercise 1

```
Create a new branch and include your name within the branch name.
Within the project you will find 2 scenario's within the feature NavigateValoriWebsite.
You will find that both scenario's are not working.
One test is failing because of content changes.
The second test still needs its final step code to be implemented.

Make both tests pass.
Don't forget, we are not judging you on code alone !
Remember to implement validations and make sure you leave the
project in a nicer state then you have found it :)

Push your code to your branch.
Create a pull request.
Do not merge to master.
Good luck and have fun !

```

## Exercise 2
If you already have plenty of experience in test automation, or are up for a challenge
```
Create a third test.
Re-use as many steps as you can.
This test must use a scenario outline or datatable (or both).
Pick the option you think is most suitable for the situation.
See the references at the bottom of the page.

The goal for this test is to be data-driven and fill the form multiple times without scenario duplication.
Be careful not to submit the form!
We are testing in production right now and..
We don't want to spam our future colleagues now would we ?

Make sure the test fills the contact us form at least once with only the mandatory fields
And then runs another time to fill all of the fields of the form

```
* [Reference 1](https://cucumber.io/docs/gherkin/reference/#scenario-outline) - Scenario outline documentation
* [Reference 2](https://cucumber.io/docs/gherkin/reference/#data-tables) - Data tables documentation
