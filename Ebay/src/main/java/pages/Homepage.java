package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import base.Base;


public class Homepage extends Base
{

	By searchbox=By.xpath(("//input[@placeholder='Search for anything']")); 	  

	public void openURL()
	{
		driver.get(prop.getProperty("url"));  
	}  
	public void search()
	{
		driver.findElement(searchbox).sendKeys("outdoor toys");
		driver.findElement(searchbox).sendKeys(Keys.ENTER);
	}
}
