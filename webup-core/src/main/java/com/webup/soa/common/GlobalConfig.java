package com.webup.soa.common;

/******************************************
 * @author: 大鹏 (xupenghong@elion.com.cn)
 * @createDate: 2017/7/31
 * @company: (C) Copyright 亿兆华盛 2017
 * @since: JDK 1.8
 * @projectName:IntelliJ IDEA
 * @Description:整个框架的全局配置
 ******************************************/
public class GlobalConfig {


    public static final String USER_ID = "user_id";
    public static final String SERIAL_NO = "serial_no";
    public static final String OPERATE_TYPE = "operate_type";

    public final static String OK = "OK";
    public final static String ERROR = "ERROR";

    /**
     *  用户出金、接口返回‘交易处理中’的关键字
     */
    public final static String WITHDRAW_PAYING = "交易处理中";

    /**
     * 支付超时，提示信息
     */
    public final static String PAY_TIMEOUT_TEXT = "支付处理中，请稍后再试";

    /**
     * 参数校验异常
     */
    public final static String PARAM_CHECK_INVALID = "PARAM_CHECK_INVALID";

    /**
     * 超时支付
     */
    public final static String PAY_TIMEOUT = "PAY_TIMEOUT";

    /**
     * 超时
     */
    public final static String TIMEOUT = "TIMEOUT";

    /**
     * ams_user表没有查到记录
     */
    public final static String NO_USER = "NO_USER";

    /**
     * 用户类型错误
     */
    public final static String USER_TYPE_ERROR = "USER_TYPE_ERROR";

    /**
     * 没有开通支付账户
     */
    public final static String NO_PAY_USER = "NO_PAY_USER";

    /**
     * 支付账户没有激活
     */
    public final static String PAY_ACCT_NOT_ACTIVE = "PAY_ACCT_NOT_ACTIVE";

    /**
     * 支付账户余额不足
     */
    public final static String NO_ENOUGH_BALANCE = "NO_ENOUGH_BALANCE";

    /**
     * 油费不足
     */
    public final static String NO_ENOUGH_OIL_MONEY = "NO_ENOUGH_OIL_MONEY";

    /**
     * 虚拟户状态异常【支付账户创建成功，但是虚拟户账号没有，可能是创建或激活接口网络超时，没有拿到虚拟户信息】
     */
    public final static String NO_VIRTUAL_ACCT = "NO_VIRTUAL_ACCT";

    /**
     * 只有待支付状态的运单才可以进入支付环节
     */
    public final static String TRANSPORT_STATUS_ERROR = "TRANSPORT_STATUS_ERROR";

    /**
     * 租赁公司配额不足，无法支付
     */
    public final static String LIMIT_QUOTA_NOT_ENOUGH= "LIMIT_QUOTA_NOT_ENOUGH";

    /**
     * 调用资金支付接口报错
     */
    public final static String PAY_ERROR = "PAY_ERROR";

    /**
     * 租赁公司当前时间未设置配额信息
     */
    public final static String RENT_QUOTA_TIME_ERROR = "RENT_QUOTA_TIME_ERROR";

    /**
     * 租赁公司给司机打款时，司机的账号不正确
     */
    public final static String VIRTUAL_ACCT_NOT_RIGHT = "VIRTUAL_ACCT_NOT_RIGHT";

    /**
     * 无权操作或是用户资质认证没通过
     */
    public final static String NO_AUTHORITY = "NO_AUTHORITY";

    /**
     * 没有查询到验证标志位
     */
    public final static String NO_SIGN = "NO_SIGN";

    /**
     * 安全密码交易失败
     */
    public final static String SAFE_PWD_ERR = "SAFE_PWD_ERR";

    /**
     * 没有查询到对应的支付信息
     */
    public final static String NO_PAYINFO = "NO_PAYINFO";

    /**
     * 不是车队长
     */
    public final static String NOT_CHIEF_OF_DRIVER = "NOT_CHIEFOFDRIVER";

    /**
     * 不是司机身份
     */
    public final static String NOT_DRIVER = "NOT_DRIVER";

    /**
     * 分配油费，A，B关系不正确
     * 1.只有车队， 车队长分配给司机油费
     * 2.外雇车队，车队长给所属的外雇车队的司机分配油费
     *
     */
    public final static String NO_RELATIONSHIP = "NO_RELATIONSHIP";

    /**
     * 没有查询到此合同
     */
    public final static String NO_CONTRACT = "NO_CONTRACT";

    /**
     * 没有查询到此订单
     */
    public final static String NO_ORDER = "NO_ORDER";

    /**
     *
     */
    public final static String PAY_MONEY_ZERO = "PAY_MONEY_ZERO";

    /**
     * 已经开通过支付账户
     */
    public final static String EXIST_PAYMENT_ACCT = "EXIST_PAYMENT_ACCT";

    /**
     * 支付流水类型不正确
     */
    public final static String PAY_TYEP_ERR = "PAY_TYEP_ERR";

    /**
     * 还款人身份不对
     */
    public final static String IDENTITY_NOT_RIGHT = "IDENTITY_NOT_RIGHT";

    /**
     * 获取给物流付款，合同状态不正确
     */
    public final static String CONTRACT_STATUS_ERR = "CONTRACT_STATUS_ERR";

    /**
     * 获取给订单付款，订单状态不正确
     */
    public final static String ORDER_STATUS_ERR = "ORDER_STATUS_ERR";

    /**
     * 司机加油，加油站类型不对
     */
    public final static String NOT_GAS_COMPANY = "NOT_GAS_COMPANY";

    /**
     * 不是同一付款批次的运单，不能进行批量支付
     */
    public final static String NOT_SAME_BATCH_NO = "NOT_SAME_BATCH_NO";

    /**
     * 支付金额不正确
     */
    public final static String MONEY_NOT_RIGHT = "MONEY_NOT_RIGHT";

    /**
     * 短时间内重复提交
     */
    public final static String REPEAT_SUBMIT = "REPEAT_SUBMIT";

    public final static String NANJ_BANK_INTER_OK = "000000";
    public final static String NANJ_BANK_INTER_CHECK_FAIL = "鑫e商贸接口验签失败！";
    public final static String WITHDRAW_TIME_OUT_TIP = "银行处理中，请稍后！";
    public final static String REPEAT_SUBMIT_TIP = "一分钟内请勿重复提交";

    //  提交南京银行鑫e商贸接口的参数名称
    public final static String NANJ_BANK_REQ_TRANS_NAME = "transName";
    public final static String NANJ_BANK_REQ_PLAIN = "Plain";
    public final static String NANJ_BANK_REQ_SIGNATURE = "Signature";

    //  南京银行鑫e商贸接口返回xml，解析的xpath节点
    public final static String NANJ_BANK_RSQ_TRANS_NAME = "/packet/transName";
    public final static String NANJ_BANK_RSQ_PLAIN = "/packet/Plain";
    public final static String NANJ_BANK_RSQ_SIGNATURE = "/packet/Signature";

    //  南京银行鑫e商贸接口返回xml，Plain节点内容
    public final static String NANJ_BANK_RSQ_PLAIN_RSQCODE = "RespCode";
    public final static String NANJ_BANK_RSQ_PLAIN_RSQMSG = "RespMsg";
    public final static String NANJ_BANK_RSQ_PLAIN_MERSEQNO = "MerSeqNo";
    public final static String NANJ_BANK_RSQ_PLAIN_TRANSSEQNO = "TransSeqNo";


    // 南京银行鑫e商贸接口，二级账户开立，账户操作类型枚举
    public enum NanJBankOperType {

        OPEN(1, "开户"), EDIT(2, "修改"), CANCEL(3, "注销"), OPENSUB(4, "开立子账户");

        public int getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

        private int type;
        private String remark;

        NanJBankOperType(int type, String remark) {
            this.type = type;
            this.remark = remark;
        }
    }

    /**
     * 南京银行鑫e商贸接口，二级账户开立，是否计息字段枚举
     */
    public enum NanJBankOperIsRate {

        NO("0", "否"), YES("1", "是");

        public String getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

        private String type;
        private String remark;

        NanJBankOperIsRate(String type, String remark) {
            this.type = type;
            this.remark = remark;
        }

    }

    /**
     * 南京银行鑫e商贸接口，二级账户开立，客户类型枚举
     */
    public enum NanJBankCustomerType {

        PERSONAL(Byte.valueOf("0"), "个人"), COMPANY(Byte.valueOf("1"), "企业【物流】");

        public Byte getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

        private Byte type;
        private String remark;

        NanJBankCustomerType(Byte type, String remark) {
            this.type = type;
            this.remark = remark;
        }
    }

    /**
     * 南京银行鑫e商贸接口，二级账户开立，证件类型枚举
     */
    public enum NanJBankCertiType {

        IDCARD("1", Byte.valueOf("1"), "二代居民身份证"), HKB("2", Byte.valueOf("2"), "户口本"), HZ("3", Byte.valueOf("3"), "护照"),
        GANGAOJMLWNLTXZ("4", Byte.valueOf("4"), "港澳居民来往内陆通行证"), GANGAOTBHXZ("5", Byte.valueOf("5"), "港澳同胞回乡证"),
        TAIWANJMLWNLTXZ("6", Byte.valueOf("6"), "台湾居民来往大陆通行证"), OTHER("7", Byte.valueOf("7"), "其它有效证件"),
        JGDMZ("m", Byte.valueOf("8"), "机构代码证"), YYZZ("n", Byte.valueOf("9"), "营业执照"), DJZS("p", Byte.valueOf("10"), "登记证书"),
        GSSWDJZH("q", Byte.valueOf("11"), "国税税务登记证号"), DSSWDJZH("r", Byte.valueOf("12"), "地税税务登记证号"),;

        NanJBankCertiType(String code, Byte type, String remark) {
            this.code = code;
            this.remark = remark;
            this.type = type;
        }

        String code;
        String remark;
        Byte type;          //  平台自定义类型，用于开户的证件类型

        public Byte getType() {
            return type;
        }

        public String getCode() {
            return code;
        }

        public String getRemark() {
            return remark;
        }


        public static Byte getTypeByCode(String code) {
            Byte type = null;
            for (NanJBankCertiType ele : NanJBankCertiType.values()) {
                if (ele.getCode().equals(code)) {
                    type = ele.getType();
                    break;
                }
            }
            return type;
        }

        public static String getCodeByType(Byte type) {
            String code = null;
            for (NanJBankCertiType ele : NanJBankCertiType.values()) {
                if (ele.getType().equals(type)) {
                    code = ele.getCode();
                    break;
                }
            }
            return code;
        }

        public static String getRemarkByType(Byte type) {
            String remark = null;
            for (NanJBankCertiType ele : NanJBankCertiType.values()) {
                if (ele.getType().equals(type)) {
                    remark = ele.getRemark();
                    break;
                }
            }
            return remark;
        }


    }

    /***
     * 南京银行鑫e商贸接口，二级账户开立，绑定账户类型枚举
     */
    public enum NanJBankBindingAccType {

        ENTERPRISE_ACCOUNT(Byte.valueOf("0"), "企业帐号"), CARD(Byte.valueOf("1"), "卡");

        public Byte getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

        private Byte type;
        private String remark;

        NanJBankBindingAccType(Byte type, String remark) {
            this.type = type;
            this.remark = remark;
        }
    }

    /**
     * 南京银行鑫e商贸接口，发送短信验证码，发送类型枚举
     */
    public enum NanJBankMsgType {

        OPEN(1, "开户、修改、注销"), BINDING(2, "账户绑定"), INTOGOLD(3, "入金"), OUTGOLD(4, "出金"), PAY(5, "支付");

        public int getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

        private int type;
        private String remark;

        NanJBankMsgType(int type, String remark) {
            this.type = type;
            this.remark = remark;
        }
    }

    /**
     *  南京银行鑫e商贸接口,支持的货币类型
     */
    public enum CurrencyType {

        YUAN("156", "人民币"), POUND("826", "英镑"), HONGKONG_DOLLAR("344", "港元"),
        DOLLAR("840", "美元"), SWISS_FRANC("756", "瑞士法郎"), YEN("392", "日元"),
        GERMAN_MARK("276", "德国马克"), FRENCH_FRANC("250", "法国法郎"), RUPEE("360", "卢比"),
        NORTH_KOREAN_CIRCLE("408", "北朝鲜圆");

        public String getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

        private String type;
        private String remark;

        CurrencyType(String type, String remark) {
            this.type = type;
            this.remark = remark;
        }

    }

    /**
     * 南京银行鑫e商贸接口交易码
     */
    public enum NanJBankInterfTransCode {
        OPEN_ACCOUNT("TP01", Byte.valueOf("1"), "二级账户开立（开户）"),
        EDIT_ACCOUNT("TP01", Byte.valueOf("2"), "二级账户开立（修改）"),
        CANCEL_ACCOUNT("TP01", Byte.valueOf("3"), "二级账户开立（注销）"),
        ACCOUNT_ACTIVATE("TP03", Byte.valueOf("4"), "二级账户激活"),
        INTO_GOLD("TP04", Byte.valueOf("5"), "入金"),
        OUT_GOLD("TP05", Byte.valueOf("6"), "出金"),
        FROZE_GOLD("TP06", Byte.valueOf("7"), "资金冻结（担保交易功能）"),
        UNFROZE_GOLD("TP07", Byte.valueOf("8"), "资金解冻（担保交易功能）"),
        AMOUNT_PAYMENT("TP08", Byte.valueOf("9"), "资金支付"),
        AMOUNT_REFUND("TP09", Byte.valueOf("10"), "资金退货"),
        FREE_QGLOD("QR01", Byte.valueOf("11"), "冻结、解冻明细查询"),
        INOUT_QGLOD("QR02", Byte.valueOf("12"), "出入金明细查询"),
        PAYMENT_QGLOD("QR03", Byte.valueOf("13"), "交易明细查询"),
        SIGN_CUSTOMER_QINFO("QR04", Byte.valueOf("14"), "签约客户信息查询"),
        ACCT_QACCOUNT("QR05", Byte.valueOf("15"), "二级账户查询"),
        ACCOUNT_QBALANCE("QR06", Byte.valueOf("16"), "余额查询"),
        ORDER_BACK("QR07", Byte.valueOf("19"), "回单查询"),
        TRANSACTION_STATUS("QR10", Byte.valueOf("20"), "交易状态查询"),
        VIRT_BILL_DOWNLOAD("QR11", Byte.valueOf("21"), "虚拟流水账单下载"),
        SEND_MOBILE_MSG("TP10", Byte.valueOf("17"), "获取短信验证码"),
        MULTI_AMOUNT_PAYMENT("TP40", Byte.valueOf("18"), "综合支付");

        NanJBankInterfTransCode(String code, Byte type, String remark) {
            this.code = code;
            this.type = type;
            this.remark = remark;
        }

        String code;        //  接口交易编码
        String remark;      //  接口信息描述
        Byte type;          //  平台自定义类型，用于存储调用支付的接口类型

        public String getCode() {
            return code;
        }

        public Byte getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

    }

    /**
     * 资金支付渠道
     */
    public enum Channel {
        NANJBANK(Byte.valueOf("1"), "南京银行鑫e商贸");

        Channel(Byte channel, String remark) {
            this.channel = channel;
            this.remark = remark;
        }

        Byte channel;
        String remark;

        public Byte getChannel() {
            return channel;
        }

        public String getRemark() {
            return remark;
        }
    }

    public enum NanJBankAccountStatus {
        NOUSER(Byte.valueOf("-1"), "未开户"), ACTIVE(Byte.valueOf("1"), "激活"), UNACTIVE(Byte.valueOf("0"), "待激活"), CANCEL(Byte.valueOf("2"), "注销");

        NanJBankAccountStatus(Byte status, String remark) {
            this.status = status;
            this.remark = remark;
        }

        public Byte getStatus() {
            return status;
        }

        public String getRemark() {
            return remark;
        }

        private Byte status;

        private String remark;

    }

    /**
     * 出金接口类型
     */
    public enum WithdrawType {

        OUTGLOD("01", "会员出金（出金接口）");

        WithdrawType(String type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        private String type;

        private String remark;

        public String getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

    }

    /**
     * 资金支付接口类型
     */
    public enum PaymentType {

        BALANCE("101", "余额支付"), BANKCARK("102", "银行卡支付"), TRUST_BALANCE("201", "担保余额支付"), TRUST_BANKCARK("202", "担保银行卡支付"), FORCE("300", "强制支付");

        PaymentType(String type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        private String type;

        private String remark;

        public String getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

    }

    public enum InterfaceResult {

        SUCCESS(Byte.valueOf("1"), "成功"), FAIL(Byte.valueOf("0"), "失败"),
        OPERATING(Byte.valueOf("2"), "交易处理中【线下支付接口状态】"), TIMEOUT(Byte.valueOf("3"), "接口调用超时");

        InterfaceResult(Byte status, String remark) {
            this.status = status;
            this.remark = remark;
        }

        public Byte getStatus() {
            return status;
        }

        public String getRemark() {
            return remark;
        }

        Byte status;

        String remark;

        public static String getRemarkByStatus(Byte  bb){
            String vv = "";
            if (SUCCESS.getStatus() == bb) {
                vv = SUCCESS.getRemark();
            }else if (FAIL.getStatus() == bb) {
                vv = FAIL.getRemark();
            }else if (OPERATING.getStatus() == bb) {
                vv = OPERATING.getRemark();
            }else if (TIMEOUT.getStatus() == bb) {
                vv = TIMEOUT.getRemark();
            }
            return vv;
        }
    }

    /**
     * 付款流水的类型
     */
    public enum PaymentWaybillStatus {

        OWNER2COMPANY(Byte.valueOf("0"), "货主给物流公司支付运费【含油费】"), COMPANY2RENT(Byte.valueOf("1"), "物流公司给租赁公司支付运费【含油费】"),
        RENT2DRIVER(Byte.valueOf("2"), "租赁公司给司机支付运费【不含油费】"), COMPANY2OIL(Byte.valueOf("3"), "物流给加油公司支付油费"),
        OIL2OIL(Byte.valueOf("4"), "油气公司给加油站支付油费"), DRIVER2OIL(Byte.valueOf("5"), "司机到加油站加油"),
        COMPANY2DRIVER(Byte.valueOf("6"), "物流公司给司机支付运费"), COMPANY2DRIVER_OIL(Byte.valueOf("7"), "物流公司给司机支付油费【不可提现的】"),
        RECHARGE(Byte.valueOf("8"), "线下充值同步"), WITHRAW(Byte.valueOf("9"), "提现"), ALLOTOIL2DRIVER(Byte.valueOf("10"), "车队长给司机分配油费"),
        ORDERPAY(Byte.valueOf("11"), "云商订单支付");

        PaymentWaybillStatus(byte type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        private byte type;

        private String remark;

        public byte getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

    }

    /**
     * 资金账户流水类型
     */
    public enum AccountLogType {

        IN(Byte.valueOf("0"), "入金"), OUT(Byte.valueOf("1"), "出金"), FREEZEN(Byte.valueOf("2"), "冻结"), UNFREEZEN(Byte.valueOf("3"), "解冻"),
        TRANS_IN(Byte.valueOf("4"), "资金支付（入金）"), TRANS_OUT(Byte.valueOf("5"), "资金支付（出金）"), OIL_IN(Byte.valueOf("6"), "油费充值"),
        OIL_OUT(Byte.valueOf("7"), "油费消费"), ALLOTOIL2DRIVER(Byte.valueOf("8"), "车队长给司机分配油费"), ACCEPTOILFROMCHIEF(Byte.valueOf("9"), "司机接收车队长分配的油费")
        ;

        AccountLogType(byte type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        private byte type;

        private String remark;

        public byte getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

    }

    /**
     * 付款模式
     */
    public enum PaymentMode {
        ONLINE(Byte.valueOf("0"), "在线支付"), UNDERLINE(Byte.valueOf("1"), "线下支付"),
        PRE_TELEG(Byte.valueOf("2"), "电汇预支付"),
        PRE_HONOUR(Byte.valueOf("3"), "承兑预支付");

        PaymentMode(Byte type, String remark) {
            this.type = type;
            this.remark = remark;
        }

        private Byte type;

        private String remark;

        public Byte getType() {
            return type;
        }

        public String getRemark() {
            return remark;
        }

        public static String getRemark(Byte type){
            if(ONLINE.getType().byteValue() == type){
                return ONLINE.getRemark();
            }
            if(UNDERLINE.getType().byteValue() == type){
                return UNDERLINE.getRemark();
            }
            return "";
        }
    }

    public enum OilCardStatus {

        NO(Byte.valueOf("0"), "未消费完"), YES(Byte.valueOf("1"), "已消费完");

        OilCardStatus(Byte status, String remark) {
            this.status = status;
            this.remark = remark;
        }


        public Byte getStatus() {
            return status;
        }

        public void setStatus(Byte status) {
            this.status = status;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        private Byte status;

        private String remark;
    }

    /**
     * 合同签订的状态
     */
    public enum ContractStatus {

        NO(0, "未签"), PUBLISH(1, "发布"), OWNER(2, "货主签"), LOGISTICS(3, "物流公司签"), ALL(4, "完毕");

        ContractStatus(Integer status, String remark) {
            this.status = status;
            this.remark = remark;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        private Integer status;

        private String remark;

    }

    public enum YsPayStatusEnum {

        SUCCESS(Byte.valueOf("1"), "成功"), FAIL(Byte.valueOf("0"), "失败"),
        OPERATING(Byte.valueOf("2"), "待确认"), TIMEOUT(Byte.valueOf("3"), "接口调用超时");

        YsPayStatusEnum(Byte status, String remark) {
            this.status = status;
            this.remark = remark;
        }

        public Byte getStatus() {
            return status;
        }

        public String getRemark() {
            return remark;
        }

        Byte status;

        String remark;

        public static String getRemarkByStatus(Byte  bb){
            String vv = "";
            if (SUCCESS.getStatus() == bb) {
                vv = SUCCESS.getRemark();
            }else if (FAIL.getStatus() == bb) {
                vv = FAIL.getRemark();
            }else if (OPERATING.getStatus() == bb) {
                vv = OPERATING.getRemark();
            }else if (TIMEOUT.getStatus() == bb) {
                vv = TIMEOUT.getRemark();
            }
            return vv;
        }
    }

}