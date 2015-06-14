package tests;

import base.BaseTest;
import core.helpers.pagehelpers.MyPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilterTest extends BaseTest {

	@BeforeMethod(dependsOnMethods = "setupBeforeSuite")
	public void setUpConfiguration() {
		mainPage = MyPages.getPnMainPage();
		washersPage = MyPages.getPnWashersPage();
		mainHelper = MyPages.getPnMainHelper();
		breadMakerPage = MyPages.getPnBreadMakerPage();
	}

	@Test
	public void checkSortByWeightAdjustment() {
		breadMakerHelper = mainHelper.navigateToBreadMakers();
		breadMakerHelper
				.checkThatFilterByWeightAdjustmentWorkCorrectly(breadMakerPage);
	}

	@Test(dependsOnMethods = { "checkSortByWeightAdjustment" })
	public void checkSortByBrand() {
		breadMakerHelper = mainHelper.navigateToBreadMakers();
		breadMakerHelper.checkThatFilterByBrandWorkCorrectly(breadMakerPage);
	}

	@Test(dependsOnMethods = { "checkSortByBrand" })
	public void checkSortByPrice() {
		washersHelper = mainHelper.navigateToWashers();
		washersHelper.checkThatFilterByPriceWorkCorrectly(washersPage);
	}

	@AfterMethod
	public void goBack() {
		breadMakerHelper.getDriver().navigate().back();
	}
}
