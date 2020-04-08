package com.verizon.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.common.base.Verify;
import com.verizon.base.BasePage;
import com.verizon.pages.VerificationThePhone;
import com.verizon.pages.VerizonFeatures;
import com.verizon.pages.VerizonMainPage;
import com.verizon.pages.VerizonSmartPhones;
import com.verizon.util.Constants;


public class VerificationTest {
		WebDriver driver;
		Properties prop;
		BasePage basePage;
		VerizonSmartPhones verizonSmartPhones;
		VerizonMainPage verizonMainPage;
		VerificationThePhone verificationThePhone;
		VerizonFeatures verizonFeatures;
		
		@BeforeMethod
		public void setUp () throws InterruptedException {
			basePage =new BasePage();
			prop=basePage.initialize_properties();
			driver=basePage.initialize_driver(prop);
			verizonMainPage=new VerizonMainPage(driver);
			verizonSmartPhones=verizonMainPage.moveToSmartPhones();
			verificationThePhone=verizonFeatures.selectTheFeatures();
		}
		
		@Test
		public void getTitle(){
			String title=verificationThePhone.getTitleOfVerification();
			System.out.println(title);
			Assert.assertEquals(title, Constants.VERIZON_CUSTOMIZE_YOUR_PHONE);
		}
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
}