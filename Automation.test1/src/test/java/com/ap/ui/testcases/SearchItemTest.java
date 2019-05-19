package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPageOR;
import com.ap.ui.pages.SearchPageOR;

public class SearchItemTest extends TestBase {

	
	LoginPageOR loginPage;
	HomePage homePage;	
	SearchPageOR searchPage;

	

public SearchItemTest(){
	super();
}
@BeforeMethod
public void  setUpdriver(){
	intialization();
	loginPage = new LoginPageOR();
	homePage = new HomePage();
}
@Test(priority=3)
public void testSearchItem(){
	String product = "Evening";
	homePage.clickonSignIn();
	homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	
	searchPage = homePage.SearchProduct("Evening");
	String header = searchPage.getHeader();
	System.out.println(header);
	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
	homePage.logOut();
}

@AfterMethod
public void tearDown(){
	driver.quit();

}
}















