package utilities;

import java.io.IOException;
import java.io.*;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name ="LoginData")
	
    public String[][] getData() throws IOException {
	String path="C:\\Users\\lenovo\\Desktop\\Selenium Practice\\openCart123\\testData\\dd.xlsx";
		
		
        
        
        ExcelUtility xlutil = new ExcelUtility(path); // Creating an object for ExcelUtility

        int totalRows =xlutil.getRowCount("Sheet1");
        int totalCols =xlutil.getCellCount("Sheet1",1);

        String loginData[][]=new String[totalRows][totalCols]; // Creating a two-dimensional array

        for(int i=1;i<=totalRows;i++)
        { 																	// Looping through rows (starting from 1 because 0 is usually header)
            for(int j=0;j<totalCols;j++) 
            { 																// Looping through columns
                loginData[i-1][j]=xlutil.getCellData("Sheet1",i,j); 		// Reading data into the array
            }
        }

        return loginData;
    }
}

