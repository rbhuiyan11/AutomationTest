package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPageOR;

public class LoginTestCases extends TestBase {
	
	LoginPageOR loginPage;
	HomePage homePage;
	
	
	public LoginTestCases(){
		super();
	}
		
	
	@BeforeMethod
	public void setUpdriver(){
		intialization();
		loginPage = new LoginPageOR();
		
	}
	
	@Test (priority=1)
	
	public void loginPageTitleTest(){
		String title = loginPage.verifyPageTitle();
		Assert.assertEquals(title, "Later i will check the site for the title");
	}
	
	@Test(priority=2)
	
public void apLogoTest(){
		boolean value = loginPage.validateAPImage();
		Assert.assertTrue(value);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	}
	
	
	@AfterMethod
	public void  closeBrowser(){
		driver.quit();
	}
	
}