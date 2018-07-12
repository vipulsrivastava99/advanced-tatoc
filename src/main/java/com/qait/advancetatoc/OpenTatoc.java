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
		driver=this.driver;
	}
	public void openTatocPage()
	{
		
		js=(JavascriptExecutor)driver;
		String heading = (String) js.executeScript("return document.querySelector('h1').textContent");
		Assert.assertEquals(heading,"Test Automation Training Obstacle Course","Assertion Failed : Test Automation Training Obstacle Course Page is not opened");
		Reporter.log("Assertion Passed : Test Automation Training Obstacle Course Page is successfully opened.");
	}
	public void clickOnAdvanced()
	{
		driver.findElement(By.linkText("Advanced Course"));
		String heading = (String) js.executeScript("return document.querySelector('h1').textContent");
		Assert.assertEquals(heading,"Hover Menu","Assertion Failed : Hover Menu page is'nt opened.");
		Reporter.log("Assertion Passed : Hover Menu page opened successfully.");

	}
	
}
