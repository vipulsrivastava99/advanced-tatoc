package com.qait.advancetatoc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class QueryGatePage {
WebDriver driver;
	  public QueryGatePage(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	  
	 public void jdbcAndSendKeys() throws ClassNotFoundException, SQLException
	 {
		 String hostUrl="jdbc:mysql://10.0.1.86/tatoc";
			String userName="tatocuser";
			String password="tatoc01";
			                
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(hostUrl,userName,password);
			java.sql.Statement stmt = conn.createStatement();
			WebElement symbol=driver.findElement(By.id("symboldisplay"));
			WebElement sendName=driver.findElement(By.id("name"));
			WebElement sendPass=driver.findElement(By.id("passkey"));
			WebElement proceed=driver.findElement(By.id("submit"));
			String symTxt=symbol.getText();
		
			String query="SELECT identity.id,credentials.id,name,passkey,symbol FROM identity INNER JOIN credentials ON identity.id=credentials.id";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) 
			{
				String sym= rs.getString("symbol");
			
				String  name = rs.getString("name");
				String pass= rs.getString("passkey");
				
				if(sym.equalsIgnoreCase(symTxt))
				{
					
					sendName.sendKeys(name);
					sendPass.sendKeys(pass);
					proceed.click();
				}
			}
			String url="http://10.0.1.86/tatoc/advanced/video/player";
			Assert.assertEquals(url, driver.getCurrentUrl());

		}
	 
}
