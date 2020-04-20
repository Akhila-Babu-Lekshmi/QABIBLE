package pages;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.sun.xml.bind.Util;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutility;

public class Deductionpage {
    WebDriver driver;
    static Actions actions ;
    
    public String updatewrkername;
    
    static boolean flg;
    static SoftAssert sftasrt= new SoftAssert();
    Pageutility pageutility=new Pageutility();
	public Deductionpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[@href='/payrollapp/deduction/index']")
	public WebElement Deduction;
	
	@FindBy(xpath="//a[@href='/payrollapp/deduction']")
	public WebElement subtabDeduction;
	
	@FindBy(xpath="//*[@id=\"w0\"]/table")
	public WebElement Table;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/thead/tr/th[2]/a ")
	public WebElement clmnwroker;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr/td/a") 
	public List<WebElement> colmnicon;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[4]/td[2]")
	public WebElement nameofrecordviewed;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[4]/td[7]/a[1]")
	public WebElement eyeiconofrecordviewed;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[6]/td[2]")
	public WebElement nameofwrkrupdatedindednpage;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']/tbody/tr[3]/td[7]/a[2]")
	public WebElement penciliconclicked;
	
	@FindBy(xpath="/html/body/header/div[1]/div/div[2]/div[1]/ul/li[2]/a")
	public WebElement UserLoggedin;
	
	@FindBy(xpath="/html/body/header/div[1]/div/div[2]/div[1]/ul/li[2]/ul/div/li[2]/a")
	public WebElement Logout;
	
	
	public boolean isDeductionpageDisplayed()
	{
	   
	   pageutility.visibilityofallelement(Table, Deduction, driver);
	   Boolean flg=true;
	   return flg;
	}
	
	public boolean isViewtooltipshownwhenmousehoveroneyeicon()
	{
		
		pageutility.visibilityofallelement(Table, Deduction, driver);
		pageutility.isElementLoaded(clmnwroker, driver,30);
		pageutility.moveCursortoElement(driver,eyeiconofrecordviewed);
		String label=eyeiconofrecordviewed.getAttribute("aria-label");
		if(eyeiconofrecordviewed.isDisplayed())
		{
			
			flg=label.contains("View");
		}
		return flg;
	}
		


	public boolean isUpdatetooltipshownwhenmousehoveronPencilicon()
	{
		
		pageutility.visibilityofallelement(Table,Deduction, driver);
		pageutility.isElementLoaded(clmnwroker, driver,30);
		pageutility.moveCursortoElement(driver,penciliconclicked);
		String label=penciliconclicked.getAttribute("aria-label");
		System.out.println(label);
		if(penciliconclicked.isDisplayed())
		{
			flg=label.contains("Update");
		}
		return flg;
	}
	
	public void clickOneyeicon()
	{   
		pageutility.isElementLoaded(nameofrecordviewed, driver,25);
		pageutility.isElementLoaded(eyeiconofrecordviewed, driver,25);
		eyeiconofrecordviewed.click();
		
	}
	 
   public String getworkername() {
	   
	   String workername=nameofrecordviewed.getText();
	   return(workername);
   }
   public void clickOnPencilicon()
   {
	   pageutility.isElementLoaded(nameofwrkrupdatedindednpage, driver,30);
	   updatewrkername=nameofwrkrupdatedindednpage.getText();
	   pageutility.isElementLoaded( penciliconclicked, driver,30);
	   penciliconclicked.click();
   }
   
   public void logoutFromDeductionpage() {
		
		 pageutility.isElementLoaded(UserLoggedin, driver, 25);
		 UserLoggedin.click();
		 pageutility.isElementLoaded(Logout, driver, 25);
		 Logout.click();
	}
   
    }
		







