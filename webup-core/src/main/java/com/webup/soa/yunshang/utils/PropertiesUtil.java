package com.webup.soa.yunshang.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
	public static final String APPLICATION_SERVICE_NAME = "applicationService";
	public static final String SUB_SYSTEM_PROPERTIES_FILE_NAME = "yizhaoyunshang.properties";
	public static Properties SUB_SYSTEM_PROPETIES = null;

	private static final String BaseDomain = "baseDomain";
	private static final String OilGas_System_Url = "oilGas_System_Url";

	private static final String UserErp_Url_yzwl = "userErp_Url_yzwl";
	private static final String UserErp_ServiceName_yzwl = "userErp_ServiceName_yzwl";
	private static final String UserErp_PortName_yzwl = "userErp_PortName_yzwl";

	private static final String PHOTOPATH_PATH_KEY = "photoPath";
	private static final String FILEPATH_PATH_KEY = "filePath";
	private static final String SOURCE_FILE_PATH_KEY = "sourceFilePath";
	private static final String TEMP_SOURCE_FILE_PATH_KEY = "tempSourceFilePath";
	private static final String CONTRACT_FILE_DIR = "contractFileDir";
	private static final String SEAL_TYPE1 = "sealType1";
	private static final String SEAL_TYPE2 = "sealType2";
	private static final String FIRST_PARTY_KEYWORDS = "keyWords1";
	private static final String SECOND_PARTY_KEYWORDS= "keyWords2";
	private static final String LOADING_PAGE_KEY = "loadingPage";

	private static final String ACCOUNTS_ID = "accountSid";
	private static final String TOKEN = "token";
	private static final String APP_ID = "appId";
	private static final String SMS_REGISTER_TEMPLATE_ID = "SMSRegisterTemplateId";
	private static final String SMS_PWD_TEMPLATE_ID = "SMSPwdTemplateId";

	private static final String BAIDU_MSG_APIKEY_ANDROID = "baiduMsgApiKeyAndroid";
	private static final String BAIDU_MSG_SECRETKEY_ANDROID = "baiduMsgSecretKeyAndroid";
	private static final String BAIDU_MSG_APIKEY_IOS = "baiduMsgApiKeyIos";
	private static final String BAIDU_MSG_SECRETKEY_IOS = "baiduMsgSecretKeyIos";

	private static final String BAIDU_MAP_AK = "baiduMapAk";
	private static final String BAIDU_MAP_SERVICE_ID = "baiduMapServiceId";

	public static final String APP_URL = "appUrl";
	public static final String APP_VERSION = "appVersion";

	static {
		SUB_SYSTEM_PROPETIES = new Properties();
		try {
//			SUB_SYSTEM_PROPETIES.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(SUB_SYSTEM_PROPERTIES_FILE_NAME));
			SUB_SYSTEM_PROPETIES.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(SUB_SYSTEM_PROPERTIES_FILE_NAME),"UTF-8"));
//			prop.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties"),"UTF-8"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static Properties getSubSystemProperties() {
		return SUB_SYSTEM_PROPETIES;
	}

	public static String getUserErp_Url_yzwl() {
		return getSubSystemProperties().getProperty(UserErp_Url_yzwl);
	}
	public static String getUserErp_ServiceName_yzwl() {
		return getSubSystemProperties().getProperty(UserErp_ServiceName_yzwl);
	}
	public static String getUserErp_PortName_yzwl() {
		return getSubSystemProperties().getProperty(UserErp_PortName_yzwl);
	}

	public static String getFilePath() {return getSubSystemProperties().getProperty(FILEPATH_PATH_KEY);}


//	public static String getProperty(String name) {
//		return getSubSystemProperties().getProperty(name);
//	}
//
//	public static String getBaseDomain() {
//		return getSubSystemProperties().getProperty(BaseDomain);
//	}
//
//	public static String getOilGas_System_Url() {
//		return getSubSystemProperties().getProperty(OilGas_System_Url);
//	}
//
//	public static String getPhotopath() {
//		return getSubSystemProperties().getProperty(PHOTOPATH_PATH_KEY);
//	}
//
//	//获取监听文件保存路径
//	public static String getSourceFilePath(){
//		return getSubSystemProperties().getProperty(SOURCE_FILE_PATH_KEY);
//	}
//	//获取监听文件保存路径
//	public static String getTempSourceFilePath(){
//		return getSubSystemProperties().getProperty(TEMP_SOURCE_FILE_PATH_KEY);
//	}
//	//物流平台 司机app合同存放路径
//	public static String getContractFileDir(){
//		return getSubSystemProperties().getProperty(CONTRACT_FILE_DIR);
//	}
//	//获取甲方印章中心文字
//	public static String getSealType1(){
//		return getSubSystemProperties().getProperty(SEAL_TYPE1);
//	}
//	//获取乙方印章中心文字
//	public static String getSealType2(){
//		return getSubSystemProperties().getProperty(SEAL_TYPE2);
//	}
//	//获取甲方定位签章的关键字
//	public static String getFirstPartyKeywords(){
//		return getSubSystemProperties().getProperty(FIRST_PARTY_KEYWORDS);
//	}
//	//获取乙方定位签章的关键字
//	public static String getSecondPartyKeywords(){
//		return getSubSystemProperties().getProperty(SECOND_PARTY_KEYWORDS);
//	}
//
//	public static String getLoadingPagePath() {
//		return getSubSystemProperties().getProperty(LOADING_PAGE_KEY);
//	}
//
//	public static String getACCOUNTS_ID() {
//		return getSubSystemProperties().getProperty(ACCOUNTS_ID);
//	}
//
//	public static String getTOKEN() {
//		return getSubSystemProperties().getProperty(TOKEN);
//	}
//
//	public static String getAPP_ID() {
//		return getSubSystemProperties().getProperty(APP_ID);
//	}
//
//	public static String getSMS_REGISTER_TEMPLATE_ID() {
//		return getSubSystemProperties().getProperty(SMS_REGISTER_TEMPLATE_ID);
//	}
//
//	public static String getSMS_PWD_TEMPLATE_ID() {
//		return getSubSystemProperties().getProperty(SMS_PWD_TEMPLATE_ID);
//	}
//
//	public static String getBaiduMsgApiKeyAndroid() {return getSubSystemProperties().getProperty(BAIDU_MSG_APIKEY_ANDROID);}
//	public static String getBaiduMsgSecretKeyAndroid() {return getSubSystemProperties().getProperty(BAIDU_MSG_SECRETKEY_ANDROID);}
//	public static String getBaiduMsgApiKeyIos() {return getSubSystemProperties().getProperty(BAIDU_MSG_APIKEY_IOS);}
//	public static String getBaiduMsgSecretKeyIos() {return getSubSystemProperties().getProperty(BAIDU_MSG_SECRETKEY_IOS);}
//
//	public static String getBaiduMapAk() {return getSubSystemProperties().getProperty(BAIDU_MAP_AK);}
//	public static String getBaiduMapServiceId() {return getSubSystemProperties().getProperty(BAIDU_MAP_SERVICE_ID);}

}