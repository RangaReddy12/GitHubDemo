package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.AdminLoginPage;
import commonFunctions.AdminLogoutPage;
import commonFunctions.BranchCreationPage;
import commonFunctions.BranchUpdationPage;
import commonFunctions.BranchesPage;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil {
String inputpath ="D:\\Automation_Selenium\\Hybrid_Framework\\TestInput\\DataEngine.xlsx";
String outputpath ="D:\\Automation_Selenium\\Hybrid_Framework\\TestOutPut\\HybridResults.xlsx";
String TCSheet ="TestCases";
String TSSheet ="TestSteps";
@Test
public void startTest()throws Throwable
{
	boolean res=false;
	String tcres="";
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	//count no of rows into TCSheet and TSSheet
	int TCCount =xl.rowCount(TCSheet);
	int TSCount = xl.rowCount(TSSheet);
	Reporter.log("No of rows in TCSheet::"+TCCount+"   "+"No of rows in TSSheet::"+TSCount,true);
	//iterate all rows in TCSheet
	for(int i=1;i<=TCCount;i++)
	{
		String ModuleStatus =xl.getCellData(TCSheet, i, 2);
		if(ModuleStatus.equalsIgnoreCase("Y"))
		{
			String tcid =xl.getCellData(TCSheet, i, 0);
			//iterate all rows in TSSheet
			for(int j=1;j<=TSCount;j++)
			{
				String tsid =xl.getCellData(TSSheet, j, 0);
				if(tcid.equalsIgnoreCase(tsid))
				{
					String keyword = xl.getCellData(TSSheet, j, 3);
					if(keyword.equalsIgnoreCase("AdminLogin"))
					{
						AdminLoginPage pblogin =PageFactory.initElements(driver, AdminLoginPage.class);
						String para1 =xl.getCellData(TSSheet, j, 5);
						String para2 =xl.getCellData(TSSheet, j, 6);
						res =pblogin.verifyLogin(para1, para2);
					}
					else if(keyword.equalsIgnoreCase("BranchCreation"))
					{
						BranchesPage pbBranches = PageFactory.initElements(driver, BranchesPage.class);
						BranchCreationPage pbnewBranch =PageFactory.initElements(driver, BranchCreationPage.class);
						String para1 =xl.getCellData(TSSheet, j, 5);
						String para2 =xl.getCellData(TSSheet, j, 6);
						String para3 =xl.getCellData(TSSheet, j, 7);
						String para4 =xl.getCellData(TSSheet, j, 8);
						String para5 =xl.getCellData(TSSheet, j, 9);
						String para6 =xl.getCellData(TSSheet, j, 10);
						String para7 = xl.getCellData(TSSheet, j, 11);
						String para8 =xl.getCellData(TSSheet, j, 12);
						String para9 =xl.getCellData(TSSheet, j, 13);
						pbBranches.BranchesButton();
						res =pbnewBranch.verifyNewBranch(para1, para2, para3, para4, para5, para6, para7, para8, para9);
					}
					else if(keyword.equalsIgnoreCase("BrannchUpdate"))
					{
						BranchesPage pbbranches =PageFactory.initElements(driver, BranchesPage.class);
						BranchUpdationPage pbupdate =PageFactory.initElements(driver, BranchUpdationPage.class);
						String para1 =xl.getCellData(TSSheet, j, 5);
						String para2 =xl.getCellData(TSSheet, j, 6);
						String para3 =xl.getCellData(TSSheet, j, 9);
						pbbranches.BranchesButton();
						res =pbupdate.verifyBranchUpdate(para1, para2, para3);
					}
					else if(keyword.equalsIgnoreCase("AdminLogout"))
					{
						AdminLogoutPage pblogout = PageFactory.initElements(driver, AdminLogoutPage.class);
						res =pblogout.verifyLogout();
					}
					
					String tsres="";
					if(res)
					{
						//if res is true write pass into status cell in TSSheet
						tsres="Pass";
						xl.setCellData(TSSheet, j, 4, tsres, outputpath);
						
					}
					else
					{
						//if res is false write fail into status cell in TSSheet
						tsres="Fail";
						xl.setCellData(TSSheet, j, 4, tsres, outputpath);
					}
					tcres=tsres;
					
				}
			}
			//write tcres into status cell in TCSheet
			xl.setCellData(TCSheet, i, 3, tcres, outputpath);
		}
		else
		{
			//which test case flag N write as Blocked status in TCsheet status cell
			xl.setCellData(TCSheet, i, 3, "Blocked", outputpath);
		}
	}
	
}

}









