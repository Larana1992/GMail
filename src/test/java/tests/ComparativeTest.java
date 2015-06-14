package tests;

import base.BaseTest;
import core.helpers.pagehelpers.MyPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComparativeTest extends BaseTest {

	@BeforeMethod(dependsOnMethods = "setupBeforeSuite")
	public void setUpConfiguration() {
		mainPage = MyPages.getPnMainPage();
		microwavePage = MyPages.getPnMicrowavesPage();
		mainHelper = MyPages.getPnMainHelper();
		comparePage = MyPages.getComparePage();
		microwaveHelper = mainHelper.navigateToMicrowaves();
		compareHelper = microwaveHelper.navigateToComparePage(microwavePage);
	}

	@Test
	public void checkSortByPrice() {
		compareHelper
				.isGoodsAdded(comparePage.getGoodsTitles(), microwaveHelper)
				.isAllPropertiesPresent(comparePage.getGoodsProperties())
				.isElementsHaveCorrectColor(comparePage.getGoodsTableRows());
	}

	@AfterMethod
	public void goBack() {
		compareHelper.getDriver().navigate().back();
		microwaveHelper.removeGoodsFromCompare(microwavePage);
		microwaveHelper.getDriver().navigate().back();
	}
}
