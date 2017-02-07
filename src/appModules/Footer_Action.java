package appModules;


import pageObjects.Home_Page;
import utility.Log;
import utility.Utils;

public class Footer_Action {
	public static String sTAGNAME; 
	
		
	
	public static void FooterLinkVerification_Customer_Public(int iTestCaseRow) throws Exception{
		 
		try{Home_Page.Footer_Section.Help_FAQ().click();
		Utils.PageHeaderCheck(" FAQ | Shoppers Stop");

		Home_Page.Footer_Section.Track_Order().click();
		Utils.PageHeaderCheck(" Shoppers Stop");

		Home_Page.Footer_Section.Size_Guide().click();;
		Utils.PageHeaderCheck(" Size Guide | Shoppers Stop");

		Home_Page.Footer_Section.Buying_Guide().click();;
		Utils.PageHeaderCheck(" BuyingGuide | Shoppers Stop");

		Home_Page.Footer_Section.How_To_Buy().click();;
		Utils.PageHeaderCheck(" Purchase | Shoppers Stop");

		Home_Page.Footer_Section.How_To_Pay().click();
		Utils.PageHeaderCheck(" How do I pay Template | Shoppers Stop");

		Home_Page.Footer_Section.Place_We_Deliever().click();
		Utils.PageHeaderCheck(" Shoppers Stop");
		
		//Home_Page.Footer_Section.Blog().click();
		//Utils.PageHeaderCheck("SHOPPERSSTOP | START SOMETHING NEW");

		Log.info("Verification check has been completed for FooterLinks- Public View");
 
	    }catch(Exception e){
 
Log.info("Verification check Failed  for Footer Links- Public View");			
 
	    	throw(e);
 
			}
 
		}
	
	
	
	public static void FooterLinkVerification_Private(int iTestCaseRow) throws Exception{
		 
		try{
			
			Home_Page.Footer_Section.Help_FAQ().click();
			Utils.PageHeaderCheck(" FAQ | Shoppers Stop");

			Home_Page.Footer_Section.Track_Order().click();
			Utils.PageHeaderCheck(" Shoppers Stop");

			Home_Page.Footer_Section.Size_Guide().click();;
			Utils.PageHeaderCheck(" Size Guide | Shoppers Stop");

			Home_Page.Footer_Section.Buying_Guide().click();;
			Utils.PageHeaderCheck(" BuyingGuide | Shoppers Stop");

			Home_Page.Footer_Section.How_To_Buy().click();;
			Utils.PageHeaderCheck(" Purchase | Shoppers Stop");

			Home_Page.Footer_Section.How_To_Pay().click();
			Utils.PageHeaderCheck(" How do I pay Template | Shoppers Stop");

			Home_Page.Footer_Section.Place_We_Deliever().click();
			Utils.PageHeaderCheck(" Shoppers Stop");
			
			//Home_Page.Footer_Section.Blog().click();
			//Utils.PageHeaderCheck("SHOPPERSSTOP | START SOMETHING NEW");

			Log.info("Verification check has been completed for FooterLinks- Public View");	

 
	    }catch(Exception e){
 
Log.info("Verification check Failed  for Footer Links- Private View");			
 
	    	throw(e);
 
			}
 
		}	
	
}

