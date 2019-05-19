package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;

public class ProductDetailsPageOR extends TestBase {

	@FindBy(id= "quantity_wanted")
	WebElement InputQuantity ;
	
	@FindBy (id= "group_1")
	WebElement SizeList;
	
	@FindBy (name= "Submit")
	WebElement AddToCart;
	
	@FindBy (css="title='Proceed to checkout'")
	WebElement CheckOut;
	
	@FindBy (css="title='Add to my wishlist'")
	WebElement AddToWishlist;
	
	@FindBy(className= "fancybox-error")
	WebElement WishlistMsg;
	
	
	@FindBy(className= "fancybox-item fancybox-close")
	WebElement CloseWishlistMsg;
	
	@FindBy (id="color_to_pick_list")
	WebElement ColorChoice;
	
	public ProductDetailsPageOR (){
		PageFactory.initElements(driver, this);    // this the constructor initializing the web page and the web elements 
	}
	
	public void verifyWishlistMsg(){
		Assert.assertEquals(WishlistMsg.getText(), "Added to your wishlist.");
		CloseWishlistMsg.click();
	} // when the action is successful the message will appear saying "added to you wishlist and then it will close the wishlist message
	
	public ProductDetailsPageOR selectProductColor(String color){
		String locator ="[name='"+color+"']";
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	} //setting the parameter to be about the color
	
	public ProductDetailsPageOR inputQuantity(String quantity){
		InputQuantity.clear();
		InputQuantity.sendKeys(quantity);
		return this;
	}
	
	public ProductDetailsPageOR selectSize(String size){
		Select select = new Select(SizeList);
				select.selectByVisibleText(size);
				return this;
	}

	public ProductDetailsPageOR clickAddcart(){
		AddToCart.click();
		return this;
	}
	
	public ProductDetailsPageOR clickAddWishListButton(){
		AddToWishlist.click();
		return this;
	}
	
	public OrderSummaryPageOR proceedCheckOut(){
		CheckOut.click();
		return new OrderSummaryPageOR();
	}
	

	
}










