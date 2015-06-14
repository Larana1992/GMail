package core.helpers.pagehelpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import core.helpers.generalhelpers.VerifyHelper;
import pages.CorePage;
import pages.PnWashersPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PnWashersHelper extends CorePage {

	private static Logger logger = Logger.getLogger(PnWashersHelper.class);

	public PnWashersHelper checkThatFilterByPriceWorkCorrectly(
			PnWashersPage washersPage) {
		List<Integer> goods = new ArrayList<Integer>();
		List<Integer> filteredGoods = new ArrayList<Integer>();
		selectCorrespondingPrices(goods, washersPage);
		washersPage.clickFilterOn();
		manualFilter(goods);
		selectCorrespondingPrices(filteredGoods, washersPage);
		logger.info("Goods that corresponding prices using manual filter: "
				+ goods.size() + " items");
		logger.info("Goods that corresponding prices adjustment using web page filter: "
				+ filteredGoods.size() + " items");
		Assert.assertTrue(goods.containsAll(filteredGoods),
				"Assert that all the products with corresponded prices are selected");
		Assert.assertTrue(goods.size() == filteredGoods.size(),
				"Check that there are no extra items");
		return MyPages.getPnWashersHelper();
	}

	public void selectCorrespondingPrices(List<Integer> prices,
			PnWashersPage washersPage) {
		while (VerifyHelper.isElementPresent(
				By.xpath(washersPage.NEXT_PAGE_BUTTON), getDriver())) {
			addToList(prices, washersPage);
			washersPage.clickNextPageButton();
		}
		addToList(prices, washersPage);
	}

	public void addToList(List<Integer> prices, PnWashersPage washersPage) {
		for (WebElement price : washersPage.getPriceList()) {
			Integer goodsPrice = Integer.parseInt(price.getText().replaceAll(
					"\\D", ""));
			prices.add(goodsPrice);
		}
	}

	public void manualFilter(List<Integer> prices) {
		Iterator<Integer> iteration = prices.iterator();
		while (iteration.hasNext()) {
			Integer price = iteration.next();
			if ((price < 3000) || (price > 6000)) {
				iteration.remove();
			}
		}
	}
}
