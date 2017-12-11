package com.sudha.restapi.tests;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.restapi.pageobjects.RestAPI;
import com.sudha.restapi.reports.ExtentReportManager;
import com.sudha.restapi.setup.OpenBrowser;

import junit.framework.Assert;



public class RestAPIResponse {
	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	public String firstWinHandle;
	private final String USER_AGENT="Mozilla/5.0";
	
	@Test
	public void test() throws ClientProtocolException, IOException {
		
		test = extent.startTest("APITest 1");
		test.log(LogStatus.INFO, "Navigate to aPI web site");

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();

		OpenBrowser.webDriver.get("http://openweathermap.org/current");

		RestAPI api= new RestAPI(OpenBrowser.webDriver);
		
		OpenBrowser.webDriver.navigate().to("http://api.openweathermap.org/data/2.5/weather?q=London");	
	 
	RestAPIResponse weatherApiResponse=new RestAPIResponse();
	 String ExpectedString=weatherApiResponse.GetResponse();
	 Assert.assertTrue(api.preTagName.getText().equals(ExpectedString));
	 
		extent.endTest(test);
		extent.flush();
	}
	
	@Test
	public String GetResponse() throws ClientProtocolException, IOException
	{
		test = extent.startTest("APITest 2");
		test.log(LogStatus.INFO, "Check the text");
				
		StringBuffer result=new StringBuffer();
		HttpClient client=new DefaultHttpClient();
		String url="http://api.openweathermap.org/data/2.5/weather?q=London";
		HttpGet request=new HttpGet(url);
		request.addHeader("User-Agent",USER_AGENT);
		HttpResponse response=client.execute(request);
		int responseCode=response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + responseCode);
		try{
		if(responseCode==200)
			
		{
			System.out.println("Get Response is Successfull");
			BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line="";
			while((line=reader.readLine())!=null)
			{
				result.append(line);
				System.out.println(result.toString());
			}
		}
		extent.endTest(test);
		extent.flush();
		return result.toString();
		
	}
		catch(Exception ex)
	{
		result.append("Get Response Failed");
		extent.endTest(test);
		extent.flush();
		return result.toString();
	}
		
	}
  }
