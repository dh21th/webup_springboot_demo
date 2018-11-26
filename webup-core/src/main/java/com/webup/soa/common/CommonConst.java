package com.webup.soa.common;


public class CommonConst {

	public static class Result {
		public static final Integer PARAM_ERROR = -1;//参数不全
		public static final Integer SYSTEM_ERROR = -2;//系统错误
		public static final Integer NOPOWER_ERROR = -98;//无权限操作
		public static final Integer LOGIN_ERROR = -99;//未登录
		public static final Integer CODE_ERROR = 500;//程序错误

		public static final Integer FLAG_TRUE = 1; //启用
		public static final Integer FLAG_FALSE = 0; //停用
	}

	public static class SystemID {
		public static final Integer WuLiu = 1;			//物流系统
		public static final Integer YunShang = 2;		//云商系统
		public static final Integer OilGas = 3;			//油气系统
	}

	public static class YunShangUserRole {
		public static final int DEFAULT = 5;			//云商缺省用户角色
		public static final int SALER = 2;			//经销商
		public static final int PURCHASER = 3;			//供应商
		public static final int CORER = 4;			//核心企业
	}
//	public enum SystemID {
//
//		WuLiu(1, "物流系统"),
//		YunShang(2, "云商系统"),
//		OilGas(3, "油气系统");
//
//		private String sysName;
//		private Integer sysId;
//		SystemID (Integer sysId, String sysName){
//			this.sysId = sysId;
//			this.sysName = sysName;
//		}
//	}

	public static class Oil {
		public static final Integer COMPANY_ID = 309;//油气宝公司id
		public static final String WULIU_WEBROOT="http://www.yizhaowuliu.com";//物流平台项目地址
		public static final String OG_FINANCE_URL="/api/account/get_account_info";//查询用户的账户信息接口地址
	}


	public static class UserType {
		public static final int Consignor = 1;			//货主
		public static final int Logistics = 2;		//物流公司
		public static final int Driver = 4;			//司机
		public static final int OilGas = 5;			//加油加气公司
	}

	// 用户公司审核状态
	public enum UserCorpState {
		//0 草稿 1 提交待审核 2 审核通过 -1
		DRAFT(0),SUBMIT(1),THROGH(2),DENY(-1);
		private int index ;
		UserCorpState( int index ){this.index = index ;}
		public int getIndex() {return index;}
	}

	// 菜单创建类型
	public enum MenuCreateType {
		// 1是用户创建 2是平台创建
		USER(1),SYSTEM(2);
		private int index ;
		MenuCreateType( int index ){this.index = index ;}
		public int getIndex() {return index;}
	}

	//油站宝中油气号的状态
	public enum OilGasGoodsState {
		ENABLE(1,"启用"),
		DISABLE(2,"停用");

		private Integer type;
		private String value ;
		private OilGasGoodsState(Integer type, String value ){
			this.type = type;
			this.value = value ;
		}
		public String value() {return this.value;}
		public Integer getType(){return this.type;}

		/**
		 * 根据类型查找对应的说明
		 * @param type
		 * @return
		 */
		public static String getStateByType(Integer type) {
			String value = "";
			for(OilGasGoodsState goodsState : OilGasGoodsState.values()) {
				if(goodsState.getType().equals(type)){
					value = goodsState.value();
				}
			}
			return value;
		}

	}
	//油站宝中油气号的状态

	public enum SmsResult {

		SEND_TOO_OFTEN(true,-5,"您的操作过于频繁，请在1分钟后发送短信验证码!","160038"),
		SEND_TOO_MANY(false,-6,"发送次数过多，请明天重试","160040");

		private Boolean isSuccess;
		private Integer typeId;
		private String statusMsg;
		private String statusCode;

		private SmsResult (Boolean isSuccess, Integer typeId,
						   String statusCode, String statusMsg) {
			this.isSuccess = isSuccess;
			this.typeId = typeId;
			this.statusMsg = statusCode;
			this.statusCode = statusMsg;
		}

		public String getStatusMsg() {
			return this.statusMsg;
		}
		public Boolean getIsSuccess(){
			return this.isSuccess;
		}
		public Integer getTypeId() {
			return this.typeId;
		}
		public String getStatusCode(){
			return this.statusCode;
		}

		/**
		 * 根据typeId查找对应的失败信息
		 * @param statusCode
		 * @return
		 */
		public static String getMsgByCode(String statusCode) {
			String statusMsg = "短信发送有误";
			for(SmsResult smsResult : SmsResult.values()) {
				if(smsResult.getStatusCode().equals(statusCode)){
					statusMsg = smsResult.getStatusMsg();
				}
			}
			return statusMsg;
		}

		/**
		 * 根据typeId查找对应的失败信息
		 * @param typeId
		 * @return
		 */
		public static String getMsgByTypeId(Integer typeId) {
			String statusMsg = "短信发送有误";
			for(SmsResult smsResult : SmsResult.values()) {
				if(smsResult.getTypeId().equals(typeId)){
					statusMsg = smsResult.getStatusMsg();
				}
			}
			return statusMsg;
		}

		public static SmsResult typeOf(Integer typeId){
			if(SEND_TOO_OFTEN.getTypeId().equals(typeId)){
				return SEND_TOO_OFTEN;
			}
			if(SEND_TOO_MANY.getTypeId().equals(typeId)){
				return SEND_TOO_MANY;
			}
			return null;
		}

		public static SmsResult codeOf(String statusCode){
			if(SEND_TOO_OFTEN.getStatusCode().equals(statusCode)){
				return SEND_TOO_OFTEN;
			}
			if(SEND_TOO_MANY.getStatusCode().equals(statusCode)){
				return SEND_TOO_MANY;
			}
			return null;
		}

	}

	// 交易类型
	public enum DealType {

		RECHANGE(1, "充值"),
		WITHRAW(2, "提现"),
		PAYMENT(3, "代表付款"),
		RECEIPT(4, "收款"),
		OTHER(5, "其他");

		DealType(Integer type, String remark) {
			this.type = type;
			this.remark = remark;
		}

		private Integer type;

		private String remark;

		public Integer getType() {
			return type;
		}

		public String getRemark() {
			return remark;
		}

	}

	// 付款流水的类型
	public enum PaymentWaybillStatus {

		OWNER2COMPANY(0, "货主给物流公司支付运费【含油费】"),
		COMPANY2RENT(1, "物流公司给租赁公司支付运费【含油费】"),
		RENT2DRIVER(2, "租赁公司给司机支付运费【不含油费】"),
		COMPANY2OIL(3, "物流给加油公司支付油费"),
		OIL2OIL(4, "油气公司给加油站支付油费"),
		DRIVER2OIL(5, "司机到加油站加油"),
		COMPANY2DRIVER(6, "物流公司给司机支付运费"),
		COMPANY2DRIVER_OIL(7, "物流公司给司机支付油费【不可提现的】"),
		RECHARGE(8, "线下充值同步"),
		WITHRAW(9, "提现")
		;

		PaymentWaybillStatus(Integer type, String remark) {
			this.type = type;
			this.remark = remark;
		}

		private Integer type;

		private String remark;

		public Integer getType() {
			return type;
		}

		public String getRemark() {
			return remark;
		}

	}


	//油站短信模板
	public enum OilGasSmsTemplate {
//		PHONE_REG(1,"手机注册","209269"),
//		PHONE_FINDPASS(3,"手机密码找回","209267"),
//		PHONE_PASSEDIT(5,"手机号码变更","209267");
		PHONE_REG(1,"手机注册","209416"),
		PHONE_FINDPASS(3,"手机密码找回","209417"),
		PHONE_CHANGE(5,"手机号码变更","209417"),
		SET_SAFE_PASS(13,"设置安全密码","209417"),
		BANK_ACCOUNT_CHANGE(15,"更改银行账号","209417"),
		WECHAT_OFFICIAL_ACCOUNTS_BIND(16,"绑定微信公众号","209417");

		private Integer type;
		private String name ;
		private String value ;
		private OilGasSmsTemplate(Integer type, String name , String value ){
			this.type = type;
			this.name = name ;
			this.value = value ;
		}
		public String value() {return this.value;}
		public String getName() {return this.name;}
		public Integer getType(){return this.type;}

		/**
		 * 根据类型查找对应的发送代码
		 * @param type
		 * @return
		 */
		public static String getValueByType(Integer type) {
			String value = "";
			for(OilGasSmsTemplate smsTemplate : OilGasSmsTemplate.values()) {
				if(smsTemplate.getType().equals(type)){
					value = smsTemplate.value();
				}
			}
			return value;
		}

		/**
		 * 根据类型查找对应的发送信息
		 * @param type
		 * @return
		 */
		public static String getNameByType(Integer type) {
			String name = "";
			for(OilGasSmsTemplate smsTemplate : OilGasSmsTemplate.values()) {
				if(smsTemplate.getType().equals(type)){
					name = smsTemplate.getName();
				}
			}
			return name;
		}

	}

	//云商短信模板
	public enum YunShangSmsTemplate {
		//		PHONE_REG(1,"手机注册","209269"),
//		PHONE_FINDPASS(3,"手机密码找回","209267"),
//		PHONE_PASSEDIT(5,"手机号码变更","209267");
		PHONE_REG(1,"手机注册","225686"),
		PHONE_FINDPASS(2,"手机密码找回","225745"),
		PHONE_CHANGE(3,"手机号码变更","226503"),
		CONTRACT_SIGN(4,"签定合同","226730"),
		SET_SAFE_PASS(13,"设置安全密码","227054");

		private Integer type;
		private String name ;
		private String value ;
		private YunShangSmsTemplate(Integer type, String name , String value ){
			this.type = type;
			this.name = name ;
			this.value = value ;
		}
		public String value() {return this.value;}
		public String getName() {return this.name;}
		public Integer getType(){return this.type;}

		/**
		 * 根据类型查找对应的发送代码
		 * @param type
		 * @return
		 */
		public static String getValueByType(Integer type) {
			String value = "";
			for(YunShangSmsTemplate smsTemplate : YunShangSmsTemplate.values()) {
				if(smsTemplate.getType().equals(type)){
					value = smsTemplate.value();
				}
			}
			return value;
		}

		/**
		 * 根据类型查找对应的发送信息
		 * @param type
		 * @return
		 */
		public static String getNameByType(Integer type) {
			String name = "";
			for(YunShangSmsTemplate smsTemplate : YunShangSmsTemplate.values()) {
				if(smsTemplate.getType().equals(type)){
					name = smsTemplate.getName();
				}
			}
			return name;
		}

	}
	//云商短信模板

	//短信模板
	public enum SmsTemplate {
		PHONE_REG(1,"手机注册","145766"),
		EMAIL_REG(2,"邮箱注册",""),
		PHONE_FINDPASS(3,"手机密码找回","145819"),
		EMAIL_FINDPASS(4,"邮箱密码找回",""),
		PHONE_PASSEDIT(5,"手机密码变更","145821"),
		EMAIL_PASSEDIT(6,"邮箱密码变更",""),
		PHONE_GOODS_RECEIVE(7,"收货验证码","208502"),
//		PHONE_GOODS_RECEIVE(7,"收货验证码","147831"), //因模板问题，已舍弃
		PHONE_LOGIN(8,"动态密码登录验证码","145767"),
		PHONE_ORDER_RECEIVE(9," 接单短信通知信息","145769"),
		PHONE_CONTRACT_SIGN(10," 合同签订验证码短信 ","208505"),
//		PHONE_CONTRACT_SIGN(10," 合同签订验证码短信 ","147830"), //因模板问题，已舍弃
		PHONE_CONTRACT_SIGN_OK(11,"合同签订成功通知短信","147827"),
		PHONE_CONTRACT_PLAN(12,"货主发布运输计划通知物流公司短信","149184"),
		SET_SAFE_PASS(13,"设置安全密码","208499"),
//		SET_SAFE_PASS(13,"设置安全密码","163986"); //因模板问题，已舍弃
		BANK_ACCOUNT_CHANGE(15,"更改银行账号","209417"),
		WECHAT_OFFICIAL_ACCOUNTS_BIND(16,"绑定微信公众号","211614");

		private Integer type;
		private String name ;
		private String value ;
		private SmsTemplate(Integer type, String name , String value ){
			this.type = type;
			this.name = name ;
			this.value = value ;
		}
		public String value() {return this.value;}
		public String getName() {return this.name;}
		public Integer getType(){return this.type;}

		/**
		 * 根据类型查找对应的发送代码
		 * @param type
         * @return
         */
		public static String getValueByType(Integer type) {
			String value = "";
			for(SmsTemplate smsTemplate : SmsTemplate.values()) {
				if(smsTemplate.getType().equals(type)){
					value = smsTemplate.value();
				}
			}
			return value;
		}

	}
	//短信模板

	/**
	 * 签章签名信息中的签名来源
	 */
	public enum SignSource {
		WULIU(1,"yzwl600277"),
		YUNSHANG(2,"yzys600277");

		private int value;
		private String desc;
		SignSource(int value, String desc){
			this.value = value;
			this.desc = desc;
		}
		public int getValue(){
			return value;
		}
		public String getDesc(){
			return desc;
		}
		public static SignSource valueOf(int value){
			if(WULIU.getValue() == value){
				return WULIU;
			}
			if(YUNSHANG.getValue() == value){
				return YUNSHANG;
			}
			return null;
		}
	}


	/**
	 * 签章双方类型，3 企业对企业 4 企业对个人
	 */
	public enum SignType {
		E2E(3,"企业对企业签章"),
		P2E(4,"个人对企业签章");

		private int value;
		private String desc;
		SignType(int value, String desc){
			this.value = value;
			this.desc = desc;
		}
		public int getValue(){
			return value;
		}
		public String getDesc(){
			return desc;
		}
		public static SignType valueOf(int value){
			if(E2E.getValue() == value){
				return E2E;
			}
			if(P2E.getValue() == value){
				return P2E;
			}
			return null;
		}
	}

	/**
	 * 签章用户双方类型，1 甲方 2 乙方
	 */
	public enum SignUserType {
		JIAFANG(1,"甲方"),
		YIFANG(2,"乙方"),
		SALE(1,"卖方"),
		BUY(2,"买方");

		private int value;
		private String desc;
		SignUserType(int value, String desc){
			this.value = value;
			this.desc = desc;
		}
		public int getValue(){
			return value;
		}
		public String getDesc(){
			return desc;
		}
		public static SignUserType valueOf(int value){
			if(JIAFANG.getValue() == value){
				return JIAFANG;
			}
			if(YIFANG.getValue() == value){
				return YIFANG;
			}
			if(SALE.getValue() == value){
				return SALE;
			}
			if(BUY.getValue() == value){
				return BUY;
			}
			return null;
		}
		public static SignUserType DescOf(String desc){
			if(desc.equals(JIAFANG.getDesc())){
				return JIAFANG;
			}
			if(desc.equals(YIFANG.getDesc())){
				return YIFANG;
			}
			if(desc.equals(SALE.getDesc())){
				return SALE;
			}
			if(desc.equals(BUY.getDesc())){
				return BUY;
			}
			return null;
		}
	}

	/**
	 * 印章中心文字，1 合同专用章
	 */
	public enum SignSealType {
		HTZYZ(1,"合同专用章");

		private int value;
		private String desc;
		SignSealType(int value, String desc){
			this.value = value;
			this.desc = desc;
		}
		public int getValue(){
			return value;
		}
		public String getDesc(){
			return desc;
		}
		public static SignSealType valueOf(int value){
			if(HTZYZ.getValue() == value){
				return HTZYZ;
			}
			return null;
		}
	}
}
