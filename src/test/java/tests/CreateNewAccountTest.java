package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import data.ExcelReader;
import pages.AuthenticationPage;
import pages.HomePage;

public class CreateNewAccountTest extends TestBase{
	
	HomePage homeObject;
	AuthenticationPage authenticationObject;
	Faker fakeData = new Faker();
	String email = fakeData.internet().emailAddress();
	
	
	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		ExcelReader ER = new ExcelReader();
		
		return ER.getExcelData();
	}

	
	@Test(priority=1, dataProvider="ExcelData")
	public void CreateAndAuthenticateNewUser(String firstName, String lastName, String password, String firstName2, String lastName2, String address, String city, String postalCode, String mobile, String aliasAddress) throws InterruptedException
	{
		//Registration & Sign out
		homeObject = new HomePage(driver);
		homeObject.openSignInPage();
		authenticationObject = new AuthenticationPage(driver);
		Thread.sleep(2000);
		authenticationObject.openAuthenticationPage(email);
		Assert.assertEquals(authenticationObject.AuthenticationBreadCrumb.getText(), "Authentication");
		Thread.sleep(3000);
		authenticationObject.openRegisterNewUser(firstName, lastName, password, firstName2, lastName2, address, city, postalCode, mobile, aliasAddress);
		Thread.sleep(2000);
		Assert.assertEquals(authenticationObject.successMsg.getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
		Thread.sleep(2000);
		authenticationObject.signOut();
		Assert.assertTrue(driver.getTitle().contains("Login"));
		
		//Authentication
		homeObject.openSignInPage();
		Thread.sleep(2000);
		authenticationObject.signIn(email, password);
		Assert.assertEquals(authenticationObject.successMsg.getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
	}
	
}
