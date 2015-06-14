package core.driver;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Config {
	static String configFileName = "config.properties";

	static CompositeConfiguration configuration = loadConfiguration();

	private static CompositeConfiguration loadConfiguration() {
		configuration = new CompositeConfiguration();
		try {
			configuration.addConfiguration(new PropertiesConfiguration(
					configFileName));
		} catch (final ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return configuration;
	}

	public static String getApplicationMainUrl() {
		return configuration.getString("applicationMainUrl");
	}

	public static String getBrowserType() {
		return configuration.getString("BrowserType");
	}

	public static String getBrand() {
		return configuration.getString("brand");
	}

	public static boolean getIsRemote() {

		return configuration.getString("IsRemote").equalsIgnoreCase("true");
	}

	public static String getRemoteUrl() {
		return configuration.getString("RemoteUrl");
	}
}
