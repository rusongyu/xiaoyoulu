package com.ard.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemPropertyUtil {

	public final static Properties p = new Properties();

	public static String getValueByKey(String key) throws Exception {

		if (p.isEmpty()) {
			InputStream is = SystemPropertyUtil.class.getClassLoader()
					.getResourceAsStream("sysvar.properties");
			try {
				p.load(is);
			} catch (IOException e) {
				throw new Exception("load failure,system.properties not exist!");
			} finally {
				is.close();
			}
		}

		return p.getProperty(key);
	}

}
