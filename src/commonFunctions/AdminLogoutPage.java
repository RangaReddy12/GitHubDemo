package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AdminLogoutPage {
WebDriver driver;
public AdminLogoutPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath = "(//img)[4]")
WebElement ClickLogout;
@FindBy(xpath = "//input[@id='login']")
WebElement clickLoginbtn;
public boolean verifyLogout()throws Throwable
{
	this.ClickLogout.click();
	Thread.sleep(3000);
	if(this.clickLoginbtn.isDisplayed())
	{
		Reporter.log("Logout Success::",true);
		return true;
	}
	else
	{
		Reporter.log("Logout Fail::",true);
		return false;
	}
}
}
