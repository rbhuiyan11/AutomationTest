package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactsPageOR;
import com.ap.ui.pages.HomePage;

public class ContactTest extends TestBase {

	ContactsPageOR contactspage;
	HomePage homepage;
	
	public ContactTest(){
		super();
	}
	
	@BeforeMethod
	public void setUPdriver(){
		intialization();
		contactspage = new ContactsPageOR();
		homepage = new HomePage();
	}
	
	@Test
	public void testContacts(){
		homepage.clickOnContactLink();
		contactspage = contactspage.fillContactForm("Customer service", "Random@test.com", "Testing", "This is test purpose");
		
		contactspage.submitMessage();
		String successMsg = contactspage.getMessage();
		Assert.assertEquals(successMsg, "Your message has been successfully sen to our team.");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
