package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		
		action = new Actions(driver);
		
	}
	
	@FindBy(linkText="Sign in")
	public WebElement signInBtn;
	
	
	@FindBy(xpath="//a[@class='sf-with-ul']")
	public WebElement womenMenu;

	@FindBy(xpath="//a[@title='Blouses']")
	public WebElement blousesMenu;
	
	
	
	public void openSignInPage() throws InterruptedException
	{
		Thread.sleep(3000);
		clicButton(signInBtn);
	}
	
	public void SelectBlousesFromWomenMenu() throws InterruptedException
	{
		Thread.sleep(3000);
		action.moveToElement(womenMenu).moveToElement(blousesMenu).click().build().perform();
	}

}
