package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.verizon.base.BasePage;
import com.verizon.util.Constants;
import com.verizon.util.ElementUtil;


public class VerizonSmartPhones extends BasePage {

	 WebDriver driver;
	 ElementUtil elementUtil;
	VerizonMainPage verizonMainPage;
	VerizonSmartPhones verizonSmartPhones;
	VerizonFeatures verizonFeatures;
	//VerificationThePhone verificationThePhone;
	
	By iphone11=By.xpath("//a[@aria-label='Apple iPhone 11']");
	
	
	public VerizonSmartPhones(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getPageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.VERIZON_SMARTPHONES_TITLE);
	}
	
	public VerizonFeatures clickOnPhone(){
		//elementUtil.doClick(iphone11);
		VerizonFeatures verizonFeatures = new VerizonFeatures(driver);
		driver.findElement(iphone11).click();
		return new VerizonFeatures(driver);
	}
}