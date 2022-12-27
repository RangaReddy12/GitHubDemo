package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AdminLoginPage {
WebDriver driver;
public AdminLoginPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(name ="txtuId")
WebElement EnterUser;
@FindBy(name ="txtPword")
WebElement EnterPass;
@FindBy(name ="login")
WebElement ClickLogin;
public boolean verifyLogin(String username,String password)
{
	this.EnterUser.sendKeys(username);
	this.EnterPass.sendKeys(password);
	this.ClickLogin.click();
	String expected ="adminflow";
	String actual = driver.getCurrentUrl();
	if(actual.toLowerCase().contains(expected.toLowerCase()))
	{
		Reporter.log("Login Success::"+expected+"     "+actual,true);
		return true;
	}
	else
	{
		Reporter.log("Login Fail::"+expected+"     "+actual,true);
		return false;
	}
}
}










