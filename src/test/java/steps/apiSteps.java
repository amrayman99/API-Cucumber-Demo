package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.net.URI;
import org.junit.Assert;

public class apiSteps {

    public apiSteps(){}

    private Scenario scenario;
    private Response response;

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
    }

    @Given("Get Call to {string}")
    public void get_call_to_url(String url) throws Exception {
        RestAssured.baseURI = "http://localhost:3000/";
        RequestSpecification req = RestAssured.given();
        this.response = req.when().get(new URI(url));
    }

    @Then("Response Code = {string}")
    public void response_is_validated(String responseMessage) {
        int responseCode = this.response.then().extract().statusCode();
        Assert.assertEquals(responseMessage, "" + responseCode);
    }
    @And("Name is {string}")
    public void NameIs(String name){
        String actName = this.response.path("name");
        Assert.assertEquals(name,actName);
    }

    @And("Postman ID is {string}")
    public void postManIdIs(String id){
        String actpmID = this.response.path("_postman_id");
        Assert.assertEquals(id,actpmID);
    }

    @And("Schema is {string}")
    public void SchemaIs(String schema){
        String actSchema = this.response.path("schema");
        Assert.assertEquals(schema,actSchema);
    }

    @And("Description is {string}")
    public void DescriptionIs(String description){
        String actDescription = this.response.path("description");
        Assert.assertEquals(description,actDescription);
    }

}
