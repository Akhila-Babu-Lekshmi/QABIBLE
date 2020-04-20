package pages;

import static org.junit.Assert.assertTrue;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.Pageutility;

public class Homepage {
    WebDriver driver;
    Pageutility pageutility=new Pageutility();
    static boolean flg;
	public Homepage( WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	
	@FindBy(xpath="//a[contains(@href,'/payrollapp/site/index')]")
	public  WebElement Dashboard;
	
	@FindBy(xpath="//a[contains(@href,'/payrollapp/deduction/index')]")
	public WebElement Deduction;
	
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	public WebElement Deductionpagename;
	
	@FindBy(xpath="//a[contains(@href,'/payrollapp/timesheet/index')]")
	public WebElement Timesheet;
	
	@FindBy(xpath="//a[contains(@href,'/payrollapp/payslip/index')]")
	public WebElement Payslip;
	
	@FindBy(xpath="//a[contains(@href,'/payrollapp/invoice/index')]")
	public WebElement Invoice;
	
	@FindBy(xpath="//a[contains(@href,'/payrollapp/report/payslip')]")
	public WebElement Reports;
	
	
	public boolean isDeductiontabDisplayed()
	{   
		pageutility.isElementLoaded(Deduction,driver,30);
		return (Deduction.isDisplayed() && Dashboard.isDisplayed());

	}
	
	public boolean isHomepagetabsdisplayed() {
		
		flg=true;
		flg=(Dashboard.isDisplayed() && Timesheet.isDisplayed() && Payslip.isDisplayed() && Invoice.isDisplayed() && Reports.isDisplayed());
		return(flg);
	}
	public void clickOndeduction()
	{    
		pageutility.isElementLoaded(Deduction, driver,30);
		 Deduction.click();
	}
	
}
