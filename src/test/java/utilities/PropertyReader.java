package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	private static Properties configFile;
	private static String filePath = "src/test/resources/properties/config.properties";


	static {
		try(FileInputStream input = new FileInputStream(filePath)) {		
			configFile = new Properties();
			configFile.load(input);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String keyName) {		
		return configFile.getProperty(keyName);
	}
}
