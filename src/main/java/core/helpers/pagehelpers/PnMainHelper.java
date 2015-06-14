package core.helpers.pagehelpers;

import core.helpers.generalhelpers.WaitHelper;
import pages.CorePage;

public class PnMainHelper extends CorePage {

	public PnRefrigeratorsHelper navigateToRefrigerators() {
		WaitHelper.waitForElementIsClickable(MyPages.getPnMainPage()
				.getRefrigeratorsLink(), getDriver());
		MyPages.getPnMainPage().clickRefrigeratorsItem();
		return MyPages.getPnRefrigeratorsHelper();
	}

	public PnMicrowavesHelper navigateToMicrowaves() {
		WaitHelper.waitForElementIsClickable(MyPages.getPnMainPage()
				.getMicrowavesLink(), getDriver());
		MyPages.getPnMainPage().clickMicrowavesItem();
		return MyPages.getPnMicrowavesHelper();
	}

	public PnWashersHelper navigateToWashers() {
		WaitHelper.waitForElementIsClickable(MyPages.getPnMainPage()
				.getWashersLink(), getDriver());
		MyPages.getPnMainPage().clickWashersItem();
		return MyPages.getPnWashersHelper();
	}

	public PnBreadMakerHelper navigateToBreadMakers() {
		WaitHelper.waitForElementIsClickable(MyPages.getPnMainPage()
				.getBreadMakersLink(), getDriver());
		MyPages.getPnMainPage().clickBreadMakerItem();
		return MyPages.getPnBreadMakerHelper();
	}

	public PnAirConditionedHelper navigateAirConditioned() {
		WaitHelper.waitForElementIsClickable(MyPages.getPnMainPage()
				.getAirConditionedLink(), getDriver());
		MyPages.getPnMainPage().getAirConditionedLink().click();
		return MyPages.getPnAirConditionedHelper();
	}
}
