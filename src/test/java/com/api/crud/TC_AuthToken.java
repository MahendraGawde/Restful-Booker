package com.api.crud;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_AuthToken {

    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    @Test
    public void createAuthToken(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth")
                .contentType(ContentType.JSON)
                .body(payload)
                        .when().post()
                        .then().log().all().statusCode(200);

    }
}
