package com.webup.soa.yunshang.common;


import com.webup.soa.utils.DateUtils;
import com.webup.soa.yunshang.pay.ForbidRepeatVo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统常量定义
 *
 * @author dajia
 */
public class CommonConst {

    public static final String FileUploadPath = "UploadFile";
    public static final String EXCELPATH = "exportExcel";

    /**
     * 入金
     */
    public final static Integer RECHARGE = 4;

    /**
     * 提现
     */
    public final static Integer WITHDRAWAL = 5;

    /**
     * 资金支付
     */
    public final static Integer PAYMENT = 6;

    /**
     * 充值
     */
    public final static byte PAY_RECHARGE = 0;

    /**
     * 提现
     */
    public final static byte PAY_WITHDRAW = 1;

    /**
     * 货主支付
     */
    public final static byte PAY_ORDER = 2;
    /**
     * 运单id正则：查询用
     */
    public static final String TRANSPORT_ID_FORMAT = "^%s$|^%s,|,%s,|,%s$|,%s,$";
    /**
     * 代表主账户 yz_user 的 corpId字段
     */
    public static final Integer OWNERACCT = 0;

    public static Map<String, ForbidRepeatVo> PAY_REQUEST_CACHE = new ConcurrentHashMap();

    /**
     * 获取所有的枚举enum
     *
     * @return
     */
    public static Map<String, Map> getEnum() {
        Map<String, Map> result = new HashMap<>(7);

        Map<Integer, String> areaMap = new HashMap<>();
        for (AreaType areaType : AreaType.values()) {
            areaMap.put(areaType.getIndex(), areaType.getName());
        }
        result.put("areaType", areaMap);

        Map<Integer, String> goodsWeightMap = new HashMap<>();
        for (GoodsWeightType goodsWeightType : GoodsWeightType.values()) {
            goodsWeightMap.put(goodsWeightType.getIndex(), goodsWeightType.getName());
        }
        result.put("goodsWeightType", goodsWeightMap);

        Map<Integer, String> settlementTypeMap = new HashMap<>();
        for (SettlementType settlementType : SettlementType.values()) {
            settlementTypeMap.put(settlementType.getIndex(), settlementType.getName());
        }
        result.put("settlementType", settlementTypeMap);

        Map<Integer, String> tradeModeMap = new HashMap<>();
        for (TradeMode tradeMode : TradeMode.values()) {
            tradeModeMap.put(tradeMode.getIndex(), tradeMode.getName());
        }
        result.put("tradeMode", tradeModeMap);

        Map<Integer, String> deliveryTypeMap = new HashMap<>();
        for (DeliveryType deliveryType : DeliveryType.values()) {
            deliveryTypeMap.put(deliveryType.getIndex(), deliveryType.getName());
        }
        result.put("deliveryType", deliveryTypeMap);

        Map<Integer, String> settlementCycleTypeMap = new HashMap<>();
        for (SettlementCycleType settlementCycleType : SettlementCycleType.values()) {
            settlementCycleTypeMap.put(settlementCycleType.getIndex(), settlementCycleType.getName());
        }

        result.put("settlementCycleType", settlementCycleTypeMap);

        Map<String, String> sys = new HashMap<>();
        sys.put("nowTime", DateUtils.formatCurrentDate(""));
        result.put("sys", sys);
        return result;
    }

    /**
     * 类型 0 否 1 是
     */
    public enum CommonState {
        NO(0), YES(1);
        private int index;

        CommonState(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    /**
     * 类型 0 销售 1 采购 0 卖 1 买
     */
    public enum SalePurchaseType {
        SALER("经销", 0), PURCHASER("采购", 1);
        private String name;
        private int index;

        SalePurchaseType(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public static SalePurchaseType valueOf(int value) {
            if (SALER.getIndex() == value) {
                return SALER;
            }
            if (PURCHASER.getIndex() == value) {
                return PURCHASER;
            }
            return null;
        }

        public static String getName(int value) {
            if (SALER.getIndex() == value) {
                return SALER.getName();
            }
            if (PURCHASER.getIndex() == value) {
                return PURCHASER.getName();
            }
            return "";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    /**
     * 日志类型
     */
    public enum LogType {
        ORDER("订单", 1), CONTRACT("合同", 2);
        private String name;
        private int index;

        LogType(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    /**
     * 1业务员 3财务员 3合同管理员 0其他人员
     */
    public enum UserRoleType {
        OTHER(0), BUSINESS(2), FINANCE(3), CONTRACT(4);
        private int index;

        UserRoleType(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public enum GoodsState {
        DRAFT(0, "未发布"), PUBLISH(1, "进行中"), OVER(2, "已完成");

        private int index;
        private String remark;

        GoodsState(int index, String remark) {
            this.index = index;
            this.remark = remark;
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * 状态 草稿  0 待审核 1 审核通过 2 对方确认 3 对方申请终止合同 4 Owner所有者（产品发布者）申请终止合同 5 终止合同拒绝 6 终止合同确认7  终止合同确认（已支付完成终止）8
     */
    public enum UserContractOrderState {
        DRAFT(0), WAIT(1), THROUGH(2), CONFIRM(3), ENDASK(4), OWNERENDASK(5), ENDREFUSE(6), ENDOFPAYING(7), ENDOFPAYOVER(8)
        ;
        private int index;
        private String remark;
        UserContractOrderState(int index) {
            this.index = index;
        }

        UserContractOrderState(int index, String remark) {
            this.index = index;
            this.remark = remark;
        }

        public int getIndex() {
            return index;
        }
    }

    public enum UserCustomerCerType {//认证状态 0 默认 1 审核通过 2 拒绝
        DRAFT(0), THROUGH(1), REFUSE(2);
        private int index;

        private UserCustomerCerType(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * 订单状态 0 草稿 1 卖方审核通过 2 买方签 b 3 卖方签 a  4 都签（待支付）5执行中（支付中）6已支付（完成支付）7交易完成 8取消
     *
     * @return
     */
    public enum GoodsOrderState {
        DRAFT(0), THROUGH(1), SIGNED_B(2), SIGNED_A(3), SIGNED_ALL(4), PAYING(5), PAY_OVER(6), OVER(7), CANCEL(8);
        private int index;

        GoodsOrderState(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * 地区
     *
     * @return
     */
    public enum AreaType {
        SOUTH("华南", 1), EAST("华东", 2), MIDDLE("华中", 3), NORTH("华北", 4), EAST_NORTH("东北", 5), WEST_NORTH("西北", 6), WEST_SOUTH("西南", 7);
        private String name;
        private int index;

        AreaType(String name, int index) {
            this.name = name;
            this.index = index;
        }

        /**
         * 获取所有的枚举enum
         *
         * @return
         */
        public static String getName(int value) {
            for (AreaType areaType : AreaType.values()) {
                if (areaType.getIndex() == value) {
                    return areaType.getName();
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    /**
     * 订单提货状态
     */
    public enum OrderDeliveryState {
        //0 草稿 1 提交待审核 2 审核通过 3 已收货  4 审核拒绝 5 已取消 6 已失效 -1 删除
        DRAFT(0), SUBMIT(1), OVER(2), RECEIPT(3), DENY(4), CANCEL(5), INVALID(6), DELETE(-1);
        private int index;

        OrderDeliveryState(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * 是否变更
     */
    public enum OrderDeliveryChangeState {
        DRAFT("接受变更", 0), SUBMIT("提交变更", 1), DENY("拒绝变更", 2);
        private String name;
        private int index;

        OrderDeliveryChangeState(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    /**
     * 取消状态
     */
    public enum OrderDeliveryInfoCancelState {
        DRAFT("未取消/同意取消", 0), SUBMIT("提交取消", 1), DENY("拒绝取消", 2), CANCEL("取消", -1);
        private String name;
        private int index;

        OrderDeliveryInfoCancelState(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    /**
     * 变更状态
     */
    public enum OrderDeliveryInfoChangeState {
        DRAFT("未变更", 0), SUBMIT("提交变更", 1), DENY("拒绝变更", 2), AGREE("接受变更", 3);
        private String name;
        private int index;

        OrderDeliveryInfoChangeState(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }


    /**
     * 结算方式
     */
    public enum SettlementType {
        BANKACCEPTS("银行承兑汇票", 1), ACCEPTS_3MONTH("3个月银行承兑汇票", 2), ACCEPTS_6MONTH("6个月银行承兑汇票", 3), TELETRAN("电汇", 4), CHECK("支票", 5), BUSINESSACCEPTS("商业承兑汇票", 6), CASH("现金", 7);
        private String name;
        private int index;

        SettlementType(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    /**
     * 云商支付的交易方式
     */
    public enum TradeMode {
        MONEYFIRST("先款后货", 0), GOODSFIRST("先货后款", 1);
        private String name;
        private int index;

        TradeMode(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public enum SettlementCycleType {//结算周期
        ACCEPTS_1MONTH("1个月", 1), ACCEPTS_2MONTH("2个月", 2), ACCEPTS_3MONTH("3个月", 3);
        private String name;
        private int index;

        SettlementCycleType(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
    public enum DeliveryType {//交货方式
        TAKEMINE("自提", 1), SEND("送货", 2);
        private String name;
        private int index;

        DeliveryType(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
    public enum GoodsWeightType {//货物单位
        TON("吨", 0), CUBE("立方", 1);
        private String name;
        private int index;

        GoodsWeightType(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
    /**
     * 企业注册授权书 企业Logo 企业营业执照 企业安全许可证
     */
    public enum ImgSourceType {
        BUSIN_REG_AUTH(1),
        BUSIN_LOGO(2),
        BUSIN_LICENSE(3),
        BUSIN_SAFE_LICENSE(4);

        private int value;

        ImgSourceType(int value) {
            this.value = value;
        }

        public static ImgSourceType geImgSourceType(String name) {
            try {
                return ImgSourceType.valueOf(name);
            } catch (Exception e) {
                return null;
            }
        }

        public int getValue() {
            return this.value;
        }
    }
    public enum ReviewState {
        //未审核 审核中 审核通过 审核失败
        REVIEW_PRE(0),
        REVIEW_ING(1),
        REVIEW_SUCCESS(2),
        REVIEW_FAIL(-1);
        private int value;

        ReviewState(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
    /**
     * 短信模板
     */
    public enum SmsTemplate {
        PHONE_REG("手机注册", "145766"),
        PHONE_FINDPASS("手机密码找回", "145819"),
        PHONE_PASSEDIT("手机密码变更", "145821"),
        PHONE_GOODS_RECEIVE("收货验证码", "147831"),
        PHONE_LOGIN("动态密码登录验证码", "145767"),
        PHONE_ORDER_RECEIVE(" 接单短信通知信息", "145769"),
        PHONE_CONTRACT_SIGN(" 合同签订验证码短信 ", "147830"),
        PHONE_CONTRACT_SIGN_OK("合同签订成功通知短信", "147827"),
        PHONE_CONTRACT_PLAN("货主发布运输计划通知物流公司短信", "149184"),
        SET_SAFE_PASS("设置安全密码", "163986");

        private String name;
        private String value;

        SmsTemplate(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }
    /**
     * 签章中心关键字
     */
    public enum SignKeyWords {
        JIAFANG("甲方", 1),
        YIFANG("乙方", 2),
        BUYER("买方", 3),
        SELL("卖方", 4);
        private String name;
        private Integer value;

        SignKeyWords(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 订单类型
     */
    public enum GoodsOrderType {
        SALE("销售", 0),
        PURCHASE("采购", 1);

        private String name;
        private int value;

        private GoodsOrderType(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public static String getName(Integer value) {
            if (SALE.value == value) {
                return SALE.getName();
            }
            if (PURCHASE.value == value) {
                return PURCHASE.getName();
            }
            return "";
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return this.value;
        }
    }

    /**
     * 订单确认收货 接收状态 0 未发货 1 提交已发货 2 确认已收货
     */
    public enum OrderSettlementFileState {
        DRAFT(0),
        PASS(1),
        DEL(-1);
        private int value;
        OrderSettlementFileState(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }

    /**
     * 订单确认收货 接收状态 0 未发货 1 提交已发货 2 确认已收货
     */
    public enum GoodsOrderReceiveState {
        DRAFT(0),
        SUBMIT(1),
        RECEIVED(2);
        private int value;

        GoodsOrderReceiveState(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
    public enum AllowLogin {
        REFUSE_LOGIN("拒绝登录", 0),
        ALLOW_LOGIN("允许登录", 1);

        private String name;
        private int value;

        AllowLogin(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
    public enum CodeType {
        WEB_REGION("网页注册", 1),
        PASSWORD_FIND("密码找回", 2),
        CHANGE_PHONE("更换手机", 3),
        CONTRACT_SIGN("签订合同", 4);

        private String name;
        private int value;

        CodeType(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    /**
     * 商品发发布状态类型
     */
    public enum GoodsPublishState {
        DRAFT("草稿", 0),
        SUBMIT("发布", 1),
        DELETE("删除", -1);
        private String name;
        private int value;

        GoodsPublishState(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
    /**
     * 商品属性类型
     */
    public enum GoodsPropType {
        BRAND("商品品牌", 1),
        SPEC("商品规格", 2),
        GRADE("商品品级", 3);
        private String name;
        private int value;

        GoodsPropType(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 记录 调用发送短信、二次激活接口，返回的标志位的使用情况
     */
    public enum VerCodeStatus {

        NO_USED(Byte.valueOf("0"), "未使用"), USEED(Byte.valueOf("1"), "已使用");

        private Byte type;
        private String remark;

        VerCodeStatus(Byte type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        public Byte getType() {
            return type;
        }

        public void setType(Byte type) {
            this.type = type;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    /**
     *  注册用户类型
     */
    public enum UserType {

        OWNER(1, "货主"), LOGISTICS(2, "物流公司"), RENT(1000, "租赁公司"), DRIVER(4, "司机"), OILCOMPANY(5, "加油站");

        private int type;
        private String remark;

        UserType(int type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

    }

    public enum Platform {

        WULIU(Byte.valueOf("0"), "物流平台"), YUNSHANG(Byte.valueOf("1"), "云商平台");

        private Byte platform;
        private String remark;

        Platform(Byte platform, String remark) {
            this.platform = platform;
            this.remark = remark;
        }

        public Byte getPlatform() {
            return platform;
        }

    }

    /**
     * 运单状态信息
     */
    public enum TransportStatus {
        NO_PAY((short) 2, "待支付"), PAYING((short) 5, "支付中【批量支付的状态】"),
        COMMENT((short) 3, "待评价"), OVER((short) 4, "已完成");

        private short type;
        private String remark;

        TransportStatus(short type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        public short getType() {
            return type;
        }

        public void setType(short type) {
            this.type = type;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    /**
     * 调用发送短信、二次激活接口，返回的标志位信息的类型
     */
    public enum VerCodeType {

        OPEN_COUNT_TYPE(Byte.valueOf("1"), "开户、修改、注销"),
        ACTIVE_TYPE(Byte.valueOf("2"), "二次激活");

        private Byte type;
        private String remark;

        VerCodeType(Byte type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        public Byte getType() {
            return type;
        }

        public void setType(Byte type) {
            this.type = type;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    public static class Result {

        /**
         * 参数不全
         */
        public static final Integer PARAM_ERROR = -1;

        /**
         * 系统错误
         */
        public static final Integer SYSTEM_ERROR = -2;

        /**
         * 无权限操作
         */
        public static final Integer NOPOWER_ERROR = -98;

        /**
         * 未登录
         */
        public static final Integer LOGIN_ERROR = -99;

        /**
         * 启用
         */
        public static final Integer FLAG_TRUE = 1;


        /**
         * 停用
         */
        public static final Integer FLAG_FALSE = 0;

        /**
         * 安全密码错误
         */
        public static final Integer SAFEPASS_ERROR = -3;
    }

    /**
     * 系统 物流 云商
     */
    public static class SystemSource {
        public static final Integer WL = 1;
        public static final Integer YS = 2;
    }

    public static class Symbols {
        public static final String forwardSlash = "/";
        public static final String point = ".";
        public static final String colon = ":";
    }

    /**
     * Session Key
     */
    public static class SessionKey {
        public static final String SMSKEY = "SMSKEY";
        public static final String CODEKEY = "CODEKEY";
    }

    /**
     * 程序中提示信息
     */
    public enum TipEnum {
        /**
         * 与登录相关
         */
        USER_NOT_EXISTIS("账号不存在!"), REFUSED_LOGIN("账号拒绝登录!"), INPUT_CHECK_CODE("请重新输入验证码！"),
        CHECK_CODE_NOT_RIGHT("验证码不正确！"), PASSWORD_NOT_RIGHT("密码错误！"), CONFIRM_PWD_NOT_RIGHT("请确认再次输入密码！"),

        /**
         * 鑫e商贸开户相关
         */
        EXIST_ACCOUNT("已开通过支付账户！"), NOT_EXIST_ACCOUNT("当前用户未开通支付账户！"), INVALID_CODE("验证码已失效，请重新获取验证码！"),

        /**
         * 其他
         */
        PERMISSIONS_INSUFFICIENT("权限不足！"),

        /**
         * 提货审核操作
         */
        OVER_ORDER_NUM("提货数量不能超过订单数量!"), OVER_PAY_NUM("提货数量不能超过订单可提货数量!"),
        NOT_ERP_USER("非化学用户！"), DELIVERY_NOT_EXIST("提货单不存在！"), DELIVERY_STATE_ERR("此提货单不能审核！"),
        HAS_NOT_PAYED("订单未付款，不能提货！"), ORDER_TYPE_NOT_RIGHT("提货的订单必须是销售订单！"), NOT_OWN_ORDER("不能创建不是自己签订订单的提货单！"),


        ;
        String message;

        TipEnum(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

    /**
     * ERP datalink actflag
     */
	public enum ERPDataLinkActFlag {

		DELTE(-1, "删除"), UNSUBMIT(0, "未提交"), SUBMIT(1, "已提交"), THROUGH(2, "已审核"), REFUSE(3, "拒绝"), FAIL(4, "失败");

		ERPDataLinkActFlag(int type, String remark) {
			this.type = type;
			this.remark = remark;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		private int type;
		private String remark;

	}

    /**
     * yz_erp_datalink typeid 枚举
     */
	public enum EepTypeIdEnum {

        CONTRACT(1, "合同")
	    ;
	    private Integer type;

	    private String remark;

        EepTypeIdEnum(Integer type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        public Integer getType() {
            return type;
        }
    }
    public enum CommonErpEnumType {
        //1,3,4,5 类型需要补充 `type_id` int(11) NOT NULL COMMENT '1 合同 2 erp提货单数据 3 运输单 4 收票登记  5 收款录入',
        CONTRACT_TYPE(1, "合同"),
        DELIVERY_INFO_TYPE(2, "erp提货未提交单数据"),
        DELIVERY_INFO_SUBMIT_TYPE(3,"erp提货单已提交的数据准备推送到erp");
        public final int value;
        public final String name;

        CommonErpEnumType(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public static String getName(int value) {
            for (CommonErpEnumType sourceType : CommonErpEnumType.values()) {
                if (sourceType.value == value) {
                    return sourceType.name;
                }
            }

            return null;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

    }

    /**
     * 提货单的数据、合同的状态 来源
     */
    public enum DriverDataSourceEnum {

        LOCAL(0, "本地"), HX_ERP(1, "化学ERP")
        ;
        private Integer source;

        private String remark;

        public Integer getSource() {
            return source;
        }

        DriverDataSourceEnum(Integer source, String remark) {
            this.source = source;
            this.remark = remark;
        }

        public static boolean existSource(Integer source) {
            boolean exist = false;
            for(DriverDataSourceEnum instance : DriverDataSourceEnum.values()) {
                if(instance.getSource().equals(source)) {
                    exist = true;
                }
            }
            return exist;
        }

    }

    /**
     * 提货单详情的审核状态
     */
    public enum DeliveryInfoAudit {

        DRAFT(0, "草稿"), AUDITING(1, "待审核"),  PASS(2, "通过"), REFUSED(3, "未通过")
        ;

        private Integer status;

        private String remark;

        DeliveryInfoAudit(Integer status, String remark) {
            this.status = status;
            this.remark = remark;
        }

        public Integer getStatus() {
            return status;
        }
    }

    /**
     * ERP合同审核的状态
     */
    public enum ErpContractAuditStatus {

        UNSTATUS("0", "无状态"), FREE("1", "自由"), AUDIT("2", "审批"), FREEZE("3", "冻结"),CLOSE("4", "关闭"), BLANKOUT("5", "作废"), ABATE("9", "失效"), FINISH("6", "审批通过"), AUDITING("7", "正在审批"), NOPASS("8", "审批未通过")
        ;

        private String status;

        private String remark;

        ErpContractAuditStatus(String status, String remark) {
            this.status = status;
            this.remark = remark;
        }

        public String getStatus() {
            return status;
        }
    }

    /**
     * 此枚举定义的内容是，接入erp用户的提货单号的ID
     */
    public enum ERPplatform {
        HX(-1, "化学erp");

        private Integer orderId;

        private String remark;

        ERPplatform(Integer orderId, String remark) {
            this.orderId = orderId;
            this.remark = remark;
        }

        public Integer getOrderId() {
            return orderId;
        }
    }

}
