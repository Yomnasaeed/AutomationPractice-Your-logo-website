package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase{

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="order-list")
	WebElement orderDetailsWebTable;
	
	
	
	public void orderPlacementHistory() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("Order Details are: ");
		List<WebElement> rows = orderDetailsWebTable.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) 
		{
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols)
			{
				System.out.println(col.getText());
			}
		}
	}
}
