package testcases;

import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageTest extends BaseClass{
	
	@Test
	public void Tc_001() throws InterruptedException {
	HomePage hp=new HomePage();
	hp.clickRevenueCal();
	hp.ScrollDown();
	//hp.adjustSlider();
	hp.updateText("560");
	hp.validateValue("560");
}
}