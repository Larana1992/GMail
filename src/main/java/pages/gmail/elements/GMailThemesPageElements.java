package pages.gmail.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.base.CorePage;
import ru.yandex.qatools.htmlelements.element.Link;

public class GMailThemesPageElements extends CorePage {
	public static final String THEMES_LIST = "//tr[position()=2]//input[@name]/following-sibling::div[1]";
	public static final By THEME_CHENGED_MESSAGE = By
			.xpath("//div[@role='alert']/div/div[2]");
	public static final By NAVIGATE_MENU = By.xpath("(//a[@role='tab'])[1]");

	@FindBy(xpath = THEMES_LIST)
	private static List<Link> listThemes;

	public static List<Link> getListThemes() {
		return listThemes;
	}
}