package tests;

import org.testng.annotations.Test;

import pages.AuthenticationPage;
import pages.CheckoutProcedurePage;
import pages.HomePage;
import pages.OrderHistoryPage;
import pages.SearchResultsPage;

public class RegisteredUserCanOrderProductTest extends TestBase{

	HomePage homeObject;
	SearchResultsPage searchResultsObject;
	CheckoutProcedurePage CheckoutProcedureObject;
	AuthenticationPage authenticationObject;
	OrderHistoryPage orderHistoryObject;


	@Test(priority=1)    
	public void UserCanSelectBlousesFromWomenHoverMenu() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		Thread.sleep(2000);
		homeObject.SelectBlousesFromWomenMenu();
	}

	@Test(priority=2)
	public void AddToCart() throws InterruptedException
	{
		searchResultsObject = new SearchResultsPage(driver);
		searchResultsObject.ClickOnAddToCart();
	}


	@Test(priority=3)
	public void OrderProcessing() throws InterruptedException 
	{
		CheckoutProcedureObject = new CheckoutProcedurePage(driver);
		searchResultsObject.ClickOnProceedToCheckout();
		CheckoutProcedureObject.orderSummary();
		Thread.sleep(2000);
		CheckoutProcedureObject.AddressSelection();
		Thread.sleep(2000);
		CheckoutProcedureObject.shippingOption();
		Thread.sleep(2000);
		CheckoutProcedureObject.paymentMethod();
		Thread.sleep(2000);
		CheckoutProcedureObject.confirmOrder();
		Thread.sleep(2000);
		CheckoutProcedureObject.openOrdersPage();
	}

	@Test(priority=4)
	public void BlouseOrderValidation() throws InterruptedException
	{
		orderHistoryObject = new OrderHistoryPage(driver);
		orderHistoryObject.orderPlacementHistory();
	}


}
