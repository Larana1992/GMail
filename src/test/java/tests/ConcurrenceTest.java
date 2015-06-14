package tests;

import base.BaseTest;
import core.helpers.pagehelpers.MyPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConcurrenceTest extends BaseTest {

	@BeforeMethod(dependsOnMethods = "setupBeforeSuite")
	public void setUpConfiguration() {
		mainPage = MyPages.getPnMainPage();
		airConditionedPage = MyPages.getPnAirConditionedPage();
		mainHelper = MyPages.getPnMainHelper();
		goodsInfoPage = MyPages.getPnGoodsInfoPage();
		airConditionedHelper = mainHelper.navigateAirConditioned();
	}

	@Test
	public void checkSortByPrice() {
		airConditionedHelper.checkThatInformationCorrect(airConditionedPage,
				goodsInfoPage);
	}

	@AfterMethod
	public void goBack() {
		airConditionedHelper.getDriver().navigate().back();
	}
}
