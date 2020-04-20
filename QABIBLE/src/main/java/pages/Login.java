package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.Pageutility;

public class Login {
	static WebDriver driver;
	Pageutility pageutility=new Pageutility();
	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='loginform-username']")
	public WebElement Username;
	
	@FindBy(xpath="//input[@id='loginform-password']")
	public WebElement password;
	
	
	@FindBy(xpath="//button[@name='login-button']")
	public WebElement loginbutn;
	
	@FindBy(xpath="//a[contains(@href,'/payrollapp/deduction/index')]")
	public WebElement Deduction;
	
	@FindBy(xpath="//*[@id=\"login-form\"]/div[2]/p")
	public WebElement incorrectlabel;
	
	public boolean isloginPageloaded() {
		
		pageutility.isElementLoaded(password, driver,30);
		return(Username.isDisplayed() && password.isDisplayed()) ;
		
	}
	
	public void login(String username,String pasword)  {
	
		Username.clear();
	    Username.sendKeys(username);
	    password.clear();
	    password.sendKeys(pasword);
	    pageutility.elementisclickable(loginbutn, driver,25);
	    loginbutn.click();
    
    }
	
	public boolean isInvalidLoginmessagePresent() {
	
		pageutility.isElementLoaded(incorrectlabel, driver,30);
	    return(incorrectlabel.isDisplayed());
    
	}
	
}









	
	
	
	


