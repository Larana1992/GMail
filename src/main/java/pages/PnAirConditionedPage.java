package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class PnAirConditionedPage extends CorePage {

	public final String CONDITIONERS_NAME = "(//div[@class='name']//a)[position()<6]";
	public final String CONDITIONERS_DESCRIPTION = "(//div[@class='description'])[position()<6]";

	@FindBy(xpath = CONDITIONERS_NAME)
	private List<WebElement> conditionersNames;

	public List<WebElement> getConditionersNames() {
		return conditionersNames;
	}

	@FindBy(xpath = CONDITIONERS_DESCRIPTION)
	private List<WebElement> conditionersDescription;

	public List<WebElement> getConditionersDescription() {
		return conditionersDescription;
	}

}
