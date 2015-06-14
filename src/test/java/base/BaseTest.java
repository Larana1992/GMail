package base;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import core.driver.Config;
import core.helpers.pagehelpers.*;
import pages.*;

public class BaseTest extends CorePage {

	protected PnMainPage mainPage;
	protected PnRefrigeratorsPage refrigeratorsPage;
	protected PnMicrowavesPage microwavePage;
	protected ComparePage comparePage;
	protected PnWashersPage washersPage;
	protected PnBreadMakerPage breadMakerPage;
	protected PnAirConditionedPage airConditionedPage;
	protected PnGoodsInfoPage goodsInfoPage;

	protected PnMainHelper mainHelper;
	protected PnRefrigeratorsHelper refrigeratorsHelper;
	protected PnMicrowavesHelper microwaveHelper;
	protected CompareHelper compareHelper;
	protected PnWashersHelper washersHelper;
	protected PnBreadMakerHelper breadMakerHelper;
	protected PnAirConditionedHelper airConditionedHelper;

	@BeforeMethod
	protected void setupBeforeSuite() {
		getDriver().get(Config.getApplicationMainUrl());
	}

	@AfterSuite
	protected void tearDown() throws IOException, InterruptedException {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}
}
