package testing;

import org.testng.annotations.Test;

import pages.Homepage;

public class SmokeTest 
{

	Homepage homepage=new Homepage();
	
	@Test
	public void smokeTesting()
	{	    
	    homepage.openURL();
	    homepage.verifyTitle("Electron, Cars");
	}
}
