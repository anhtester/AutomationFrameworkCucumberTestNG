
package com.anhtester.dataprovider;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.helpers.ExcelHelpers;
import com.anhtester.helpers.SystemHelpers;
import org.testng.annotations.DataProvider;

public final class DataProviderManager {

    private DataProviderManager() {
    }

    @DataProvider(name = "getSignInDataHashTable", parallel = true)
    public static Object[][] getSignInData() {
        ExcelHelpers excelHelpers = new ExcelHelpers(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        return excelHelpers.getTestData(1, 2);
    }

    @DataProvider(name = "getSignInDataHashTable2", parallel = true)
    public static Object[][] getSignInData2() {
        ExcelHelpers excelHelpers = new ExcelHelpers(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        return excelHelpers.getTestData(2, 3);
    }

    @DataProvider(name = "getClientDataHashTable", parallel = true)
    public static Object[][] getClientData() {
        ExcelHelpers excelHelpers = new ExcelHelpers(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Client");
        return excelHelpers.getTestData(1, 3);
    }
}
