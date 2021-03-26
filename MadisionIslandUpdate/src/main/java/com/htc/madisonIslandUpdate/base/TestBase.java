package com.htc.madisonIslandUpdate.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.htc.madisonIslandUpdate.constants.constants;
import com.htc.madisonIslandUpdate.javautility.BrowserFactory;
import com.htc.madisonIslandUpdate.pages.BillingPage;
import com.htc.madisonIslandUpdate.pages.CartPage;
import com.htc.madisonIslandUpdate.pages.HomePage;
import com.htc.madisonIslandUpdate.pages.Login;
import com.htc.madisonIslandUpdate.pages.OrderConfirmationpage;
import com.htc.madisonIslandUpdate.pages.ProductsListPage;
import com.htc.madisonIslandUpdate.pages.ShoppingCartPage;
import com.htc.madisonIslandUpdate.seleniumutility.ScreenShot;

public class TestBase {
	protected WebDriver driver=null;
	protected Login login = null;
	protected HomePage homepage = null;
	protected ProductsListPage productlist = null;
	protected CartPage cartpage = null;
	protected ShoppingCartPage shopping = null;
	protected BillingPage billing = null;
	protected OrderConfirmationpage confirm = null;

	protected ScreenShot screenshot = null;

	public Properties data = null;

	public TestBase() {
		data = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\hp\\Downloads\\MadisionIslandupdate\\MadisionIslandUpdate\\src\\main\\resources\\data.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeSuite()
	@Parameters("browser")
	public void start(String browser) {

		this.driver = BrowserFactory.setWebDriver(browser);
		this.driver.get(constants.URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(constants.SECONDS, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void browserSetup() {
		login = new Login(driver);
		homepage = new HomePage(driver);
		productlist = new ProductsListPage(driver);
		cartpage = new CartPage(driver);
		shopping = new ShoppingCartPage(driver);
		billing = new BillingPage(driver);
		confirm = new OrderConfirmationpage(driver);
	}

	@BeforeTest
	public WebDriver getdriver() {
		return this.driver;

	}

	public WebDriver getDriver() {
		return this.driver;
	}

	@AfterTest
	public void takescreenshot(ITestResult result) throws IOException, InterruptedException {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.capturescreenShot(driver, constants.SCREENSHOT_FAIL,result.getMethod().getMethodName());
			
		} else if (ITestResult.SUCCESS == result.getStatus()) {
			ScreenShot.capturescreenShot(driver, constants.SCREENSHOT_PASS,result.getMethod().getMethodName());
			login.Logout();
		}
		
	}

}
