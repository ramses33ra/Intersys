package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.IncorrectPasswordPage;
import pageObjects.LoginPage;
import utilities.BrowserConfiguration;
import utilities.ConfigParameters;
import utilities.WebElementChecking;

public class InvalidLoginTestCase {
	WebDriver driver;

    @BeforeTest
    public void setup(){

        this.driver = BrowserConfiguration.startBrowser(ConfigParameters.browserName, ConfigParameters.urlPage);

    }

    @Test
    public void invalidLogin(){
    		
    	LoginPage loginPageObj = new LoginPage(driver);
        WebElementChecking elementChecker = new WebElementChecking(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/" );
        
        elementChecker.isElementLoaded(loginPageObj.emailInput);
        loginPageObj.enterUserName(ConfigParameters.emailAccount);
        
        elementChecker.isElementLoaded(loginPageObj.passwordInput);
        loginPageObj.enterPassword(ConfigParameters.passwordAccount);
        
        elementChecker.isElementLoaded(loginPageObj.loginButton);
        loginPageObj.clickOnLoginButton();

        IncorrectPasswordPage invalidPassPageObj = new IncorrectPasswordPage(driver);
        elementChecker.isElementLoaded(invalidPassPageObj.notMeLink);
        invalidPassPageObj.notMeLink.click();
        
        Assert.assertEquals("Log into Facebook | Facebook" , driver.getTitle());
      
    }

    @AfterTest
    public void close(){

        driver.close();

    }

}
