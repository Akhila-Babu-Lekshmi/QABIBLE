package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutility;

public class Detailviewpage {
	 WebDriver driver;
	Pageutility pageutility=new Pageutility();
	
	public Detailviewpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	public WebElement detailviewpageheading;
	
	@FindBy(xpath="//table[@id='w0']")
	public WebElement Detailviewtable;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr/td[1]")
	public WebElement Detailviewtableworkername;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[2]/td")
	public WebElement Detailviewtabletype;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[3]/td")
	public WebElement Detailviewtableamount;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[4]/td")
	public WebElement Detailviewtableeffectivedate;
	
	
    public boolean isDetailviewpageDisplayed()
    {
    	pageutility.isElementLoaded(detailviewpageheading, driver,25);
    	Boolean flg=true;
    	flg=detailviewpageheading.isDisplayed();
    	flg=Detailviewtable.isDisplayed();
    	return flg;
    			
    }
    
    public String getDetailedviewpageHeading()
	{
		String heading=detailviewpageheading.getText();
		return(heading);
		
	}
	
	public boolean isDetailviewtableDisplayed() {
		
		return(Detailviewtable.isDisplayed());
		
	}
	
	public String getWorkernameindetailviewtable() {
		pageutility.isElementLoaded(Detailviewtableworkername, driver, 25);
		return(Detailviewtableworkername.getText());
	}
	

	public String getdeductiontypeinDetailviewpage() {
		pageutility.isElementLoaded(Detailviewtabletype, driver, 25);
		return(Detailviewtabletype.getText());
	}
	
	public String getdeductionamountinDetailviewpage() {
		pageutility.isElementLoaded(Detailviewtableamount, driver, 25);
		return(Detailviewtableamount.getText());
	}
	
    public String getdeductioneffdatetinDetailviewpage() {
    	pageutility.isElementLoaded(Detailviewtableeffectivedate, driver, 25);
		return(Detailviewtableeffectivedate.getText());
	}
	
    public boolean isdetailviewpagenotdisplayedwhenfieldsremainblankinupdatepage() {
    	return(Detailviewtable.isDisplayed());
		
	}
}
