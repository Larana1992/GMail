package core.helpers.pagehelpers;

import org.openqa.selenium.WebElement;

import pages.CorePage;
import pages.PnGoodsInfoPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PnGoodsInfoHelper extends CorePage {

	public List<String> getFullDescription(PnGoodsInfoPage goodsInfoPage) {
		List<String> info = new ArrayList<String>();
		for (WebElement property : goodsInfoPage.getGoodsInfo()) {
			info.addAll(Arrays.asList(property.getText().toLowerCase()
					.replaceAll("\\p{P}", "").split(" ")));
		}
		return info;
	}
}
