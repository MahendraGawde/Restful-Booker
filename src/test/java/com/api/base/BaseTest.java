package com.api.base;

import com.api.actions.AssertActions;
import com.api.modules.PayloadManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

import static com.api.endpoints.APIConstants.BASE_URL;

public class BaseTest{
    public RequestSpecification requestSpecification;
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
        /*requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();*/
    }

    public String testGetToken() throws JsonProcessingException {


        requestSpecification = RestAssured.given().baseUri(BASE_URL).basePath("/auth");
        String payload = payloadManager.setToken();
        response = requestSpecification.contentType(ContentType.JSON)
                .body(payload).when().post();

        jsonPath = new JsonPath(response.asString());
        return jsonPath.getString("token");


    }
}
