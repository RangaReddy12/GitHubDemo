package commonFunctions;

import static org.testng.Assert.expectThrows;

import org.apache.regexp.recompile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class BranchCreationPage {
WebDriver driver;
public BranchCreationPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath = "//input[@id='BtnNewBR']")
WebElement clickNewBranch;
@FindBy(name="txtbName")
WebElement EnterBranch;
@FindBy(name="txtAdd1")
WebElement EnterAddress1;
@FindBy(name="Txtadd2")
WebElement EnterAddress2;
@FindBy(name="txtadd3")
WebElement EnterAddress3;
@FindBy(name="txtArea")
WebElement EnterArea;
@FindBy(name="txtZip")
WebElement EnterZipcode;
@FindBy(name="lst_counrtyU")
WebElement Selectcountry;
@FindBy(name="lst_stateI")
WebElement Selectstate;
@FindBy(name="lst_cityI")
WebElement Selectcity;
@FindBy(name="btn_insert")
WebElement clickSubmit;
public boolean verifyNewBranch(String branchName,String Address1,String Address2,String Address3,String Area,
		String zipcode,String country,String state,String city)throws Throwable
{
	this.clickNewBranch.click();
	this.EnterBranch.sendKeys(branchName);
	this.EnterAddress1.sendKeys(Address1);
	this.EnterAddress2.sendKeys(Address2);
	this.EnterAddress3.sendKeys(Address3);
	this.EnterArea.sendKeys(Area);
	this.EnterZipcode.sendKeys(zipcode);
	new Select(this.Selectcountry).selectByVisibleText(country);
	new Select(this.Selectstate).selectByVisibleText(state);
	new Select(this.Selectcity).selectByVisibleText(city);
	this.clickSubmit.click();
	Thread.sleep(4000);
	//capture alert message
	String ExpectedAlert =driver.switchTo().alert().getText();
	Thread.sleep(4000);
	driver.switchTo().alert().accept();
	String ActulAlert ="New Branch with";
	if(ExpectedAlert.toLowerCase().contains(ActulAlert.toLowerCase()))
	{
		Reporter.log(ExpectedAlert,true);
		return true;
	}
	else
	{
		Reporter.log("New Branch Creation Fail",true);
		return false;
	}
	
}
}
















