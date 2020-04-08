package com.verizon.pages;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.scanner.Constant;

import com.verizon.base.BasePage;
import com.verizon.util.Constants;
import com.verizon.util.ElementUtil;


public class VerizonMainPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	VerizonSmartPhones verizonSmartPhones ;
	
	By phones=By.xpath("//button[contains(text(),'Phones list')]");
	By smart=By.id("thirdLevel00");
	
	public VerizonMainPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	public String getVerizonTitle() {
		//return driver.getTitle();
		return elementUtil.waitForGetPageTitle(Constants.VERIZON_TITLE);
	}
	public VerizonSmartPhones moveToSmartPhones(){
		WebElement phone=driver.findElement(phones);
		Actions action=new Actions(driver);
		action.moveToElement(phone).build().perform();
		WebElement smart1=driver.findElement(smart);
		smart1.click();
		return  new VerizonSmartPhones(driver);
	}
}