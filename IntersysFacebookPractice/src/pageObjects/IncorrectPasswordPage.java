package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IncorrectPasswordPage {
	WebDriver driver;

    //List all the required elements from Invalid Password page
    @FindBy(how = How.XPATH, using = "//a[@id='not_me_link']")
	public WebElement notMeLink;
    
    //Constructor
    public IncorrectPasswordPage(WebDriver lDriver){

        this.driver = lDriver;
        PageFactory.initElements(this.driver,this); // Initialize Invalid Password elements when a new object is created

    }

    // Incorrect Password Methods
    public void clickOnNotMeLink(){

        this.notMeLink.click();

    }
    
}
