package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutProcedurePage extends PageBase{

	public CheckoutProcedurePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}


	@FindBy(css="a.button.btn.btn-default.standard-checkout.button-medium")
	WebElement proceedToCheckoutBtn;
	
	@FindBy(css="button.button.btn.btn-default.button-medium")
	WebElement proceedToCheckout_AddressBtn;
	
	@FindBy(id="cgv")
	WebElement TermsOfServiceCheckBox;
	
	@FindBy(name="processCarrier")
	WebElement proceedToCheckout_ShippingBtn;
	
	@FindBy(className="payment_module")
	WebElement bankWireOptionBtn;
	
	@FindBy(css="button.button.btn.btn-default.button-medium")
	WebElement orderConfirmationBtn;
	
	@FindBy(css="a.button-exclusive.btn.btn-default")
	WebElement backToOrdersBtn;
	
	
	public void orderSummary() throws InterruptedException
	{
		Thread.sleep(3000);
		clicButton(proceedToCheckoutBtn);
	}
	
	public void AddressSelection() throws InterruptedException
	{
		Thread.sleep(3000);
		scrollToButtom();
		clicButton(proceedToCheckout_AddressBtn);
	}
	
	public void shippingOption() throws InterruptedException
	{
		Thread.sleep(3000);
		clicButton(TermsOfServiceCheckBox);
		clicButton(proceedToCheckout_ShippingBtn);
	}
	
	public void paymentMethod() throws InterruptedException
	{
		Thread.sleep(3000);
		clicButton(bankWireOptionBtn);
	}
	
	public void confirmOrder() throws InterruptedException
	{
		Thread.sleep(3000);
		clicButton(orderConfirmationBtn);
	}
	
	public void openOrdersPage() throws InterruptedException
	{
		Thread.sleep(3000);
		clicButton(backToOrdersBtn);
	}
}
