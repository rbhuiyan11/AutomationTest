package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class OrderSummaryPageOR extends TestBase {
	
	@FindBy (css="title='Proceed to checkout'")
	WebElement ProcceedtoCheckOutButton ;
	
	@FindBy (name="processAddress")
	WebElement proccessAddressButton ;
	
	@FindBy (id="cgv")
	WebElement TermsandCondition ;
	
	@FindBy (name="processCarrier")
	WebElement ProccessCarrierButton ;
	
	@FindBy (css = "[class= 'payment_module'] [title = 'Pay by bank wire']")
	WebElement PaybyBankWire;
	
	@FindBy (className="button btn btn-default button-medium")
	WebElement ConfirmOrder;
	
	@FindBy (css="class='cheque-indent'")
	WebElement OrderConfirm ;
	
	
	public OrderSummaryPageOR(){
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPageOR proceedCheckOut(){
		ProcceedtoCheckOutButton.click();
		return this;
	}
	
	public OrderSummaryPageOR proceedAddressCheckOut(){
		proccessAddressButton.click();
		return this;
	}
	
	public OrderSummaryPageOR checkTermsandConditon(){
		TermsandCondition.click();
		return this;
	}
	
	public OrderSummaryPageOR proceedCarrierCheckout(){
		ProccessCarrierButton.click();
		return this;
	}
	
	public OrderSummaryPageOR paybyBankWire(){
		PaybyBankWire.click();
		ConfirmOrder.click();
		return this;	
	}
	
	public String getConfirmationMessage(){
		return OrderConfirm.getText();
	}
	
}















