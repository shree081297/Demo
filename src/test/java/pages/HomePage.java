package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import testcases.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//div[text()='Revenue Calculator']")
	WebElement RevenueCal;
	
	@FindBy(xpath="//input[@aria-orientation='horizontal']")
	WebElement scrollBtn;
	
	@FindBy(xpath="//input[@type='number']")
	WebElement textBox;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="(//p[text()='560'])[1]")
	WebElement validatevalue;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public void clickRevenueCal() {
		RevenueCal.click();
	}
	public void ScrollDown() throws InterruptedException {
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textBox);

	}
	public void adjustSlider() throws InterruptedException {
		Actions action=new Actions(driver);
		Thread.sleep(10000);
		action.dragAndDropBy(scrollBtn, 100, 820).clickAndHold(scrollBtn);
		System.out.println(scrollBtn.getText());
	}
	public void updateText(String val) {
		textBox.sendKeys(val);
	}
	public void validateValue(String expValue) {
		String actualValue=validatevalue.getText();
		Assert.assertEquals(actualValue, expValue);
	}
	public void clickCheckBox() {
		//int i=0;
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0;i<4;i++) {
			checkbox.get(i).click();
		}
	}
	public void validatePrice(String ExpPrice) {
		String ActualPrice=validatevalue.getText();
		Assert.assertEquals(ActualPrice, ExpPrice);
	}
}
