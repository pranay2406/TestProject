package TestPages;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.htc.madisonIslandUpdate.base.TestBase;

public class TestLogin extends TestBase {

	@Test(dataProviderClass = com.htc.madisonIslandUpdate.javautility.TestDataProvider.class, dataProvider = "Madison")
	@Parameters("SheetName")
	public void Valid_And_Invalid_Login(Map<String, String> mapData) throws IOException, InterruptedException {
		login.Login_To_Page(mapData.get("emailid"), mapData.get("password"));
		Assert.assertEquals(homepage.assert_login(), mapData.get("assert"));
	}
}
