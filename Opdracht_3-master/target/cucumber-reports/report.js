$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/featurefiles/NavigateValoriWebsite.feature");
formatter.feature({
  "name": "Test navigation on the valori.nl homepage",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a user I can navigate the website to read about the Mobile Chapter",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Valori homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.iAmOnTheValoriHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the Mobile Chapter page",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.iNavigateToTheMobileChapterPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can read articles about the Mobile Chapter",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.iCanReadAboutMobileChapter()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "As a user I can navigate to the contact form from the Mobile page",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Valori homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.iAmOnTheValoriHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the Mobile Chapter page",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.iNavigateToTheMobileChapterPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I contact Valori",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.iContactValori()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the contact us form is available",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.theContactUsFormIsAvailable()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});