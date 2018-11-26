package com.webup.soa.yunshang.common;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
	public static final String SUB_SYSTEM_PROPERTIES_FILE_NAME = "yizhaoyunshang.properties";
	public static Properties SUB_SYSTEM_PROPETIES = null;
	private static final String UPLOAD_PATH = "uploadpath";
	private static final String CONTRACT_FILE = "contractpath";

	static {
		SUB_SYSTEM_PROPETIES = new Properties();
		try {
			SUB_SYSTEM_PROPETIES.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(SUB_SYSTEM_PROPERTIES_FILE_NAME),"UTF-8"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	private static Properties getSubSystemProperties() {
		return SUB_SYSTEM_PROPETIES;
	}

	public static String getProperty(String name) {
		return getSubSystemProperties().getProperty(name);
	}

	public static String getUploadPath() {
		return getSubSystemProperties().getProperty(UPLOAD_PATH);
	}

	public static String getContractFile() {
		return getSubSystemProperties().getProperty(CONTRACT_FILE);
	}

}