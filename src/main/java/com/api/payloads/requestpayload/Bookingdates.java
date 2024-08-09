package com.api.payloads.requestpayload;

import java.util.LinkedHashMap;
import java.util.Map;


import io.qameta.allure.internal.shadowed.jackson.annotation.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "checkin",
        "checkout"
})

public class Bookingdates {

    @JsonProperty("checkin")
    private String checkin;
    @JsonProperty("checkout")
    private String checkout;


    @JsonProperty("checkin")
    public String getCheckin() {
        return checkin;
    }

    @JsonProperty("checkin")
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    @JsonProperty("checkout")
    public String getCheckout() {
        return checkout;
    }

    @JsonProperty("checkout")
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }



}