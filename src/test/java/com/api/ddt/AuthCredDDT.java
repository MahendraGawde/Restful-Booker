package com.api.ddt;

import com.api.utils.UtilExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthCredDDT {

    @Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void testLoginData(String username, String password){
        System.out.println("Username: " +username);
        System.out.println("Password: " +password);
    }

}
