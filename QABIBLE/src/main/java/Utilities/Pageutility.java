package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Pageutility {
    public WebDriver driver;
	public Pageutility() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void handlesleep(int time) {
		 try {
			//Thread.sleep(time);
			 TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebElement moveCursortoElement(WebDriver driver,WebElement element) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		return element;
	}

   public void Screenshot(WebDriver driver) throws IOException
		  {
			  TakesScreenshot a=((TakesScreenshot)driver);
			   File Screen=a.getScreenshotAs(OutputType.FILE);
			   FileUtils.copyFile(Screen, new File("D://Images//"+System.currentTimeMillis()+".png"));
			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }	
   
   public WebElement isElementLoaded(WebElement elementToBeLoaded,WebDriver driver,int time) {
	    WebDriverWait wait = new WebDriverWait(driver, time);
	    WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
	    return element;
	}
     
    public WebElement visibilityofelement(WebElement elemnt,WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement element = wait.until(ExpectedConditions.visibilityOf(elemnt));
	   // wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	    return element;
	}
    
       public WebElement elementisclickable(WebElement elemnt,WebDriver driver,int time) {
	    WebDriverWait wait = new WebDriverWait(driver, time);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elemnt));
	   // wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	    return element;
	}
    public List<WebElement> visibilityofallelement(WebElement elemnt1,WebElement elemnt2,WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    List<WebElement> element =wait.until(ExpectedConditions.visibilityOfAllElements(elemnt2));
	    return element;
	}
   
    public Boolean titlecontain(String title,WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    Boolean element = wait.until(ExpectedConditions.titleContains(title));
	    return element;
	}
    
    public void tooltip(WebElement element, String tooltiptext)
    {
    	 
		String expectedtooltip= tooltiptext;
		WebElement tooltipelmnt=element;
		String actualtooltip= tooltipelmnt.getAttribute("title");
    	SoftAssert sftasrt= new SoftAssert();
	    sftasrt.assertEquals(actualtooltip, expectedtooltip);
	    sftasrt.assertAll();
		//System.out.println("tooltip text comparison passed");
	
	  }
    
    public void dropdown( WebElement element,String selectmethod,int index)
	  {
		  Select slct= new Select(element); 
		  slct.selectByIndex(index);	  
			  
	  }

	public void dropdownopt(String opt, WebElement element, String selectmethod)
	{
		// TODO Auto-generated method stub
		Select slct= new Select(element);
		  switch(selectmethod)
		  {
		  case "ByValue":
		  List<WebElement> dropdown =slct.getOptions();
			String value=opt;
			for(WebElement optdisp: dropdown)
			{	
			if(value.equals(optdisp.getText()))
				{
				slct.selectByValue(optdisp.getText());
				//System.out.println("The day selected is "+ optdisp.getText());
				break;
				}
			}
		  case "ByVisibility":
			 slct.selectByVisibleText(opt);
			 break;
		  default:
				System.out.println();  
		  }
	}
	
	public void javascriptscroll(String scrolltype, WebElement element,WebDriver driver)
	 {    JavascriptExecutor js= (JavascriptExecutor) driver;  
		  switch(scrolltype)
		  {
		  case"scrollby":
		  js.executeScript("window.scrollBy(0,1000)");	
		  break;
		  case"byelement":
		  js.executeScript("arguments[0].scrollIntoView(true);",element);
		  break;
		  case"scrollto":
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  break;
	      }
	}
} 
  
