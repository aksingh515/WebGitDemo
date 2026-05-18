package com.miscPrograms;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadTest {

	public static void main(String[] args) throws InterruptedException, IOException {

		String downloadPath = System.getProperty("user.dir");

		WebDriverManager.chromedriver().setup();

		// implement file download at selected directory
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.xpath("//a[@id='pickfiles'] /span")).click();
		Thread.sleep(3000);

		// implement code to execute the EXE on runtime
		Runtime.getRuntime().exec("C:\\Users\\ashut\\OneDrive\\Documents\\AutoITestFiles\\DemoTest.exe");

		// Explicitly Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='processTaskTextBtn']")));

		driver.findElement(By.xpath("//span[@id='processTaskTextBtn']")).click();
		Thread.sleep(5000);

		File f = new File(downloadPath + "/ilovepdf_pages-to-jpg.zip");

		if (f.exists()) {
			Assert.assertTrue(f.exists());

			if (f.delete())

				System.out.println("File Deleted");

		}
		
		driver.close();
	}

}
