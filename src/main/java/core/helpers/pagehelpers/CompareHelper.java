package core.helpers.pagehelpers;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import core.helpers.generalhelpers.VerifyHelper;
import pages.CorePage;
import pages.PnMicrowavesPage;
import java.util.List;

public class CompareHelper extends CorePage {

	public CompareHelper isGoodsAdded(List<WebElement> titles,
			PnMicrowavesHelper microwavesHelper) {
		if (titles.size() < 2) {
			getDriver().navigate().back();
			microwavesHelper.removeGoodsFromCompare(new PnMicrowavesPage());
			getDriver().navigate().forward();
			isGoodsAdded(titles, microwavesHelper);
		}
		return MyPages.getCompareHelper();
	}

	public CompareHelper isAllPropertiesPresent(List<WebElement> properties) {
		Assert.assertTrue(VerifyHelper.verifyIsElementsPresent(properties));
		return MyPages.getCompareHelper();
	}

	public CompareHelper isElementsHaveCorrectColor(List<WebElement> properties) {
		Assert.assertTrue(VerifyHelper
				.verifyCorespondingColorOfList(properties));
		return MyPages.getCompareHelper();
	}
}
