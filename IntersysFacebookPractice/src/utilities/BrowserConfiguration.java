package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfiguration {
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url){
		
		if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver","C://Selenium//ChromeDriver//chromedriver.exe");
			
			//Disable the browser notifications to avoid a black screen once Facebook is opened
			ChromeOptions options = new ChromeOptions(); //Instantiate an Object of ChromeOptions Class
			options.addArguments("--disable-notifications"); //Disable Notification using addArguments method
			
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.firefox.driver", "C://Selenium//FireFoxDriver//gechodriver.exe");
			
			driver = new FirefoxDriver();
			
		}else{
			
			System.out.println("Invalid Browser Name, please provide a valid Browser Name to proceed with the Test Cases Execution");
		
		}
		
		driver.manage().window().maximize();
        driver.get(url);
        return driver;
		
	}
	
}
