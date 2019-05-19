/* this class we have created, WebDriverEventListener, was made  in order to implement interface and to override all the methods 
and define certain  helpful log actions which would be displayed/logged as the application under testing is being executed. These methods 
will be invoked by itself automatically when certain action performed. Ex: click, submit, screenshot, findby, etc.*/
 

package com.ap.ui.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;  //this import automatically part of the selenium jar file if downloaded correctly

import com.ap.ui.base.TestBase;

// first you have your class WBL and your bring your parent class Testbase to build that connection to the property and browser execution actions and the implementing the interface of WDEL to bring in the abstract class 
public class WebEventListener extends TestBase implements WebDriverEventListener{
	
	public void beforeNavigate(String url, WebDriver driver){
		System.out.println("Before navi to:'" + url + "'");
	}
	
	public void aftereNavigate(String url, WebDriver driver){
		System.out.println("Navigate to: '" + url + "'");
		
	}
	
	
	public void beforeChangeValueof(WebElement element, WebDriver Driver){  // these method are never overridden but only used once 
		System.out.println("Value of: "+ element.toString() + "before making any change");
	}
	public void afterChangeValueof(WebElement element, WebDriver Driver){
		System.out.println("Element Value changed to:  "+ element.toString());
	}
	
	
	public void beforeClickingOn(WebElement element, WebDriver Driver){  // this is constantly happening again
		System.out.println("Attempting to click on: " + element.toString());
	}
	
	public void afterClickingOn(WebElement element, WebDriver Driver){
		System.out.println("Successfully Clicked on: "+ element.toString());
	}
	
	
	public void beforeNavigatingback(WebDriver Driver){
		System.out.println("Navigating back to the previous page");
	}
	
	public void afterNavigatingback(WebDriver Driver){
		System.out.println("Navigating to next page");
	}
	
	
	public void beforeNavigatingforward(WebDriver Driver){
		System.out.println("Attempting Navigating forward to next page");
	}
	
	public void afterNavigatingforward(WebDriver Driver){
		System.out.println("Successfully Navigating forward to next page");
	}
	
	// this allows to take screen shot and the error that happens along with it 
	public void duetoException(Throwable error, WebDriver Driver){    
		System.out.println("Exception occurred: " + error);
		try {
	TestUtil.takeScreenshotAt();
		} catch (IOException e ){
			e.printStackTrace();
		}	
	}
	

	public void beforeFindBy(By by, WebElement element, WebDriver Driver){
		System.out.println("Attempting Find the element: " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver Driver){
	System.out.println("Successfully Found the element: " + by.toString());
}

//these below are non overridden methods of the WebListener class
	public void beforeScript(String script, WebDriver Driver){
		
	}
	
	 //^ and the one below these two lines are about what o do before and after running the script 
	
	//these below are non overridden methods of the WebListener class
	public void afterScript(String script, WebDriver Driver){
		
	}
	
	//these below are non overridden methods of the WebListener class
	public void beforeAcceptingAlert(WebDriver Driver){
		
	}
	//these below are non overridden methods of the WebListener class
	public void afterAcceptingAlert(WebDriver Driver){
		
	}
	
	//these below are non overridden methods of the WebListener class
	public void beforeDismissingALert(WebDriver Driver){
		
	}
	//these below are non overridden methods of the WebListener class
	public void afterDismissingALert(WebDriver Driver){
		
	}

	//these below are non overridden methods of the WebListener class
	public void beforeNavigateRefresh(WebDriver Driver){
		
	}
	//these below are non overridden methods of the WebListener class
	public void afterNavigateRefresh(WebDriver Driver){
		
	}

	//these below are non overridden methods of the WebListener class
	public void beforeChangeValueof(WebElement element, WebDriver Driver, CharSequence[] keysToSend){
		
	}
	//these below are non overridden methods of the WebListener class
	public void afterChangeValueof(WebElement element, WebDriver Driver,CharSequence[] keysToSend){
		
	}

	//these below are non overridden methods of the WebListener class
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0){      // this screenshot take the image and then puts it/files it away somewhere and this one put its in the EXtendreport
		 /// this is a dynamic coding and just takes any image no matter what it is you want or looking for you dont have to be SPECIFIC 
	}
	//these below are non overridden methods of the WebListener class
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1){    // this screenshot take the image and then puts it/files it away somewhere and this one put its in the EXtendreport
		 /// this is a dynamic coding and just takes any image no matter what it is you want or looking for you dont have to be SPECIFIC  this is will be saved by TIME AND DATE no need for a actually label 
// this one has to do 2 things.. take the image and then save it somewhere. 
	}

	//these below are non overridden methods of the WebListener class
	public void beforeGetText(WebElement arg0, WebDriver arg1){
		
	}
	//these below are non overridden methods of the WebListener class
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2){
		
	}

	//these below are non overridden methods of the WebListener class
	public void beforeSwitchToWindow(String arg0, WebDriver arg1){
		
	}
	//these below are non overridden methods of the WebListener class
	public void afterSwitchToWindow(String arg0, WebDriver arg1){
		
}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
}
	