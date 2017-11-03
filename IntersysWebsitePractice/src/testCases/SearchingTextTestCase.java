package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import utilities.BrowserConfiguration;
import utilities.ConfigParameters;
import utilities.WebElementChecking;

public class SearchingTextTestCase {
	WebDriver driver;

    @BeforeTest
    public void setup(){

        this.driver = BrowserConfiguration.startBrowser(ConfigParameters.browserName, ConfigParameters.urlPage);

    }

    @Test
    public void invalidLogin(){
    		
    	HomePage homePageObj = new HomePage(driver);
        WebElementChecking elementChecker = new WebElementChecking(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.intersysconsulting.com/" );
        
        elementChecker.isElementLoaded(homePageObj.magnifyingGlassIcon);
        homePageObj.clickMagnifyingGlassIcon();
        
        elementChecker.isElementLoaded(homePageObj.searchTextBox);
        homePageObj.search("Subscription Services");
        homePageObj.searchTextBox.sendKeys(Keys.ENTER);
        
        String element = homePageObj.footerElements.getText();
        
        assertTrue(element.contains("Company"),"Company is not displayed into the Footer Menu");
       
    }

    @AfterTest
    public void close(){

        driver.close();

    }

}
