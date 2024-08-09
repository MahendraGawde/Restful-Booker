package com.api.misc;

import com.api.utils.FilloUtil;
import com.codoid.products.exception.FilloException;
import org.testng.annotations.Test;

public class TestFillo {

    @Test(enabled = false)
    public void testGetFillo() throws FilloException {
        String BASE_URL = FilloUtil.fetchDataFromXLSX("Sheet1", "BaseUrl", "value");
        System.out.println(BASE_URL);
    }
}