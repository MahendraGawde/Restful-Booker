package com.api.endpoints;

import com.api.utils.FilloUtil;
import com.codoid.products.exception.FilloException;

import java.util.prefs.BackingStoreException;

public class APIConstants {

    //public static String BASE_URL;
    //Fillo example
   /* static{
        try {
            BASE_URL = FilloUtil.fetchDataFromXLSX("Sheet1","BaseUrl","Value");
        } catch (FilloException e) {
            throw new RuntimeException(e);
        }
    }*/
    // As String storing Base Url.
    public static String BASE_URL = "https://restful-booker.herokuapp.com";
    public static String CREATE_BOOKING = "/booking";
    public static String UPDATE_BOOKING = "/booking";
}
