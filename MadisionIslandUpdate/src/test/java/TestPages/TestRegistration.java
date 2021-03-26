package TestPages;

import org.testng.annotations.Test;

import com.htc.madisonIslandUpdate.base.TestBase;
import com.htc.madisonIslandUpdate.constants.constants;
import com.htc.madisonIslandUpdate.pages.Registration;
import com.htc.madisonIslandUpdate.seleniumutility.ScreenShot;

import org.testng.Assert;
import java.io.IOException;
import java.util.Map;

public class TestRegistration extends TestBase {
	ScreenShot screenshot = new ScreenShot();

	@Test(dataProviderClass = com.htc.madisonIslandUpdate.javautility.TestDataProvider.class, dataProvider = "Madison")
	public void Valid_And_Invalid_Registration(Map<String, String> mapData) throws IOException, InterruptedException {

		Registration registration = new Registration(this.driver);

		registration.Registration_To_Page(mapData.get("firstname"), mapData.get("middlename"), mapData.get("lastname"),
				mapData.get("emailid"), mapData.get("password"), mapData.get("confirmpassword"));
		registration.assertcheckBy();
		Assert.assertEquals(registration.assertcheckBy(),mapData.get("assert") );
		//ScreenShot.screenShot(driver, constants.SCREENSHOT_PASS);
		//login.Logout();

	}
}
