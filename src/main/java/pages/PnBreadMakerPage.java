package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.helpers.pagehelpers.MyPages;
import java.util.List;

public class PnBreadMakerPage extends CorePage {

	public final String NAME_LIST = "//div[@class='name']//a";
	public final String NEXT_PAGE_BUTTON = "(//ul[@class='pager']//li[@class='pager-next']/a)[1]";
	public final String FILTER_BY_BRAND = "//a[text()='Kenwood']";
	public final String FILTER_BY_WEIGHT_ADJUSTMENT = "(//div[@class='is_empty_items']/a[2])[8]";
	public final String DESCRIPTION_LIST = "//div[@class='item']//div[@class='description']";

	@FindBy(xpath = NAME_LIST)
	private List<WebElement> nameList;

	public List<WebElement> getNameList() {
		return nameList;
	}

	@FindBy(xpath = DESCRIPTION_LIST)
	private List<WebElement> descriptionList;

	public List<WebElement> getDescriptionList() {
		return descriptionList;
	}

	@FindBy(xpath = NEXT_PAGE_BUTTON)
	private WebElement nextPageButton;

	public WebElement getNextPageButton() {
		return nextPageButton;
	}

	@FindBy(xpath = FILTER_BY_BRAND)
	private WebElement byBrandFilter;

	public WebElement getByBrandFilter() {
		return byBrandFilter;
	}

	@FindBy(xpath = FILTER_BY_WEIGHT_ADJUSTMENT)
	private WebElement byWeightAdjustmentFilter;

	public WebElement getByWeightAdjustmentFilter() {
		return byWeightAdjustmentFilter;
	}

	public PnBreadMakerPage clickNextPageButton() {
		getNextPageButton().click();
		return MyPages.getPnBreadMakerPage();
	}

	public PnWashersPage clickFilterByBrandOn() {
		getByBrandFilter().click();
		return MyPages.getPnWashersPage();
	}

	public PnWashersPage clickFilterByWeightAdjustment() {
		getByWeightAdjustmentFilter().click();
		return MyPages.getPnWashersPage();
	}
}
