package com.qait.advancetatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class HoverMenu {
	WebDriver driver;
	 public HoverMenu(WebDriver driver)
	 {
		 this.driver=driver;
	 }
 public void clickOnMenu() {
	 Actions action = new Actions(driver);
	 WebElement we=driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[1]"));
	 action.moveToElement(we).build().perform();
	 Reporter.log("User hovered the mouse on Menu 2 column");
	driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]")).click();
	 Reporter.log("User clicked on Go next");
 }
}
