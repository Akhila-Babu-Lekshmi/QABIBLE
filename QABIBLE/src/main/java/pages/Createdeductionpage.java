package pages;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Pageutility;

public class Createdeductionpage {
    
	WebDriver driver;
    Pageutility pageutility=new Pageutility();
	public Createdeductionpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li[2]/a")
	public WebElement Adddeduction;
	
	@FindBy(xpath="//span[@id='select2-deduction-worker_id-container']")
	public WebElement DrpdwnWorker;
	
	@FindBy(xpath="//select[@id='deduction-type']")
	public WebElement DrpdwnType;
	
	@FindBy(xpath="//input[@id='deduction-amount']")
	public WebElement Adddedamount;
	
	@FindBy(xpath="//input[@id='deduction-effective_from']")
	public WebElement AdddedEffectivedatefrm;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[5]/div/button")
	public WebElement AdddedSavebtn;
	    //button[@class='btn btn-success']
	@FindBy(xpath="//*[@id=\"w0\"]/div[1]/div/span/span[1]/span/span[2]")
	public WebElement Wrkrdrpdnarw;
	
	@FindBy(xpath="//select[@name='Deduction[worker_id]']")
	public WebElement adddedWrkrdrpdn;
	
	@FindBy(xpath="//select[@id='deduction-worker_id']")
	public WebElement adddedWrkrdrpdnoptns;
	
	@FindBy(xpath="//select[@name='Deduction[worker_id]']")  
	public List<WebElement> drpdwnoption;
	
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	public WebElement Wrkrdrpdnsrch;
	
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	public WebElement Adddeductionheading;
	
	@FindBy(xpath="//form[@id=\"w0\"]/div[1]/div/span[1]/span/span/span/span")
	public WebElement AdddedNameClear;//*[@id=\"select2-deduction-worker_id-container\"]/span
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[1]/div/p")
	public WebElement AdddeductionNamealertmsg;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[2]/div/p")
	public WebElement AdddeductionTypealertmsg;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[3]/div/p ")
	public WebElement AdddeductionAmountalertmsg;
	
	@FindBy(xpath="//*[@id=\"deduction-effective_from-kvdate\"]/span[2]")
	public WebElement cleareffdate;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[4]/div/p")
	public WebElement AdddeductionDatealertmsg;
	
	
	public boolean isadddeductiondisplayed()
	{
		return (Adddeduction.isDisplayed());
	}
	
	public boolean isaddDeductionClickable() {
		
		return (Adddeduction.isEnabled());
	}
	
	public boolean isCreateDeductionpageloaded() {
		
		pageutility.isElementLoaded(Adddeductionheading, driver,25);
		return(Adddeductionheading.isDisplayed());
	}
	
	public void clickOnAdddeduction() {
		
		Adddeduction.click();
	}
	
	public String isAdddeductionclicked() {
		
		pageutility.elementisclickable(Adddeduction, driver,25);
		Adddeduction.click();
		pageutility.isElementLoaded(Adddeductionheading, driver,25);
		return(Adddeductionheading.getText());
		
	}
	
	public void enterValueinWorkerfieldinCreatedeductionfield(String name) {
		pageutility.isElementLoaded(Wrkrdrpdnarw,driver,25);
	    pageutility.elementisclickable(Adddeduction, driver,25);
		Wrkrdrpdnarw.click();
		Wrkrdrpdnsrch.sendKeys(name);
		Wrkrdrpdnsrch.sendKeys(Keys.RETURN);
	}
	
	public void enterValueinFieldTypeinCreatedeductionpage(String type) {
		
		pageutility.elementisclickable(DrpdwnType, driver,45);
		Select slct1= new Select(DrpdwnType);
		DrpdwnType.click();
		List<WebElement> dropdown1 =slct1.getOptions();
		for(int i=1;i<dropdown1.size();i++)
		{	
			slct1.selectByVisibleText(type);	
		}
	}
	
	public void enterValueinFieldAmountinCreatedeductionpage(int amount) {
		pageutility.isElementLoaded(Adddedamount,driver,25);
		Adddedamount.click();
		String str=String.valueOf(amount);
		Adddedamount.sendKeys(str);
		
	}
	
	public void enterValueinFieldEffectivedateinCreateDeductionpage(String date) {
		
		pageutility.isElementLoaded(AdddedEffectivedatefrm,driver,25);
		AdddedEffectivedatefrm.click();
		AdddedEffectivedatefrm.clear();
		AdddedEffectivedatefrm.sendKeys("01-01-2020");
	}
	public void saveDeductioninCreatedeductionpage() {
		
	    /*pageutility.isElementLoaded(Wrkrdrpdnarw,driver,25);
	    pageutility.elementisclickable(Adddeduction, driver,25);
		Wrkrdrpdnarw.click();
		Wrkrdrpdnsrch.sendKeys(name);
		Wrkrdrpdnsrch.sendKeys(Keys.RETURN);////////////
		pageutility.elementisclickable(DrpdwnType, driver,45);
		Select slct1= new Select(DrpdwnType);
		DrpdwnType.click();
		List<WebElement> dropdown1 =slct1.getOptions();
		for(int i=1;i<dropdown1.size();i++)
		{	
			slct1.selectByVisibleText(type);	
		}/////
		Adddedamount.click();
		String str=String.valueOf(amount);
		Adddedamount.sendKeys(str);
		AdddedEffectivedatefrm.click();
		AdddedEffectivedatefrm.sendKeys("01-01-2020");*/
		pageutility.elementisclickable(AdddedSavebtn, driver, 30);
		pageutility.javascriptscroll("byelement", AdddedSavebtn, driver);
		AdddedSavebtn.click();
		
        }
	
	public void clearWorkerfieldinCreatedeductionpage(String name) {
		pageutility.isElementLoaded(Wrkrdrpdnarw,driver,25);
		Wrkrdrpdnarw.click();
		pageutility.isElementLoaded(Wrkrdrpdnsrch,driver,25);
		Wrkrdrpdnsrch.sendKeys(name);
		Wrkrdrpdnsrch.sendKeys(Keys.RETURN);
		AdddedNameClear.click();
	}
	
	public boolean isworkercannotbeblankmsgdisplayed() {
		
		pageutility.isElementLoaded(AdddeductionNamealertmsg,driver,25);
		Boolean flg=AdddeductionNamealertmsg.isDisplayed();
		return flg;
	}
	
	public void clearTypefieldinadddeductionpage() {
		pageutility.isElementLoaded(DrpdwnType, driver, 25);
		DrpdwnType.click();
		pageutility.dropdownopt("-- Please Select --", DrpdwnType, "ByVisibility");
		DrpdwnType.sendKeys(Keys.RETURN);
		Adddedamount.click();
	}
	
    public boolean isTypecannotbeblankmsgDisplayed() {
		
		pageutility.isElementLoaded(AdddeductionTypealertmsg,driver,25);
		Boolean flg=AdddeductionTypealertmsg.isDisplayed();
		return flg;
	}
    
    public void clearAmountfieldinadddeductionpage() {
		pageutility.isElementLoaded(Adddedamount, driver, 25);
		Adddedamount.click();
		Adddedamount.sendKeys(Keys.RETURN);
		AdddedEffectivedatefrm.click();
		}
    
   public boolean isAmountcannotbeblankmsgDisplayed() {
		
		pageutility.isElementLoaded(AdddeductionAmountalertmsg,driver,25);
		Boolean flg=AdddeductionAmountalertmsg.isDisplayed();
		return flg;
	}
    
   public void cleareffdatefieldinadddeductionpage() {
		pageutility.isElementLoaded(AdddedEffectivedatefrm, driver, 25);
	    cleareffdate.click();
		}
   
   public boolean isEffectiveFromcannotbeblankmsgDisplayed() {
		
		pageutility.isElementLoaded(AdddeductionDatealertmsg,driver,30);
		Boolean flg=AdddeductionDatealertmsg.isDisplayed();
		return flg;
	}
   
}
