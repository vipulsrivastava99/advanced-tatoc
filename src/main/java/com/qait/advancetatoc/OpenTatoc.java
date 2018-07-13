package com.qait.advancetatoc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class OpenTatoc {

	WebDriver driver;
	JavascriptExecutor js;
	public OpenTatoc(WebDriver driver)
	{
		this.driver=driver;
	}
	public void openTatocPage()
	{
		
		js=(JavascriptExecutor)driver;
		//String heading = 	driver.findElement(By.className("page")).getText();
		String heading = (String) js.executeScript("return document.querySelector('h1').textContent");
		System.out.println(heading);
		Assert.assertTrue("Assertion Failed : Test Automation Training Obstacle Course Page is not opened",heading.contains("Test Automation Training Obstacle Course"));
		Reporter.log("Assertion Passed : Test Automation Training Obstacle Course Page is successfully opened.");
	}
	public void clickOnAdvanced() throws InterruptedException
	{
		driver.findElement(By.linkText("Advanced Course")).click();
		Thread.sleep(3000);
		String heading = (String) js.executeScript("return document.querySelector('h1').textContent");
		Assert.assertTrue("Assertion Failed : Hover Menu page is'nt opened.",heading.contains("Hover Menu"));
		Reporter.log("Assertion Passed : Hover Menu page opened successfully.");

	}
	
}
