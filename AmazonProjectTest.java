package com.saucedemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonProjectTest {
 public static WebDriver driver;
	
	@BeforeClass
	public void LaunchBrowser() throws InterruptedException {
	    driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();//minimize 
		driver.get("https://www.amazon.com/");
		Thread.sleep(1000);
	}
  @Test
  public void mainTest() {
	  WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("water bottle");
		
		//searchbox.submit();
		WebElement searchbtn=driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
		searchbtn.click();
		
		WebElement productname=driver.findElement(By.linkText("Owala Stainless Steel Triple Layer Insulated Travel Tumbler with Spill Resistant Lid, Straw, and Carry Handle, BPA Free, 40 oz, Pink (Watermelon Breeze)"));
		productname.click();
		
		WebElement productid=driver.findElement(By.xpath("//*[@id='a-autoid-1-announce']"));
		productid.click();
  
		Select quantity=new Select(driver.findElement(By.cssSelector("#selectQuantity #quantity")));
		quantity.selectByIndex(1);
		quantity.selectByValue("1");
		quantity.selectByVisibleText("2");
		
		driver.close();
		
  }
}
