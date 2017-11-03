package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

    //List all the required Web Elements from Facebook Login page

    @FindBy(how = How.ID, using ="email")
    public WebElement emailInput;

    @FindBy(how = How.ID, using = "pass")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "loginbutton")
    public WebElement loginButton;

    //Constructor
    public LoginPage(WebDriver lDriver){

        this.driver = lDriver;
        PageFactory.initElements(this.driver, this); // Initialize Login page elements when a new object is created

    }

    //Login Page Methods
    public void enterUserName(String username){

        this.emailInput.sendKeys(username);

    }

    public void enterPassword(String password){

        this.passwordInput.sendKeys(password);
    }

    public void clickOnLoginButton(){

        this.loginButton.click();
    }

}
