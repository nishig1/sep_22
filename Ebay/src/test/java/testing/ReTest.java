package testing;

import org.testng.annotations.Test;

import pages.Homepage;
import pages.Resultspage;

public class ReTest 
{
	Homepage homepage=new Homepage();
	Resultspage resultpage=new Resultspage();

	@Test
	public void reTesting()
	{		
		homepage.openURL();
		homepage.search();
		resultpage.verifyTitle("outdoor toys");
		resultpage.verifyTotalResults();
		resultpage.verifyProductsCount();
	}
}
