package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ComparePage extends CorePage {

	public final String GOODS_PROPERTIES = "//table[@class='compare']//td[position() >1]";
	public final String GOODS_TABLE_ROWS = "//table[@class='compare']//td[position() >1]//.. | //table[@class='compare']//td[position() >1]";
	public final String GOODS_TITLES = "//table[@class='compare']//th[@class='row-2']/a";

	@FindBy(xpath = GOODS_PROPERTIES)
	private List<WebElement> goodsProperties;

	public List<WebElement> getGoodsProperties() {
		return goodsProperties;
	}

	@FindBy(xpath = GOODS_TABLE_ROWS)
	private List<WebElement> goodsTableRows;

	public List<WebElement> getGoodsTableRows() {
		return goodsTableRows;
	}

	@FindBy(xpath = GOODS_TITLES)
	private List<WebElement> goodsTitles;

	public List<WebElement> getGoodsTitles() {
		return goodsTitles;
	}
}
