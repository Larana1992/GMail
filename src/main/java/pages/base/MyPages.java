package pages.base;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.support.PageFactory;
import core.helpers.pages.GMailLetterHelper;
import core.helpers.pages.GMailMainPageHelper;
import pages.gmail.GMailLoginPage;
import pages.gmail.GMailMainPage;
import pages.gmail.GMailThemesPage;
import pages.gmail.elements.GMailLetterElements;
import pages.gmail.elements.GMailLoginPageElements;
import pages.gmail.elements.GMailMainPageElements;
import pages.gmail.elements.GMailThemesPageElements;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class MyPages<T> extends CorePage {
	public final static <T extends CorePage> T getPage(Class<T> pageObjectClass) {
		T htmlElementInstance = null;

		try {
			htmlElementInstance = pageObjectClass.newInstance();
			PageFactory.initElements(new HtmlElementDecorator(
					htmlElementInstance.getDriver()), htmlElementInstance);
		} catch (InstantiationException | IllegalAccessException ex) {
			Logger.getLogger(MyPages.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return htmlElementInstance;
	}

	public static final GMailThemesPage getGMailThemesPage() {
		return getPage(GMailThemesPage.class);
	}

	public static final GMailMainPage getGMailMainPage() {
		return getPage(GMailMainPage.class);
	}

	public static final GMailLoginPage getGMailLoginPage() {
		return getPage(GMailLoginPage.class);
	}

	public static final GMailMainPageHelper getGMailMainPageHelper() {
		return getPage(GMailMainPageHelper.class);
	}

	public static final GMailLetterHelper getGMailLetterHelper() {
		return getPage(GMailLetterHelper.class);
	}

	public static final GMailLoginPageElements getGMailLoginPageElements() {
		return getPage(GMailLoginPageElements.class);
	}

	public static final GMailThemesPageElements getGMailThemesPageElements() {
		return getPage(GMailThemesPageElements.class);
	}

	public static final GMailMainPageElements getGMailMainPageElements() {
		return getPage(GMailMainPageElements.class);
	}

	public static final GMailLetterElements getGMailLetterElements() {
		return getPage(GMailLetterElements.class);
	}

}
