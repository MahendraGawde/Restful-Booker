package com.api.payloads.responsepayload;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.api.payloads.requestpayload.Booking;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookingid",
        "booking"
})
@Generated("jsonschema2pojo")
public class BookingResponse {

    @JsonProperty("bookingid")
    private Integer bookingid;
    @JsonProperty("booking")
    private Booking booking;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("bookingid")
    public Integer getBookingid() {
        return bookingid;
    }

    @JsonProperty("bookingid")
    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    @JsonProperty("booking")
    public Booking getBooking() {
        return booking;
    }

    @JsonProperty("booking")
    public void setBooking(Booking booking) {
        this.booking = booking;
    }



}