package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class PnGoodsInfoPage extends CorePage {

	public final String ALL_GOODS_INFO = "//div[@class='row']//span";

	@FindBy(xpath = ALL_GOODS_INFO)
	private List<WebElement> goodsInfo;

	public List<WebElement> getGoodsInfo() {
		return goodsInfo;
	}

}
