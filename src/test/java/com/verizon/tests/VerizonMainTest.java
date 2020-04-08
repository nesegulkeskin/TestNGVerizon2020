package com.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.verizon.base.BasePage;
import com.verizon.pages.VerizonMainPage;
import com.verizon.util.Constants;

public class VerizonMainTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		verizonMainPage=new VerizonMainPage(driver);
	}
   @Test(priority=1)
	public void getTitle() {
		String title = verizonMainPage.getVerizonTitle();
		System.out.println("Page title is: "+title);
		Assert.assertEquals(title,Constants.VERIZON_TITLE );
	}
   @Test(priority=2)
   public void SmartPhoneClick(){
	   verizonMainPage.moveToSmartPhones();
   }
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
