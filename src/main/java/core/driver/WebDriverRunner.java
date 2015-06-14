package core.driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

class WebDriverRunner {

	private static WebDriver driver = null;
	private static WebDriverRunner instance = null;

	public static final String BROWSER_FIREFOX = "Firefox";
	public static final String BROWSER_CHROME = "Chrome";
	public static final String BROWSER_IE = "InternetExplorer";
	public static final String BROWSER_OPERA = "Opera";

	private WebDriverRunner() {

	}

	public static WebDriverRunner getInstance() {
		if (instance == null) {
			instance = new WebDriverRunner();
			instance.addShutDownHook();
		}
		return instance;
	}

	public WebDriver getDriver() throws MalformedURLException, IOException {
		if (driver == null) {
			// TODO: Implement browser creation from
			// configuration file
			driver = RunDriver(Config.getBrowserType(), Config.getIsRemote(),
					Config.getRemoteUrl());
		}
		return driver;
	}

	private void addShutDownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				if (driver != null) {
					driver.quit();
					driver = null;
				}
			}
		});
	}

	private WebDriver RunDriver(String browserType, boolean isRemote,
			String remoteUrl) throws MalformedURLException {
		WebDriver newDriver = null;
		if (isRemote) {
			newDriver = connetctToRemoteWebDriver(browserType, remoteUrl);
		} else {
			newDriver = startEmbededWebDriver(browserType);
		}
		return newDriver;
	}

	private WebDriver connetctToRemoteWebDriver(String browserType,
			String remoteUrl) throws MalformedURLException {
		DesiredCapabilities caps = null;
		URL hubUri = new URL(remoteUrl);

		switch (browserType) {

		case BROWSER_FIREFOX:
			caps = DesiredCapabilities.firefox();
			break;
		case BROWSER_CHROME:
			caps = DesiredCapabilities.chrome();
			break;
		case BROWSER_IE:
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(
					InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
			caps.setCapability("ignoreZoomSetting", true);
			break;
		case BROWSER_OPERA:
			caps = DesiredCapabilities.opera();
			break;
		default:
			String errorMessage = String.format(
					"browserType: <%s> was not recognized as supported browser."
							+ " This parameter is case sensitive", browserType);
			throw new IllegalArgumentException(errorMessage);
		}
		RemoteWebDriver newDriver = new RemoteWebDriver(hubUri, caps);
		return newDriver;

	}

	private WebDriver startEmbededWebDriver(String browserType) {
		switch (browserType) {
		case BROWSER_FIREFOX:
			return new FirefoxDriver();
		case BROWSER_CHROME:
			System.setProperty("webdriver.chrome.driver",
					"libdrivers/chromedriver.exe");
			return new ChromeDriver();
		case BROWSER_IE:
			System.setProperty("webdriver.ie.driver",
					"libdrivers/IEDriverServer.exe");
			return new InternetExplorerDriver();
		case BROWSER_OPERA:
			System.setProperty("webdriver.opera.driver",
					"libdrivers/operadriver.exe");
			return new OperaDriver();
		default:
			String errorMessage = String.format(
					"browserType: <%s> was not recognized as supported browser."
							+ " This parameter is case sensitive", browserType);
			throw new IllegalArgumentException(errorMessage);
		}
	}
}
