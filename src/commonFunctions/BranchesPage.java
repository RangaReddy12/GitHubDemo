package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BranchesPage {
@FindBy(xpath = "(//img)[5]")
WebElement ClickBranches;
public void BranchesButton()
{
	ClickBranches.click();
}
}
