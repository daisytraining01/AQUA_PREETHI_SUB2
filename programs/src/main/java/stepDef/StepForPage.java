package stepDef;

import cucumber.PageMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepForPage {
	
	PageMethods code =new PageMethods();
	
	@Given("^I have url$")
	public void i_have_url()  
	{
		code.url();
	}
	
	@When("^I enter the login credentails$")
	public void i_enter_the_login_credentails()  
	{    
		code.loginCredentails();
	}
	
	@When("^Click the transfer tab and select accounts$")
	public void click_the_transfer_tab_and_select_accounts(){
		
		code.SelectAccounts();
	}
	
	@And("^Fill fund transfer details and submit$")
	public void Fill_fund_transfer_details() {
		
		code.FundTransferDetails();
	}
	
	/*@And("^Click the transfer button$")
	public void Click_the_fund_transfer_button() {
		
		code.TransferAmount();
	}*/
	
	@And("^Able to see the amount changes in accounts$")
	public void Able_to_see_the_amount_changes_in_accounts() {

		code.AmountDeductions();
	
	}
	
	@Then("^signout from application$")
	public void signout_from_application() {
		
		code.SignOut();
	}
	
	@When("^Click the transfer tab and select Add Receipts$")
	public void Click_the_transfer_tab_and_select_Add_Receipts() {
		
		code.SelectReceipts();
	}
	
	@And("^Fill the details of Receipt and click on Add Receipt$")
	public void Fill_the_details_of_Receipt() {
		
		code.fillReceiptDetails();
	}
	
	@And("^Able to see the successfull List of Receipts$")
	public void Able_to_see_the_successfull_List_of_Receipts() {
		
		
		
	}

}
