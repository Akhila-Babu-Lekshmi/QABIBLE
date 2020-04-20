package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utilities.Pageutility;

public class Updatedeductionpage {
	
    WebDriver driver;
    Pageutility pageutility=new Pageutility();
    public String typeselected;
    public String newamount;
    public String neweffdate;
   	public Updatedeductionpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//span/span/span/span/span")
	public WebElement nameinupdatededctnpage;//table/tbody/tr/td 
	
	@FindBy(xpath="//table/tbody/tr/td")
	public WebElement nameinwrkpage;
	
	@FindBy(xpath="//select[@id='deduction-type']")
	public WebElement updatetype;

	@FindBy(xpath="//*[@id=\"deduction-amount\"]")  
	public WebElement updateamount;        
	
	@FindBy(xpath="//input[@id='deduction-amount']")
	public WebElement updateamounttext;
	
	@FindBy(xpath="//*[@id=\"deduction-effective_from\"]")
	public WebElement updateeffdate;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[5]/div/button")
	public WebElement savebtn;
	
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li[1]/a")
	public WebElement dedafterupdate;
	
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	public WebElement updatedeductionpageheading;
	
	@FindBy(xpath=" //*[@id=\"select2-deduction-worker_id-container\"]")
	public WebElement namedropdownlist;
	
	@FindBy(xpath="//span/span[@class='select2-selection__clear']	")
	public WebElement namedropdownlistclear;
	
	@FindBy(xpath="//p[@class='help-block help-block-error ']")
	public WebElement workercannotbeblanklabel;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[2]/div/p")
	public WebElement Typecannotbeblanklabel;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[3]/div/p")
	public WebElement Amntcannotbeblanklabel;
	
	@FindBy(xpath="//*[@id=\"deduction-effective_from-kvdate\"]/span[2]")
	public WebElement cleardate;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[4]/div/p")
	public WebElement Datecannotbeblanklabel;
	
	public boolean isUpdatepageDisplayed() {
		
		pageutility.isElementLoaded(updatedeductionpageheading, driver,25);
		String updatepagehead=updatedeductionpageheading.getText();
		pageutility.isElementLoaded(savebtn, driver,20);
		return(updatedeductionpageheading.isDisplayed() && savebtn.isDisplayed());
	
	}
	
	public boolean isUpdatepagefieldsenabled() {
		Boolean flg=true;
		flg=(nameinupdatededctnpage.isEnabled() && updatetype.isEnabled() && updateamount.isEnabled() && updateeffdate.isEnabled() && savebtn.isEnabled());
		return(flg);
	}
	
	public String getWorkernameinUpdatedeductonpage() {
		
		pageutility.isElementLoaded(namedropdownlist, driver,30);
		return namedropdownlist.getText();
		
	}
	
	public String getdeductiontypeinUpadatedeductionpage() {
		return typeselected;
	}
	
	public String getdeductionamountinUpdatedeductionpage() {
		return  newamount;
	}
	
	public String geteffectivedateinUpdatedeductionpage() {
		return neweffdate;
	}
	
	public void enterValueinTypefield(String deductiontype) {
		pageutility.isElementLoaded(updatetype,driver,25);
		updatetype.click();
		Select slct1=new Select(updatetype);
		List<WebElement> dropdown =slct1.getOptions();
		for(int j=0;j<dropdown.size();j++)
		{
			slct1.selectByVisibleText(deductiontype);
		}
		typeselected=slct1.getFirstSelectedOption().getText();	
		
	}
	
	public void entervalueinAmountfield(double amount) {
		pageutility.isElementLoaded(updateamount, driver, 25);
		updateamount.clear();
		String str=String.valueOf(amount);
		updateamount.sendKeys(str);
		newamount=updateamounttext.getAttribute("value");
		
	}
	
	public void entervalueinEffectivedatefield(String date) {
		pageutility.isElementLoaded(updateeffdate, driver, 25);
		updateeffdate.click();
		updateeffdate.clear();
		updateeffdate.sendKeys(date);
		pageutility.isElementLoaded(savebtn, driver, 25);
		neweffdate=updateeffdate.getAttribute("value");
	}
	
	public void saveUpdatesmadebyUserinUpdatedeductionpage()
	{
		pageutility.elementisclickable(savebtn, driver,45);
		pageutility.javascriptscroll("scrollby", savebtn,driver);
		savebtn.click();
	  
			
	}
	
	public void clickOnnamedropdownlistclear() {
		pageutility.isElementLoaded(namedropdownlistclear, driver, 25);
		namedropdownlistclear.click();
		 
	}
	
	public void clearTypefieldinUpdatedeductionpage() {
		pageutility.isElementLoaded(updatetype, driver, 25);
		updatetype.click();
		pageutility.dropdownopt("-- Please Select --", updatetype, "ByVisibility");
	}
	
	public void clearAmountFieldinUpdatedeductionpage() {
		pageutility.isElementLoaded(updateamount, driver, 25);
		updateamount.click();
		updateamount.clear();
	}
	
	public void clearEffectivedateinUpdatedeductionpage() {
		pageutility.isElementLoaded(updateeffdate, driver, 25);
		cleardate.click();
	}
	
	public boolean isworkercannotbeblankmsgdisplayed() {
		clickOnnamedropdownlistclear();
		pageutility.isElementLoaded(workercannotbeblanklabel, driver, 25);
		boolean flg=true;
		flg=workercannotbeblanklabel.isDisplayed();
		String msgshown=workercannotbeblanklabel.getText();
		String msg="Worker cannot be blank.";
		flg=msg.equals(msgshown);
		return flg;
		
	}
	
	
	public boolean isTypecannotbeblankmsgdisplayed() {
		
		pageutility.isElementLoaded(updatetype, driver, 25);
		updatetype.click();
		pageutility.dropdownopt("-- Please Select --", updatetype, "ByVisibility");
		pageutility.isElementLoaded(Typecannotbeblanklabel, driver, 25);
		Boolean flg=true;
		flg=Typecannotbeblanklabel.isDisplayed();
		String labelshown=Typecannotbeblanklabel.getText();
		String expectedmsg="Type cannot be blank.";
		flg=labelshown.equals(expectedmsg);
		return flg;
	}
	
	public boolean isAmntcannotbeblankmsgdisplayed() {
		
		pageutility.isElementLoaded(updateamount, driver, 25);
		updateamount.click();
		updateamount.clear();
		pageutility.isElementLoaded(Amntcannotbeblanklabel, driver, 25);
		Boolean flg=true;
		flg=Amntcannotbeblanklabel.isDisplayed();
		String labelshown=Amntcannotbeblanklabel.getText();
		String expectedmsg="Amount cannot be blank.";
		flg=labelshown.equals(expectedmsg);
		return flg;
	}
	
	public boolean isdatecannotbeblankmsgdisplayed() {
		pageutility.isElementLoaded(updateeffdate, driver, 25);
		cleardate.click();
		pageutility.isElementLoaded(Datecannotbeblanklabel, driver, 25);
		Boolean flg=true;
		flg=Datecannotbeblanklabel.isDisplayed();
		String labelshown=Datecannotbeblanklabel.getText();
		String expectedmsg="Effective From cannot be blank.";
		return flg;
	}
	
	
	
}


	

