package com.sudha.restapi.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.apache.http.client.ClientProtocolException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("deprecation")
public class RestAPI {
	
	
	public RestAPI(WebDriver driver) {
	      
        PageFactory.initElements(driver, this);
        
    }
	

	@FindBy(tagName="pre")
    public WebElement preTagName;
	

}


