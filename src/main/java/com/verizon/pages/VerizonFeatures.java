package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.verizon.util.Constants;
import com.verizon.util.ElementUtil;

import com.verizon.util.JavaScriptUtil;

public class VerizonFeatures {

	WebDriver driver;
	ElementUtil elementUtil;


	By color=By.xpath("//div[@style='background-color: rgb(251, 229, 128);']");
	By size=By.xpath("//p[text()='128GB']");
	By price=By.xpath("//div[contains(text(), 'Retail price')]");
	By continueBTn=By.id("ATC-Btn");
	By zipcode= By.id("zipcode");
	By confirmBtn= By.xpath("//button[@class='defaultPrimaryCTA ']");
	By NewCustomer= By.xpath("//button[@aria-label='New Customer']");
	
	public VerizonFeatures(WebDriver driver) {
		this.driver=driver;
		//ElementUtil=new ElementUtil(driver);
		elementUtil=new ElementUtil(driver);
	}
	public String getPagetitle() throws InterruptedException{
		Thread.sleep(4000);
		//return ElementUtil.waitForGetPageTitle(Constants.VERIZON_FEATURES_TITLE);
		return elementUtil.waitForGetPageTitle(Constants.VERIZON_FEATURES_TITLE);
		
	}
	public VerificationThePhone selectTheFeatures() throws InterruptedException{
		Thread.sleep(3000);
		elementUtil.doClick(color);
		elementUtil.doClick(size);
		elementUtil.doClick(price);
		elementUtil.doClick(continueBTn);
		elementUtil.waitForElementPresent(zipcode);
		elementUtil.doSendKeys(zipcode, "07503");
		elementUtil.doClick(confirmBtn);
		elementUtil.doClick(NewCustomer);
		return new VerificationThePhone(driver);
	}
}