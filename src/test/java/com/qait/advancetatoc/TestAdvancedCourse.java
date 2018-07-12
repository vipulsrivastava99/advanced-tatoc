package com.qait.advancetatoc;

import java.sql.SQLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestAdvancedCourse {
	WebDriver driver;
	JavascriptExecutor js;
	HoverMenu h;
	OpenTatoc o;
	QueryGatePage q;
	@BeforeClass
	@Test
	public void launchBrowserAndOpenTatoc()
	{
	driver=new ChromeDriver();
	driver.get("http://10.0.1.86/tatoc");
	
	}
	

    @Test(dependsOnMethods={"launchBrowserAndOpenTatoc"})
	public void checkopenTatoc()
	{
    	o=new OpenTatoc(driver);
    	o.openTatocPage();
    	o.clickOnAdvanced();
	}
    @Test(dependsOnMethods={"checkopenTatoc"})
	public void checkHoverMenu()
	{
    	h=new HoverMenu(driver);
    	h.clickOnMenu();
	}
  //  @Test(dependsOnMethods={"checkHoverMenu"})
	public void checkQueryGate() throws ClassNotFoundException, SQLException
	{
    	q=new QueryGatePage(driver);
    	q.jdbcAndSendKeys();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		
	}
}
