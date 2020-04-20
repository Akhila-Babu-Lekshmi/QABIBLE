package TestScripts;

import org.testng.annotations.Test;

import Utilities.Pageutility;
import pages.Createdeductionpage;
import pages.Deductionpage;
import pages.Detailviewpage;
import pages.Homepage;
import pages.Login;
import pages.Updatedeductionpage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RegressionTest extends TestHelper {
	 Pageutility pageutility =new Pageutility();
	 
 @Test
    public void verifyLoginpageLoaded() {
	  Login login=new Login(driver);
	  Assert.assertTrue(login.isloginPageloaded());
  }

   @Test
   public void verifyLoginwithValidcredentials() {
	   Login login=new Login(driver);
	   login.login("carol","1q2w3e4r");
	   Homepage homepage=new Homepage(driver);
	   Assert.assertTrue( homepage.isDeductiontabDisplayed());
   }  
   
   @Test
   public void verifyLoginwithinValidCredentials() {
	   Login login=new Login(driver);
	   login.login("akhila", "1234abc");
	   Assert.assertTrue(login.isInvalidLoginmessagePresent());
   } 
  
   
   @Test
  public void verifyHomepageisLoaded() {
  
    Login login=new Login(driver);
    login.login("carol","1q2w3e4r");
    Homepage homepage=new Homepage(driver);
    homepage.clickOndeduction();
    Assert.assertTrue(homepage.isDeductiontabDisplayed());
    Assert.assertTrue(homepage.isHomepagetabsdisplayed());
    
  }
  
    @Test
  public void verifyDeductionpageisLoaded() {
     
      Login login=new Login(driver);
      login.login("carol","1q2w3e4r");
      Homepage homepage=new Homepage(driver);
      homepage.clickOndeduction();
	  Deductionpage deductionpage=new Deductionpage(driver);
	  Assert.assertTrue(deductionpage.isDeductionpageDisplayed());
	  
  }
  
  
  @Test 
  public void verifyViewtooltipDisplayedinDeductionpage() {
     
      Login login=new Login(driver);
      login.login("carol","1q2w3e4r");
      Homepage homepage=new Homepage(driver);
      homepage.clickOndeduction();
	  Deductionpage deductionpage=new Deductionpage(driver);
	  Assert.assertTrue(deductionpage.isViewtooltipshownwhenmousehoveroneyeicon());
  
  }
  
  @Test
  public void verifyUpdatetooltipDisplayedinDeductionpage() {
     
      Login login=new Login(driver);
      login.login("carol","1q2w3e4r");
      Homepage homepage=new Homepage(driver);
      homepage.clickOndeduction();
	  Deductionpage deductionpage=new Deductionpage(driver);
	  Assert.assertTrue(deductionpage.isUpdatetooltipshownwhenmousehoveronPencilicon());
	  
  }
  
  @Test
  public void verifyisUserabletoSelectedRecordfromDeductionpagetoViewinDetail() 
  {   
      Login login=new Login(driver);
      login.login("carol","1q2w3e4r");
      Homepage homepage=new Homepage(driver);
      homepage.clickOndeduction();
	  Deductionpage deductionpage=new Deductionpage(driver);
	  deductionpage.clickOneyeicon();
	  Detailviewpage  detailviewpage =new Detailviewpage(driver);
	  Assert.assertTrue(detailviewpage.isDetailviewpageDisplayed());
	  Assert.assertTrue(detailviewpage.isDetailviewtableDisplayed());
	 
  }
  
 @Test 
  public void verifySelectedrecorditselfisShowninDetail()
  {
	  Login login=new Login(driver);
      login.login("carol","1q2w3e4r");
      Homepage homepage=new Homepage(driver);
      homepage.clickOndeduction();
	  Deductionpage deductionpage=new Deductionpage(driver);
	  String name= deductionpage.getworkername();
	  deductionpage.clickOneyeicon();
	  Detailviewpage detailviewpage =new Detailviewpage(driver);
	  Assert.assertEquals(detailviewpage.getWorkernameindetailviewtable(),name);
	 
  }
  
  @Test
   
      public void verifyFieldsinUpdateDeductionpageisEnabled() {
      Login login=new Login(driver);
      login.login("carol","1q2w3e4r");
      Homepage homepage=new Homepage(driver);
      homepage.clickOndeduction();
	  Deductionpage deductionpage=new Deductionpage(driver);
	  deductionpage.clickOnPencilicon();
	  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
	  Assert.assertTrue(updatedeductionpage.isUpdatepageDisplayed());
	  Assert.assertTrue(updatedeductionpage.isUpdatepagefieldsenabled());
	 
   }
   
  @Test
   public void verifyUserabletoSaveupdatesmade() {
	   
      Login login=new Login(driver);
      login.login("carol","1q2w3e4r");
      Homepage homepage=new Homepage(driver);
      homepage.clickOndeduction();
	  Deductionpage deductionpage=new Deductionpage(driver);
	  deductionpage.clickOnPencilicon();
	  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
	  updatedeductionpage.enterValueinTypefield("Locker Keys");
	  updatedeductionpage.entervalueinAmountfield(1700);
	  updatedeductionpage.entervalueinEffectivedatefield("14-04-2020");
	  updatedeductionpage.saveUpdatesmadebyUserinUpdatedeductionpage();
	  //updatedeductionpage.saveUpdatesmadebyUser("Rent",1111,"10-02-2020");//change name
	  Detailviewpage detailviewpage= new Detailviewpage(driver);
	  Assert.assertTrue(detailviewpage.isDetailviewpageDisplayed());
	 
	 }
   

 @Test
	  public void verifyAbletoAdddeduction() throws Exception
	  {
		 Login login=new Login(driver);
	     login.login("carol","1q2w3e4r");
	     Homepage homepage=new Homepage(driver);
	     homepage.clickOndeduction();
		 Createdeductionpage createdeductionpage= new Createdeductionpage (driver);
		 Assert.assertTrue(createdeductionpage.isadddeductiondisplayed());
		 createdeductionpage.clickOnAdddeduction();
		 createdeductionpage.enterValueinWorkerfieldinCreatedeductionfield("Timmy  Goldsmith");
		 createdeductionpage.enterValueinFieldTypeinCreatedeductionpage("Rent");
		 createdeductionpage.enterValueinFieldAmountinCreatedeductionpage(1200);
		 createdeductionpage.enterValueinFieldEffectivedateinCreateDeductionpage("01-01-2020");
		 createdeductionpage.saveDeductioninCreatedeductionpage();
		 Detailviewpage detailviewpage= new Detailviewpage(driver);
		 Assert.assertTrue(detailviewpage.isDetailviewpageDisplayed());
		 
	  }
	  
	   @Test
   public void verifyUpadatesMappedcorrectlyinDetailviewtable() {

	      Login login=new Login(driver);
	      login.login("carol","1q2w3e4r");
	      Homepage homepage=new Homepage(driver);
	      homepage.clickOndeduction();
		  Deductionpage deductionpage=new Deductionpage(driver);
		  deductionpage.clickOnPencilicon();
		  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
		  String workername=updatedeductionpage.getWorkernameinUpdatedeductonpage();
		  updatedeductionpage.enterValueinTypefield("Client Advance");
		  updatedeductionpage.entervalueinAmountfield(500.00);
		  updatedeductionpage.entervalueinEffectivedatefield("01-02-2020");
		  updatedeductionpage.saveUpdatesmadebyUserinUpdatedeductionpage();
		  String type=updatedeductionpage.getdeductiontypeinUpadatedeductionpage();
		  String amnt=updatedeductionpage.getdeductionamountinUpdatedeductionpage();
		  String date=updatedeductionpage.geteffectivedateinUpdatedeductionpage();
		  Detailviewpage detailviewpage= new Detailviewpage(driver);
		  Boolean flg=workername.contains(detailviewpage.getWorkernameindetailviewtable());
		  Assert.assertTrue(flg);
		  Assert.assertEquals(detailviewpage.getdeductiontypeinDetailviewpage(),type);
		  Assert.assertEquals(detailviewpage.getdeductioneffdatetinDetailviewpage(),date);
		  String amount=detailviewpage.getdeductionamountinDetailviewpage();
		  System.out.println(detailviewpage.getdeductionamountinDetailviewpage());
		  String a=detailviewpage.getdeductionamountinDetailviewpage();
		  String[] str= a.split(" ");  
		  Boolean flg1=detailviewpage.getdeductionamountinDetailviewpage().equals(str[1]);
		
}

 @Test
	 public void  verifyalertmsgonupdatingdeductionWithoutFillingMandatoryFieldworker() {
		 
		  Login login=new Login(driver);
	      login.login("carol","1q2w3e4r");
	      Homepage homepage=new Homepage(driver);
	      homepage.clickOndeduction();
		  Deductionpage deductionpage=new Deductionpage(driver);
		  deductionpage.clickOnPencilicon();
		  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
		  Assert.assertTrue(updatedeductionpage.isworkercannotbeblankmsgdisplayed());
		 
		  
	 }
	 
	 @Test
	 public void verifyalertmsgonupdatingdeductionWithoutFillingMandatoryFieldType() {
		  Login login=new Login(driver);
	      login.login("carol","1q2w3e4r");
	      Homepage homepage=new Homepage(driver);
	      homepage.clickOndeduction();
		  Deductionpage deductionpage=new Deductionpage(driver);
		  deductionpage.clickOnPencilicon();
		  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
		  Assert.assertTrue(updatedeductionpage.isTypecannotbeblankmsgdisplayed());
	 }
	 
	 @Test
	 public void verifyalertmsgonupdatingdeductionWithoutFillingMandatoryFieldAmount() {
		  Login login=new Login(driver);
	      login.login("carol","1q2w3e4r");
	      Homepage homepage=new Homepage(driver);
	      homepage.clickOndeduction();
		  Deductionpage deductionpage=new Deductionpage(driver);
		  deductionpage.clickOnPencilicon();
		  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
		  Assert.assertTrue(updatedeductionpage.isAmntcannotbeblankmsgdisplayed());
	 }
	 @Test
	 public void verifyalertmsgonupdatingdeductionWithoutFillingMandatoryFieldeffectivedate() {
		 Login login=new Login(driver);
	      login.login("carol","1q2w3e4r");
	      Homepage homepage=new Homepage(driver);
	      homepage.clickOndeduction();
		  Deductionpage deductionpage=new Deductionpage(driver);
		  deductionpage.clickOnPencilicon();
		  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
		  Assert.assertTrue(updatedeductionpage.isdatecannotbeblankmsgdisplayed());
		 
	 }
	
	 @Test
	 public void  verifyUserisstoppedfrommakingupdateswhenworkerfieldremainsblank() {
		 
		  Login login=new Login(driver);
	      login.login("carol","1q2w3e4r");
	      Homepage homepage=new Homepage(driver);
	      homepage.clickOndeduction();
		  Deductionpage deductionpage=new Deductionpage(driver);
		  deductionpage.clickOnPencilicon();
		  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
		  updatedeductionpage.clickOnnamedropdownlistclear();
		  updatedeductionpage.saveUpdatesmadebyUserinUpdatedeductionpage();
		  Assert.assertTrue(updatedeductionpage.isUpdatepageDisplayed());
		 
	 }
	 
	 @Test
	 public void  verifyUserisstoppedfrommakingupdateswhenTypefieldremainsblank() {
		 
		  Login login=new Login(driver);
	      login.login("carol","1q2w3e4r");
	      Homepage homepage=new Homepage(driver);
	      homepage.clickOndeduction();
		  Deductionpage deductionpage=new Deductionpage(driver);
		  deductionpage.clickOnPencilicon();
		  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
		  updatedeductionpage.clearTypefieldinUpdatedeductionpage();
		  updatedeductionpage.saveUpdatesmadebyUserinUpdatedeductionpage();
		  Assert.assertTrue(updatedeductionpage.isUpdatepageDisplayed());
} 

	 @Test
	 public void  verifyUserisstoppedfrommakingupdateswhenAmountfieldremainsblank() {
		 
		  Login login=new Login(driver);
	      login.login("carol","1q2w3e4r");
	      Homepage homepage=new Homepage(driver);
	      homepage.clickOndeduction();
		  Deductionpage deductionpage=new Deductionpage(driver);
		  deductionpage.clickOnPencilicon();
		  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
		  updatedeductionpage.clearAmountFieldinUpdatedeductionpage();
		  updatedeductionpage.saveUpdatesmadebyUserinUpdatedeductionpage();
		  Assert.assertTrue(updatedeductionpage.isUpdatepageDisplayed());
} 

	 @Test
	 public void  verifyUserisstoppedfrommakingupdateswhenDatefieldremainsblank() {
		 
		  Login login=new Login(driver);
	      login.login("carol","1q2w3e4r");
	      Homepage homepage=new Homepage(driver);
	      homepage.clickOndeduction();
		  Deductionpage deductionpage=new Deductionpage(driver);
		  deductionpage.clickOnPencilicon();
		  Updatedeductionpage updatedeductionpage= new Updatedeductionpage(driver);
		  updatedeductionpage.clearEffectivedateinUpdatedeductionpage();
		  updatedeductionpage.saveUpdatesmadebyUserinUpdatedeductionpage();
		  Assert.assertTrue(updatedeductionpage.isUpdatepageDisplayed());
} 
	  @Test
	   public void verifyalertmsgonAdddeductionWithoutFillingMandatoryFieldWorker(){
		   Login login=new Login(driver);
		   login.login("carol","1q2w3e4r");
		   Homepage homepage=new Homepage(driver);
		   homepage.clickOndeduction();
		   Createdeductionpage createdeductionpage= new Createdeductionpage (driver);
		   createdeductionpage.clickOnAdddeduction();
		   createdeductionpage.clearWorkerfieldinCreatedeductionpage("Belsin  Stephen");
		   Assert.assertTrue(createdeductionpage.isworkercannotbeblankmsgdisplayed());
	   }
	   
	  @Test
	  public void verifyalertmsgonAdddeductionWithoutFillingMandatoryFieldType(){
		  
		   Login login=new Login(driver);
		   login.login("carol","1q2w3e4r");
		   Homepage homepage=new Homepage(driver);
		   homepage.clickOndeduction();
		   Createdeductionpage createdeductionpage= new Createdeductionpage (driver);
		   createdeductionpage.clickOnAdddeduction(); 
		   createdeductionpage.clearTypefieldinadddeductionpage();
		   Assert.assertTrue(createdeductionpage.isTypecannotbeblankmsgDisplayed());
	  }
	 
	 @Test
	  public void verifyalertmsgonAdddeductionWithoutFillingMandatoryFieldAmount(){
		  
		   Login login=new Login(driver);
		   login.login("carol","1q2w3e4r");
		   Homepage homepage=new Homepage(driver);
		   homepage.clickOndeduction();
		   Createdeductionpage createdeductionpage= new Createdeductionpage (driver);
		   createdeductionpage.clickOnAdddeduction(); 
		   createdeductionpage.clearAmountfieldinadddeductionpage();
		   Assert.assertTrue(createdeductionpage.isAmountcannotbeblankmsgDisplayed());
	  }
	 

	 @Test
	  public void verifyalertmsgonAdddeductionWithoutFillingMandatoryFieldDate(){
		  
		   Login login=new Login(driver);
		   login.login("carol","1q2w3e4r");
		   Homepage homepage=new Homepage(driver);
		   homepage.clickOndeduction();
		   Createdeductionpage createdeductionpage= new Createdeductionpage (driver);
		   createdeductionpage.clickOnAdddeduction(); 
		   createdeductionpage.cleareffdatefieldinadddeductionpage();
		   Assert.assertTrue(createdeductionpage.isEffectiveFromcannotbeblankmsgDisplayed());
	  }
	   
	   @Test
	   public void verifyUserisstoppedfromcreatingupdateswhenWorkerfieldremainsblank() {
		   Login login=new Login(driver);
		   login.login("carol","1q2w3e4r");
		   Homepage homepage=new Homepage(driver);
		   homepage.clickOndeduction();
		   Createdeductionpage createdeductionpage= new Createdeductionpage (driver);
		   createdeductionpage.clickOnAdddeduction(); 
		   createdeductionpage.clearWorkerfieldinCreatedeductionpage("Luminita  Buzea");
		   createdeductionpage.enterValueinFieldTypeinCreatedeductionpage("Bonds");
		   createdeductionpage.enterValueinFieldAmountinCreatedeductionpage(3000);
		   createdeductionpage.enterValueinFieldEffectivedateinCreateDeductionpage("12-01-2019");
		   createdeductionpage.saveDeductioninCreatedeductionpage();
		   Assert.assertTrue(createdeductionpage.isCreateDeductionpageloaded());
	   }
	   

	   @Test
	   public void verifyUserisstoppedfromcreatingupdateswhenTypefieldremainsblank() {
		   Login login=new Login(driver);
		   login.login("carol","1q2w3e4r");
		   Homepage homepage=new Homepage(driver);
		   homepage.clickOndeduction();
		   Createdeductionpage createdeductionpage= new Createdeductionpage (driver);
		   createdeductionpage.clickOnAdddeduction(); 
		   createdeductionpage.enterValueinWorkerfieldinCreatedeductionfield("Radiana  Lungu");
		   createdeductionpage.clearTypefieldinadddeductionpage();
		   createdeductionpage.enterValueinFieldAmountinCreatedeductionpage(3000);
		   createdeductionpage.enterValueinFieldEffectivedateinCreateDeductionpage("12-01-2019");
		   createdeductionpage.saveDeductioninCreatedeductionpage();
		   Assert.assertTrue(createdeductionpage.isCreateDeductionpageloaded());
	   }
	   
	   @Test
	   public void verifyUserisstoppedfromcreatingupdateswhenAmountfieldremainsblank() {
		   Login login=new Login(driver);
		   login.login("carol","1q2w3e4r");
		   Homepage homepage=new Homepage(driver);
		   homepage.clickOndeduction();
		   Createdeductionpage createdeductionpage= new Createdeductionpage (driver);
		   createdeductionpage.clickOnAdddeduction(); 
		   createdeductionpage.enterValueinWorkerfieldinCreatedeductionfield("Radiana  Lungu");
		   createdeductionpage.enterValueinFieldTypeinCreatedeductionpage("Insurance");
		   createdeductionpage.clearAmountfieldinadddeductionpage();
		   createdeductionpage.enterValueinFieldEffectivedateinCreateDeductionpage("12-01-2019");
		   createdeductionpage.saveDeductioninCreatedeductionpage();
		   Assert.assertTrue(createdeductionpage.isCreateDeductionpageloaded());
	   }
	  
	   @Test
	   public void verifyUserisstoppedfromcreatingupdateswhenDatetfieldremainsblank() {
		   Login login=new Login(driver);
		   login.login("carol","1q2w3e4r");
		   Homepage homepage=new Homepage(driver);
		   homepage.clickOndeduction();
		   Createdeductionpage createdeductionpage= new Createdeductionpage (driver);
		   createdeductionpage.clickOnAdddeduction(); 
		   createdeductionpage.enterValueinWorkerfieldinCreatedeductionfield("Radiana  Lungu");
		   createdeductionpage.enterValueinFieldTypeinCreatedeductionpage("Training");
		   createdeductionpage.enterValueinFieldAmountinCreatedeductionpage(1455);
		   createdeductionpage.cleareffdatefieldinadddeductionpage();
		   createdeductionpage.saveDeductioninCreatedeductionpage();
		   Assert.assertTrue(createdeductionpage.isCreateDeductionpageloaded());
	   }
	   
	   @Test 
	   public void verifyLogoutfromDeductionpage() {
		   Login login=new Login(driver);
		   login.login("carol","1q2w3e4r");
		   Homepage homepage=new Homepage(driver);
		   homepage.clickOndeduction();
		   Deductionpage deductionpage=new Deductionpage(driver);
		   deductionpage.logoutFromDeductionpage();
		   Assert.assertTrue(login.isloginPageloaded());
	   }
}















  
   

  
  


