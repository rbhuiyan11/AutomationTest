package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class SearchPageOR extends TestBase{

	@FindBy(id="add_to_cart")
	WebElement addCartButton;
	
	
	@FindBy(css="(title='Proceed to checkout')")
	WebElement checkOut;
	
	@FindBy(css="[class='page=heading product-listing']")
	WebElement searchHeading;
	
	public SearchPageOR(){
		PageFactory.initElements(driver, this);
	}
	
	public ProductDetailsPageOR selectProduct(String productName){
		String locator = "[class='product-name'][title='"+ productName +"']";
		driver.findElement(By.cssSelector(locator)).click();	
		return new ProductDetailsPageOR();
	}
	public String getHeader(){
		return searchHeading.getText();
	}
	
}
