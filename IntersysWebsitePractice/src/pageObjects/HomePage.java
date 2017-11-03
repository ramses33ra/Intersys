package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

    //List all the required Web Elements from Intersys Home page

    @FindBy(how = How.ID, using ="searchToggle")
    public WebElement magnifyingGlassIcon;

    @FindBy(how = How.XPATH, using = "//input[@title='Search for:']")
    public WebElement searchTextBox;
    
    @FindBy(how = How.ID, using = "menu-footer-menu")
    public WebElement footerElements;

    //Constructor
    public HomePage(WebDriver lDriver){

        this.driver = lDriver;
        PageFactory.initElements(this.driver, this); // Initialize Login page elements when a new object is created

    }

    //Login Page Methods
    public void clickMagnifyingGlassIcon(){

        this.magnifyingGlassIcon.click();

    }

    public void search(String searchTopic){

        this.searchTextBox.sendKeys(searchTopic);
    }

}
