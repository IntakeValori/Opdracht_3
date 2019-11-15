

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
Within the src/test/java/runner you will find the test runner. Right click adn select run to run the tests
In target/cucumber-reports you will find the report generated by the runners.

If you have the cucumber for java plugin installed you can also just
right click the individual featurefiles and select Run
```

## Exercise

```
Create a new branch and include your name within the branch name
Within the project you will find 2 scenario's within the feature NavigateValoriWebsite
You will find that both scenario's are not working.
One test is failing because of content changes.
The second test still needs its final step code to be implemented

Make both tests pass.
Don't forget, we are not judging you on code alone !
Remember to implement validations and make sure you leave the
project in a nicer state then you have found it :)

Push your code to your branch
Create a pull request
Do not merge to master
Goodluck and have fun !

```