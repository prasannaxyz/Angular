package com.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

	public Properties loadPropertiesFile(String propertiesFileName) {
		Properties prop = new Properties();
		try {
			InputStream ip = this.getClass().getClassLoader()
					.getResourceAsStream(propertiesFileName);
			prop.load(ip);
			ip.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
