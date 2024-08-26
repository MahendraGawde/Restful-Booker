package com.api.base;

import com.api.actions.AssertActions;
import com.api.modules.PayloadManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import static com.api.endpoints.APIConstants.BASE_URL;

public class BaseTest{
    public RequestSpecification requestSpecification;
    public ResponseSpecification responseSpecification;
    public RequestSpecBuilder reqBuilder;
    public ResponseSpecBuilder resBuilder;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setUp(){
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        //Method 1
        requestSpecification = RestAssured.given()
                    .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
        //Method2
        /*reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(BASE_URL).addHeader("Content-Type", "application/json");
        requestSpecification = reqBuilder.build();

        resBuilder = new ResponseSpecBuilder();
        resBuilder.expectStatusCode(200)
                .expectContentType(ContentType.JSON);
        responseSpecification = resBuilder.build();*/
    }

    public String testGetToken() throws JsonProcessingException {


        requestSpecification = RestAssured.given().spec(requestSpecification).basePath("/auth");
        String payload = payloadManager.setToken();
        response = requestSpecification.contentType(ContentType.JSON)
                .body(payload).when().post();

        //Apply response specification to validate the response.
        validatableResponse = response.then().spec(responseSpecification);


        //Extract token from validated response.
        jsonPath = new JsonPath(validatableResponse.extract().asString());
        return jsonPath.getString("token");


    }
}
