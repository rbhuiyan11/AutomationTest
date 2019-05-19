package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPageOR;
import com.ap.ui.pages.ProductDetailsPageOR;
import com.ap.ui.pages.SearchPageOR;

public class AddWishlistTest extends TestBase{

	LoginPageOR loginPage;
	HomePage homePage;	
	SearchPageOR searchPage;
	ProductDetailsPageOR productDetailsPage;
	
	
	public AddWishlistTest(){
		super();
	}
	
	@BeforeMethod
	public void setUpdriver(){
		intialization();
		loginPage = new LoginPageOR();
		homePage = new HomePage();
	
	
	}	
	
	@Test
	public void testAddProductToWishList(){
		String product = "Printed Chiffon Dress";
		homePage.clickonSignIn();
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
		//search for product
		searchPage = homePage.SearchProduct(product);
		String header = searchPage.getHeader();
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
//add oridutc to the wishlist
		productDetailsPage.clickAddWishListButton();
		productDetailsPage.verifyWishlistMsg();
		homePage.logOut();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
