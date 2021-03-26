package TestPages;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.htc.madisonIslandUpdate.base.TestBase;
import com.htc.madisonIslandUpdate.constants.constants;
import com.htc.madisonIslandUpdate.seleniumutility.ScreenShot;

public class TestPurchase extends TestBase {
	@Test(dataProviderClass = com.htc.madisonIslandUpdate.javautility.TestDataProvider.class, dataProvider = "Madison")
	@Parameters("SheetName")
	public void Valid_And_Invalid_Login(Map<String, String> mapData) throws IOException, InterruptedException {
		login.Login_To_Page(mapData.get("emailid"), mapData.get("password"));
		//Assert.assertEquals(homepage.assert_login(), "Hello, prny");

		homepage.Home_Page(data.getProperty("searchproduct"));

		productlist.selectproductBy();

		cartpage.selectproduct(data.getProperty("quantity"));

		shopping.setAddress(data.getProperty("country"), data.getProperty("region"), data.getProperty("city"),
				data.getProperty("pincode"));

		billing.setCheckoutdata(mapData.get("emailid"), data.getProperty("company"), data.getProperty("street"),
				data.getProperty("city"), data.getProperty("quantity"), data.getProperty("pincode"),
				data.getProperty("mobilenumber"));

		Assert.assertEquals(confirm.assert_chechouttitle(), "CHECKOUT");
		System.out.println("Order has Placed Succesfully");
	}
}