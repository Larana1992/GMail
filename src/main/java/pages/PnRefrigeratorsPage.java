package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.helpers.pagehelpers.MyPages;

import java.util.List;

public class PnRefrigeratorsPage extends CorePage {

	public final String PRICE_LIST = "//div[@class='price']/strong";
	public final String NAME_LIST = "//div[@class='name']//a";
	public final String BACK_TO_MAIN_PAGE = "//div[@id='page-breadcrumbs']/a[1]";
	public final String SORT_BY_PRICE_LINK = "//div[@class='order']/a[1]";
	public final String SORT_BY_NAME_LINK = "//div[@class='order']/a[2]";

	@FindBy(xpath = PRICE_LIST)
	private List<WebElement> priceList;

	public List<WebElement> getPriceList() {
		return priceList;
	}

	@FindBy(xpath = NAME_LIST)
	private List<WebElement> nameList;

	public List<WebElement> getNameList() {
		return nameList;
	}

	@FindBy(xpath = BACK_TO_MAIN_PAGE)
	private WebElement toMainPageLink;

	public WebElement getToMainPageLink() {
		return toMainPageLink;
	}

	@FindBy(xpath = SORT_BY_PRICE_LINK)
	private WebElement sortByPriceLink;

	public WebElement getSortByPriceLink() {
		return sortByPriceLink;
	}

	@FindBy(xpath = SORT_BY_NAME_LINK)
	private WebElement sortByNameLink;

	public WebElement getSortByNameLink() {
		return sortByNameLink;
	}

	public PnMainPage clickBackToMainPage() {
		getToMainPageLink().click();
		return MyPages.getPnMainPage();
	}
}
