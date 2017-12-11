package com.sudha.restapi.reports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {
	public static ExtentReports extent;
   
	//Generates the  html report
	public static ExtentReports getInstance() {

		if (extent == null) {
			extent = new ExtentReports("./test_report.html");
			extent.config().documentTitle("Test Report").reportHeadline("Zalando Selenium Execution");

		}
		return extent;

	}
}
