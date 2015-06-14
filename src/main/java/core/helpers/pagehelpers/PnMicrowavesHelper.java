package core.helpers.pagehelpers;

import core.helpers.generalhelpers.WaitHelper;
import pages.CorePage;
import pages.PnMicrowavesPage;

public class PnMicrowavesHelper extends CorePage {

	public CompareHelper navigateToComparePage(PnMicrowavesPage microwavesPage) {
		WaitHelper.waitForElements(microwavesPage.getToComparativeList(),
				getDriver());
		microwavesPage.clickAddToComperetive();
		WaitHelper.waitForElementIsClickable(
				microwavesPage.getRedirectToComparative(), getDriver());
		microwavesPage.clickRedirectToCompare();
		WaitHelper.delay(2000);
		return MyPages.getCompareHelper();
	}

	public PnMicrowavesHelper removeGoodsFromCompare(
			PnMicrowavesPage microwavesPage) {
		WaitHelper.waitForElements(microwavesPage.getToComparativeList(),
				getDriver());
		microwavesPage.clickAddToComperetive();
		return MyPages.getPnMicrowavesHelper();
	}
}
