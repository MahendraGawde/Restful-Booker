package com.api.crud;

import com.api.base.BaseTest;
import com.api.endpoints.APIConstants;
import com.api.payloads.requestpayload.Booking;
import com.api.payloads.responsepayload.BookingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.equalTo;

public class TC_IntegrationTest extends BaseTest {
    // Create auth token
    String token;
    String bookingIdJson;
    String bookingIdFromPojo;


    // Create booking
    @Test(groups = "QA")
    public void testCreateBooking() throws JsonProcessingException {

        token = testGetToken();
        System.out.println("token: " +token);
        assertThat(token).isNotNull().isNotEmpty();

        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();

        jsonPath = JsonPath.from(response.asString());
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname",equalTo("Vikas"));

        //Extract booking id from Jsonpath
        bookingIdJson = jsonPath.getString("bookingid");

        //Booking Response class extracting booking id
        BookingResponse bookingResponse = payloadManager.jsonToPojo(response.asString());
        bookingIdFromPojo = bookingResponse.getBookingid().toString();

        System.out.println("Booking Id from Jsonpath: " +bookingIdJson);
        System.out.println("<-------------------->");
        System.out.println("Booking Id from POJO: " +bookingIdFromPojo);

        assertThat(bookingIdJson).isNotNull().isNotEmpty();


    }

    // Update booking
    @Test(groups = "QA",dependsOnMethods = {"testCreateBooking"})
    public void testPutUpdateBooking() throws JsonProcessingException {
        System.out.println("Put Request token: " +token);
        System.out.println("Booking id PUT Json: " +bookingIdJson);
        System.out.println("Booking id PUT Booking response: "  +bookingIdFromPojo);

        requestSpecification.basePath(APIConstants.UPDATE_BOOKING + "/" +bookingIdJson);
        response =RestAssured.given().spec(requestSpecification).cookie("token",token)
                .when().body(payloadManager.updatePayload()).put();
        validatableResponse = response.then().log().all();
        validatableResponse.body("firstname", Matchers.is("Kriti"));

        //Validating Response fields
        Booking bookingUpdateResponse = payloadManager.jsonToPojoPUT(response.asString());
        assertThat(bookingUpdateResponse.getFirstname()).isEqualTo("Kriti").isNotNull();
        assertThat(bookingUpdateResponse.getLastname()).isEqualTo("Sanon").isNotEmpty();
        assertThat(bookingUpdateResponse.getDepositpaid()).isEqualTo(true).isNotNull();
        assertThat(bookingUpdateResponse.getTotalprice()).isEqualTo(2005).isNotNull();
        assertThat(bookingUpdateResponse.getBookingdates().getCheckin()).isNotEmpty();
        assertThat(bookingUpdateResponse.getBookingdates().getCheckout()).isNotEmpty();



    }
    //Delete booking
    @Test(groups = "QA", dependsOnMethods = {"testPutUpdateBooking"})
    public void testDeleteBooking(){
        System.out.println("Delete Request token: " +token);
        System.out.println("Booking id DELETE Json: " +bookingIdJson);
        System.out.println("Booking id DELETE Booking response: " +bookingIdFromPojo);


        requestSpecification.basePath(APIConstants.UPDATE_BOOKING + "/" +bookingIdJson).cookie("token",token);
        ValidatableResponse validatableResponse =RestAssured.given()
                .spec(requestSpecification).auth().basic("admin","password123")
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);
    }

    @Test(groups = "QA", dependsOnMethods ={"testDeleteBooking"})
    public void testVerifyDeleteBookingByGet(){

        requestSpecification.basePath(APIConstants.UPDATE_BOOKING + "/" +bookingIdJson);
        response = RestAssured.given().spec(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);

    }
}
