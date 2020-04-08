package com.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.verizon.base.BasePage;
import com.verizon.pages.VerizonFeatures;
import com.verizon.pages.VerizonMainPage;
import com.verizon.pages.VerizonSmartPhones;
import com.verizon.util.Constants;

public class VerizonFeatureTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	VerizonSmartPhones verizonSmartPhones;
	VerizonMainPage verizonMainPage;
	VerizonFeatures verizonFeatures;
	
@BeforeMethod
public void setUp() throws InterruptedException{
	basePage=new BasePage();
	prop=basePage.initialize_properties();
	driver=basePage.initialize_driver(prop);
	verizonMainPage=new VerizonMainPage(driver);
	verizonSmartPhones=verizonMainPage.moveToSmartPhones();
	verizonFeatures=verizonSmartPhones.clickOnPhone();
}

@Test(priority=1)
public void getTitleVerizonFeatures() throws InterruptedException {
	String title=verizonFeatures.getPagetitle();
	System.out.println(title);
	Thread.sleep(3000);
	Assert.assertEquals(title, Constants.VERIZON_FEATURES_TITLE);
}

@Test(priority=2)
public void selectFeatures() throws InterruptedException{
	verizonFeatures.selectTheFeatures();
}

@AfterMethod
public void tearDown(){
	driver.quit();
}
}
