package com.api.crud;

import com.api.base.BaseTest;
import com.api.endpoints.APIConstants;
import com.api.payloads.responsepayload.BookingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;



public class TC_CreateBooking extends BaseTest {

    @Test(groups = "preprod")
    @Owner("Mahendra")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Create booking positive test case")
    public void testCreateBooking_Valid() throws JsonProcessingException {
        //Call request block
        //Call payload block
        //Call assert block

        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = requestSpecification.when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

       /* jsonPath = JsonPath.from(response.asString());
        String boookingId = jsonPath.getString("bookingid");*/

        BookingResponse bookingResponse = payloadManager.jsonToPojo(response.asString());
        assertThat(bookingResponse.getBookingid().toString()).isNotEmpty().isNotNull();


    }

    @Test(groups = "preprod")
    @Owner("Mahendra")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#2 - Create booking invalid values in request test case")
    public void testCreateBooking_Invalid() throws JsonProcessingException {
        //Call request block
        //Call payload block
        //Call assert block

        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = requestSpecification.when().body("").post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);

       /* jsonPath = JsonPath.from(response.asString());
        String boookingId = jsonPath.getString("bookingid");*/




    }
}
