package com.miscPrograms;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabTest {

	// Register to souceLab and access process

	/*
	 * public static final String USERNAME = "rahul2"; 
	 * public static final String ACCESS_KEY = "xxxxx"; 
	 * public static final String URL = "http://" + USERNAME +":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	 */

	// Sign-In with google account(direct- OAuth process)
	public static String URL = "https://oauth-akkiashusms-c5dc2:d67c583b-5c1a-4d63-9ef1-636cc11c2f8e@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws MalformedURLException {

		ChromeOptions options = new ChromeOptions();
		options.setPlatformName("Windows 8");
		options.setBrowserVersion("78.0");

		WebDriver driver = new RemoteWebDriver(new URL(URL), options);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		System.out.println("Title Displayed");
		System.out.println("Google Opened");
	}

}
