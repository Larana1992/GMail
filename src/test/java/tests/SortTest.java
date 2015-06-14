package tests;

import base.BaseTest;
import core.helpers.pagehelpers.MyPages;
import org.testng.annotations.*;

public class SortTest extends BaseTest {

	@BeforeMethod(dependsOnMethods = "setupBeforeSuite")
	public void setUpConfiguration() {
		mainPage = MyPages.getPnMainPage();
		refrigeratorsPage = MyPages.getPnRefrigeratorsPage();
		mainHelper = MyPages.getPnMainHelper();
		refrigeratorsHelper = mainHelper.navigateToRefrigerators();
	}

	@Test
	public void checkSortByPrice() {
		refrigeratorsHelper.sortRefrigeratorsByParameter(
				refrigeratorsPage.getSortByPriceLink()).checkTheSortionByPrice(
				refrigeratorsPage.getPriceList());
	}

	@Test
	public void checkSortByGoodsName() {
		refrigeratorsHelper.sortRefrigeratorsByParameter(
				refrigeratorsPage.getSortByNameLink()).checkTheSortionByName(
				refrigeratorsPage.getNameList());
	}

	@AfterMethod
	public void goBack() {
	}
}
