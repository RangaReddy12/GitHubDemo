package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BranchUpdationPage {
WebDriver driver;
public BranchUpdationPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath = "(//img)[10]")
WebElement ClickEditBtn;
@FindBy(xpath = "//input[@id='txtbnameU']")
WebElement EnterBranch;
@FindBy(xpath = "(//input[@id='txtadd1u'])[1]")
WebElement EnterAddress;
@FindBy(xpath = "//input[@id='txtareaU']")
WebElement EnterArea;
@FindBy(xpath = "//input[@id='btnupdate']")
WebElement ClickUpdateBtn;
public boolean verifyBranchUpdate(String branchname,String Address1,String Area)throws Throwable
{
	this.ClickEditBtn.click();
	this.EnterBranch.clear();
	this.EnterBranch.sendKeys(branchname);
	this.EnterAddress.clear();
	this.EnterAddress.sendKeys(Address1);
	this.EnterArea.clear();
	this.EnterArea.sendKeys(Area);
	this.ClickUpdateBtn.click();
	String ExpectedAlert =driver.switchTo().alert().getText();
	Thread.sleep(5000);
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	String  ActualAlert ="Branch updated";
	if(ExpectedAlert.toLowerCase().contains(ActualAlert.toLowerCase()))
	{
		Reporter.log(ExpectedAlert,true);
		return true;
	}
	else
	{
		Reporter.log("Branch Updation Fail",true);
		return false;
	}
}
}

















