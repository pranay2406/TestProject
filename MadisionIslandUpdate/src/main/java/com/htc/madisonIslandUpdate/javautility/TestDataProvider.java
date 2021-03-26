package com.htc.madisonIslandUpdate.javautility;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

import com.htc.madisonIslandUpdate.constants.constants;

public class TestDataProvider {

	@DataProvider(name = "Madison")
	public Object[][] Madison_Valid_And_Invalid_RegisterData(Method m) {
		Object[][] loginDataSet = null;
		ExcelReader ref = new ExcelReader(constants.EXCELFILE_PATH);
		if (m.getName().equals("Valid_And_Invalid_Registration")) {
			loginDataSet = ref.getDataUsingMap(constants.REGISTRATION_SHEETNAME);
		} else if (m.getName().equals("Valid_And_Invalid_Login")) {
			loginDataSet = ref.getDataUsingMap(constants.LOGIN_SHEETNAME);
		}

		return loginDataSet;

	}

}
