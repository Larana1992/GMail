package core.helpers.pagehelpers;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import core.helpers.generalhelpers.WaitHelper;
import pages.CorePage;
import pages.PnAirConditionedPage;
import pages.PnGoodsInfoPage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PnAirConditionedHelper extends CorePage {

	public void checkThatInformationCorrect(
			PnAirConditionedPage airConditionedPage,
			PnGoodsInfoPage goodsInfoPage) {
		List<String> shortInfo = new ArrayList<String>();
		List<String> fullInfo = new ArrayList<String>();
		WaitHelper.waitForElements(
				airConditionedPage.getConditionersDescription(), getDriver());
		WaitHelper.waitForElements(
				airConditionedPage.getConditionersDescription(), getDriver());
		for (int i = 0; i < airConditionedPage.getConditionersNames().size(); i++) {
			shortInfo.addAll(Arrays.asList(airConditionedPage
					.getConditionersDescription().get(i).getText()
					.toLowerCase().replaceAll("\\p{P}", "").split(" ")));
			shortInfo.remove("помещение");
			fullInfo.addAll(goToFullDescription(
					airConditionedPage.getConditionersNames().get(i))
					.getFullDescription(goodsInfoPage));
			getDriver().navigate().back();
		}
		Assert.assertTrue(fullInfo.containsAll(shortInfo));
	}

	public PnGoodsInfoHelper goToFullDescription(WebElement goodsName) {
		goodsName.click();
		return MyPages.getPnGoodsInfoHelper();
	}
}