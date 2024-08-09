package com.api.modules;

import com.api.payloads.requestpayload.AuthToken;
import com.api.payloads.requestpayload.Booking;
import com.api.payloads.requestpayload.Bookingdates;
import com.api.payloads.responsepayload.BookingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadManager {

    ObjectMapper objectMapper;

    public String createPayload() throws JsonProcessingException {
        objectMapper = new ObjectMapper();

        Booking booking = new Booking();
        booking.setFirstname("Vikas");
        booking.setLastname("Singh");
        booking.setTotalprice(202);
        booking.setDepositpaid(true);

        booking.setAdditionalneeds("Breakfast");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-01-01");
        bookingdates.setCheckout("2024-01-10");

        booking.setBookingdates(bookingdates);

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;

    }

    public BookingResponse jsonToPojo(String jsonString) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        BookingResponse bookingResponse = objectMapper.readValue(jsonString, BookingResponse.class);
        return bookingResponse;

    }

    public Booking jsonToPojoPUT(String jsonString) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Booking booking = objectMapper.readValue(jsonString, Booking.class);
        return booking;

    }

    public String setToken() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        AuthToken auth = new AuthToken();
        auth.setUsername("admin");
        auth.setPassword("password123");
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(auth);
    }

    public String updatePayload() throws JsonProcessingException {
        objectMapper = new ObjectMapper();

        Booking booking = new Booking();
        booking.setFirstname("Kriti");
        booking.setLastname("Sanon");
        booking.setTotalprice(2005);
        booking.setDepositpaid(true);

        booking.setAdditionalneeds("Breakfast");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-01-11");
        bookingdates.setCheckout("2024-01-20");

        booking.setBookingdates(bookingdates);

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;

    }
}
