package com.sudha.restapi.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.restapi.pageobjects.RestAPI;
import com.sudha.restapi.reports.ExtentReportManager;
import com.sudha.restapi.utils.TestUtils;


public class CloseBrowser {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	String firstWinHandle;
  
	//Test for Clearing the items from wishlist
	

	//Test for Logging out
	@Test(priority = 19)
	@Parameters({ "browser" })
	public void LogOut(String browser) {
		if (browser.equalsIgnoreCase("Firefox")) {
			test = extent.startTest("Logging out");
			test.log(LogStatus.INFO, "Logging out from Zalando");
			RestAPI restapi = new RestAPI(OpenBrowser.webDriver);

			Actions action = new Actions(OpenBrowser.webDriver);
			//action.moveToElement(wishList.myaccount).build().perform();
			//wishList.logout.get(5).click();
			 
			TestUtils.addDelay(5000);
			test.log(LogStatus.INFO, "Logged out from Zalando");
			extent.endTest(test);
			extent.flush();
		}
		
	}

	//Close browser 
	@Test(priority = 20)
	public void quitBrowser() {
		test = extent.startTest("closing Browser");
		test.log(LogStatus.INFO, "Closing the Browser");
		OpenBrowser.webDriver.close();
		OpenBrowser.webDriver.quit();
		extent.endTest(test);
		extent.flush();

	}

}
