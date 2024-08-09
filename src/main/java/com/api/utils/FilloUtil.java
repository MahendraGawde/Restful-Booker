package com.api.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloUtil {

    public static String FILEPATH = System.getProperty("user.dir")
            + "/src/test/resources/TestData_Fillo.xlsx";

    public static String fetchDataFromXLSX(String sheetName, String id, String fieldName) throws FilloException {
        String value = null;
        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection(FILEPATH);
        String query = "Select * from " +sheetName+ " " + "Where ID = " +id+ ";";
        Recordset recordset = connection.executeQuery(query);
        while(recordset.next()){
            value = recordset.getField(fieldName);
        }
        recordset.close();
        connection.close();
        return value;
    }

}
