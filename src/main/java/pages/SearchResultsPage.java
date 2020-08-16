package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageBase{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
		jse = (JavascriptExecutor) driver;
	}

	@FindBy(css="span.available-now")
	WebElement InstockBtn;
	
	@FindBy(xpath="//a[@class='button ajax_add_to_cart_button btn btn-default']")
	WebElement AddToCartBtn;
	
	@FindBy(css="a.btn.btn-default.button.button-medium") 
	WebElement proceedToCheckoutBtn;
	
	
	public void ClickOnAddToCart() throws InterruptedException
	{
		Thread.sleep(3000);
		action.moveToElement(InstockBtn).moveToElement(AddToCartBtn).click().build().perform();
		Thread.sleep(3000);
	}
	
	public void ClickOnProceedToCheckout() throws InterruptedException
	{
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click();", proceedToCheckoutBtn);
	}
	
}
