package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase {	
	
	@FindBy(className = "login")
	WebElement Login;
	
	
	@FindBy(id = "contact-link")
	WebElement ContactButton;
	
	
	@FindBy(id = "search_query_top")
	WebElement Search;
	
	
	@FindBy(name = "submit_search")
	WebElement SearchButton;
	
	
	@FindBy(className = "logout")
	WebElement LogOut;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public SearchPageOR SearchProduct(String productName){
		Search.sendKeys(productName);
		SearchButton.click();
		return new SearchPageOR();
	}

	public void clickonSignIn(){
		Login.click();
	}
	
	
	public void clickOnContactLink() {
		ContactButton.clear();
	}
	
	public void logOut(){
		LogOut.click();
	}
}




// @findby(css="title=' ' ")

