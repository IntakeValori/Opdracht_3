package stepdefinitions;


import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class APIStepDefinitions {

    private WebDriver driver;
    private Response response;

    public APIStepDefinitions(){this.driver=DriverManager.driver;}


    @When("I create get request from {string}")
    public void i_create_get_request_from(String url) {
        response= given().accept(ContentType.JSON).
                           and().
                           when().
                           get(url);

    }
    @And("Verify the status code is {int}")
    public void verify_the_status_code_is(Integer statusCode) {
        Integer actualStatusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,actualStatusCode);

    }

    @And("Verify the content type is {string}")
    public void verifyTheContentTypeIs(String contentType) {
        String actualContentType=response.contentType();
        Assert.assertEquals(contentType,actualContentType);
    }

    @Then("Fill the contact form with the data comes from given API")
    public void fill_the_contact_form_with_the_data_comes_from_given_api() {
        String firstName = response.body().path("results[0].name.first");
        String lastName = response.body().path("results[0].name.last");
        String telephoneNumber = response.body().path("results[0].phone");
        String eMail = response.body().path("results[0].email");

        Map<String,String> randomUser=new HashMap<>();
        randomUser.put("FirstName",firstName);
        randomUser.put("LastName",lastName);
        randomUser.put("CompanyName","");
        randomUser.put("TelephoneNumber",telephoneNumber);
        randomUser.put("EMail",eMail);
        randomUser.put("Message","There is no message!!!");

        ContactUsPage contactUsPage=new ContactUsPage(driver);
        contactUsPage.fillContactUsForm(randomUser);

    }


}

