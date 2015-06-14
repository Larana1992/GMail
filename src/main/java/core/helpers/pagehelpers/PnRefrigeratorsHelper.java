package core.helpers.pagehelpers;

import com.google.common.collect.Ordering;

import core.helpers.generalhelpers.WaitHelper;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.CorePage;

import java.util.ArrayList;
import java.util.List;

public class PnRefrigeratorsHelper extends CorePage {

	public PnRefrigeratorsHelper sortRefrigeratorsByParameter(
			WebElement parameter) {
		WaitHelper.waitForElementIsClickable(parameter, getDriver());
		parameter.click();
		return MyPages.getPnRefrigeratorsHelper();
	}

	public PnRefrigeratorsHelper checkTheSortionByPrice(List<WebElement> detail) {
		List<Integer> price = new ArrayList<Integer>();
		for (WebElement element : detail) {
			price.add(Integer.parseInt(element.getText().replaceAll("\\D", "")));
		}
		Assert.assertTrue(Ordering.natural().isOrdered(price));
		return MyPages.getPnRefrigeratorsHelper();
	}

	public PnRefrigeratorsHelper checkTheSortionByName(List<WebElement> detail) {
		List<String> name = new ArrayList<String>();
		for (WebElement element : detail) {
			name.add(element.getText());
		}
		Assert.assertTrue(Ordering.natural().isOrdered(name));
		return MyPages.getPnRefrigeratorsHelper();
	}
}
