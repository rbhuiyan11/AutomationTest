package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;

public class TestBase {
// below is setting up the property value for this class
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver;  //kick starts the driver
	public static WebEventListener eventlistener;  //sends the events that take place to the ExtendReporter...LOGGING ALL EVENTS THAT ARE HAPPENING
	
	public TestBase(){  /// this is also a constructor for class,  ipa is a new object...and using try and catch method along with IOexception to minimize errors occurring
		try{ 
			propt = new Properties();
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir")+"/Automation.test1/src/main/java/com/ap/ui/config/config.properties"); ///creating a path of where the information wil come from
			propt.load(ipa); // invoking an object
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void intialization(){   //this is a method....invoking whiCH browser you want to use. 
		String browserName = propt.getProperty("browser");
				if(browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
		}
				else if (browserName.equalsIgnoreCase("IE")) {
					System.setProperty("webdriver.ie.driver", " IN HERE WILL BE THE FILE PATH OF THE DRIVER ");
					driver = new InternetExplorerDriver();
				}
				
				else if (browserName.equalsIgnoreCase("FF")) {
					System.setProperty("webdriver.gecko.driver", " IN HERE WILL BE THE FILE PATH OF THE DRIVER ");
					driver = new FirefoxDriver ();
				}
				
				//when you want to kick start and initializing the driver to call on the actions and  for the listeners to take note of the events that are occurring.
				//and object for the driver needs to be done because it is easier to call the object that the driver itself many times over. 
				///this is catch all the events happening in a separate place 
				
				//CREATING an object for an action thats occurring and sharing with the driver
				en_driver = new EventFiringWebDriver(driver);
				
				//creating object of webeventlistener to register it with eventFiringWebdriver
				eventlistener = new WebEventListener();
				
				//event can be captured based on the method we create on WebEventListener class
				en_driver.register(eventlistener);  //register is to log the events...unregister is to not log the events
				
				//since we driver object is for browser AND en_driver is for event. THAT IS TAKING PLACE we declaring with equal to each when they are exchanging the information.
				driver = en_driver;
				
				//invoking the actions of the browser
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load, TimeUnit.SECONDS);
				
				driver.get(propt.getProperty("url"));
				
				
	}
}	



/*
else if (browserName.equalsIgnoreCase("ME")){
System.setProperty("webdriver.gecko.driver", "")
driver = new MicrosoftedgeDriver();
} */