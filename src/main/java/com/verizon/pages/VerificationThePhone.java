package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.verizon.base.BasePage;
import com.verizon.util.Constants;
import com.verizon.util.ElementUtil;


public class VerificationThePhone extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	VerizonMainPage verizonMainPage;
	VerizonSmartPhones verizonSmartPhones;
	VerizonFeatures verizonFeatures;
	VerificationThePhone verificationThePhone;
	
	By phoneName=By.xpath("//span[contains(text(), 'iPhone 11')]");
	public VerificationThePhone(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver); 
	}
	public String getTitleOfVerification(){
		return elementUtil.waitForGetPageTitle(Constants.VERIZON_TITLE);
		}
}
