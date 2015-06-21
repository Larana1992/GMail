package core;

import java.util.Arrays;
import java.util.List;

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

	public static String getFilePath() {
		return configuration.getString("filePath");
	}

	public static String getBrowserType() {
		return configuration.getString("BrowserType");
	}

	public static List<String> getLogin() {
		return Arrays.asList(configuration.getStringArray("login"));
	}

	public static List<String> getRecipient() {
		return Arrays.asList(configuration.getStringArray("recipient"));
	}

	public static String getPassword() {
		return configuration.getString("password");
	}

	public static boolean getIsRemote() {
		return configuration.getString("IsRemote").equalsIgnoreCase("true");
	}

	public static String getRemoteUrl() {
		return configuration.getString("RemoteUrl");
	}

	public static List<String> getSubject() {
		return Arrays.asList(configuration.getStringArray("subject"));
	}

	public static List<String> getText() {
		return Arrays.asList(configuration.getStringArray("text"));
	}

}
