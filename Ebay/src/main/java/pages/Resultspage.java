package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import base.Base;

public class Resultspage extends Base
{

	By total=By.cssSelector("h1.srp-controls__count-heading");   ////    //h1[@class='     ']
	By results=By.cssSelector("div.s-item__title span");     ////    //div[@class='s-item__title']/span

	public void verifyTotalResults()
	{
		String str=driver.findElement(total).getText();
		int totalvalue=Integer.parseInt(str.split("\\+")[0].replace(",",""));
		test=report.createTest("Verify Total Result");
		if(totalvalue>=10000)
		{		
			test.log(Status.PASS, "Total value is > 10000");
		}
		else
		{		
			test.log(Status.FAIL, "Total value is NOT > 10000");
		}
	}
	public void verifyProductsCount()
	{
		List<WebElement> lst= driver.findElements(results);
		List<String> products=new ArrayList<String>();
		for(WebElement x : lst)
		{
			if(x.getText().contains("Portable"))
			{
				products.add(x.getText());
			}
		}
		test=report.createTest("Verify Total Portable products");
		if(products.size()>=10)
		{
			test.log(Status.PASS,"Total portable products are >10");
		}
		else
		{
			test.log(Status.FAIL,"Total portable products NOT >10");
		}

	}
}
