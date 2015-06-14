package core.driver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;

public final class Browser {

	private static WebDriverRunner webDriverRunner = null;

	private Browser() {
	}

	public static WebDriver getDriver() {
		if (webDriverRunner == null) {
			webDriverRunner = WebDriverRunner.getInstance();
		}
		WebDriver driver = null;
		try {
			driver = webDriverRunner.getDriver();
		} catch (IOException ex) {
			Logger.getLogger(Browser.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return driver;
	}
}
