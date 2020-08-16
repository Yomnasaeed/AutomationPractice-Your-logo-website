package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AuthenticationPage extends PageBase{

	public AuthenticationPage(WebDriver driver) {
		super(driver);
		
		jse = (JavascriptExecutor) driver;
	
	}
	
	 //CREATE AN ACCOUNT
	@FindBy(id="email_create")
	WebElement EmailTxt;

	@FindBy(name="SubmitCreate")
	WebElement CreateAccountBtn;
	
	
	//YOUR PERSONAL INFORMATION
	@FindBy(id="id_gender2")
	WebElement TitleBtn;
	
	@FindBy(id="customer_firstname")
	WebElement fnTxt;
	
	@FindBy(id="customer_lastname")
	WebElement lnTxt;
	
	@FindBy(id="passwd")
	WebElement passwordTxt;
	
	@FindBy(id="days")
	WebElement birthDayList;
	
	@FindBy(id="months")
	WebElement birthMonthList;
	
	@FindBy(id="years")
	WebElement birthYearList;
	
	
	//YOUR ADDRESS
	@FindBy(id="firstname")
	WebElement addressFnTxt;
	
	@FindBy(id="lastname")
	WebElement addressLnTxt;
	
	@FindBy(id="address1")
	WebElement addressTxt;
	
	@FindBy(id="city")
	WebElement cityTxt;
	
	@FindBy(id="id_state")
	WebElement stateList;
	
	@FindBy(id="postcode")
	WebElement zipTxt;
	
	@FindBy(id="id_country")
	WebElement countryList;
	
	@FindBy(id="phone_mobile")
	WebElement mobileTxt;
	
	@FindBy(id="alias")
	WebElement aliasAddressTxt;
	
	@FindBy(id="submitAccount")
	WebElement RegisterBtn;
	
	@FindBy(css="a.logout")
	WebElement signOutBtn;
	
	@FindBy(css="span.navigation_page")
	public WebElement AuthenticationBreadCrumb;
	
	@FindBy(css="p.info-account")
	public WebElement successMsg;
	
	//ALREADY REGISTERED?
	@FindBy(id="email")
	public WebElement registeredEmailTxt;
	
	@FindBy(id="passwd")
	public WebElement registeredPasswordTxt;
	
	@FindBy(id="SubmitLogin") 
	public WebElement SignInBtn;
	
	
	
	public void openAuthenticationPage(String email) throws InterruptedException
	{
		Thread.sleep(3000);
		scrollToButtom();
		SetElementText(EmailTxt, email);
		clicButton(CreateAccountBtn);
	}
	
	public void openRegisterNewUser(String firstName, String lastName, String password, String firstName2, String lastName2, String address, String city, String postalCode, String mobile, String aliasAddress) throws InterruptedException
	{
		Thread.sleep(3000);
		clicButton(TitleBtn);
		SetElementText(fnTxt, firstName);
		SetElementText(lnTxt, lastName);
		SetElementText(passwordTxt, password);
		
		select = new Select(birthDayList);
		select.selectByIndex(3);
		
		select = new Select(birthMonthList);
		select.selectByIndex(3);
		
		select = new Select(birthYearList);
		select.selectByIndex(3);
		
		SetElementText(addressFnTxt, firstName);
		SetElementText(addressLnTxt, lastName);
		SetElementText(addressTxt, address);
		SetElementText(cityTxt, city);
		
		select = new Select(stateList);
		select.selectByIndex(1);
		
		SetElementText(zipTxt, postalCode);
		
		select = new Select(countryList);
		select.selectByIndex(1);
		
		SetElementText(mobileTxt, mobile);
		SetElementText(aliasAddressTxt, aliasAddress);
		clicButton(RegisterBtn);
	}
	
	public void signOut() throws InterruptedException
	{
		Thread.sleep(3000);
		clicButton(signOutBtn);
	}
	
	public void signIn(String email, String password) throws InterruptedException 
	{
		Thread.sleep(3000);
		SetElementText(registeredEmailTxt, email);
		SetElementText(registeredPasswordTxt,password);
		Thread.sleep(3000);
		clicButton(SignInBtn);
	}
}
