package com.webup.soa.yunshang.utils;

/**
 * 系统常量定义
 * @author : dapeng
 */
public class CommonConst {

    /**
     * 参数不全
     */
    public static Integer PARAM_ERROR = -1;
    /**
     * 系统错误
     */
    public static Integer SYSTEM_ERROR = -2;
    /**
     * 密码错误
     */
    public static Integer PASSWORD_ERROR = -3;
    /**
     * 已评价
     */
    public static Integer IS_JUDGED = -4;
    /**
     * 验证码错误
     */
    public static Integer CODE_ERROR = -5;
    /**
     * 已存在
     */
    public static Integer IS_EXISTS = -6;
    /**
     * 被拒绝
     */
    public static Integer IS_REFUSE = -7;
    /**
     * 无权限操作
     */
    public static Integer NOPOWER_ERROR = -98;
    /**
     * 未登录
     */
    public static Integer LOGIN_ERROR = -99;

    public static class DataPattern {

        public static final String DEFAULT_DATE_PATTERNCN = "yyyy年MM月dd日";

        public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

        public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";

        public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

        public static final String MINUTE_DATETIME_PATTERN = "yyyy-MM-dd HH:mm";

        public static final String SOLR_DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    }

    public static class PullMsgType {

        public static final String PAGE_USER_LOGIN = "ulogin";

        public static final String PAGE_GOOGDS_LIST = "glist";

        public static final String PAGE_ORDER_LIST = "olist";

        public static final String PAGE_GOOGDS_SUBSLIE = "gslist";

    }

    public static class LogisticsRole {
        /**
         * 资金管理
         */
        public static final int MONEY = 1;
        /**
         * 基础数据
         */
        public static final int BASE = 2;
        /**
         * 运单管理
         */
        public static final int ORDER = 3;
        /**
         * 车源管理
         */
        public static final int CAR = 4;
        /**
         * 货源管理
         */
        public static final int GOODS = 5;
    }

    /**
     * 用户角色
     */
    public static class UserRole {

        /**
         * 发货人
         */
        public static final short CONSIGNOR = 1;

        /**
         * 物流公司
         */
        public static final short LOGISTICSCORP = 2;

        /**
         * 收货人
         */
        public static final Short CONSIGNEE = 3;

        /**
         * 车主
         */
        public static final short DRIVER = 4;

    }

    /**
     * 运单追踪状态
     */
    public static class OrderTraceStatus {
        /**
         * 开始承运
         */
        public static final int START = 1;

        /**
         * 卸货
         */
        public static final int UNLOAD = 2;

        /**
         * 已支付
         */
        public static final int PAYED = 3;

        /**
         * 完成
         */
        public static final int END = 4;

        /**
         * 装货拒绝
         */
        public static final int LOAD_ACCEPT = 5;

        /**
         *
         */
        public static final int LOAD_REJECT = 6;

        /**
         * 卸货确认
         */
        public static final int UNLOAD_ACCEPT = 7;

        /**
         * 卸货拒绝
         */
        public static final int UNLOAD_REJECT = 8;

    }

    public static class VerifyType {
        /**
         * 手机注册
         */
        public static final int PHONE_REG = 1;

        /**
         * 邮箱注册
         */
        public static final int EMAIL_REG = 2;

        /**
         * 手机密码找回
         */
        public static final int PHONE_FINDPASS = 3;

        /**
         * 邮箱密码找回
         */
        public static final int EMAIL_FINDPASS = 4;

        /**
         * 手机密码变更
         */
        public static final int PHONE_PASSEDIT = 5;

        /**
         * 邮箱密码变更
         */
        public static final int EMAIL_PASSEDIT = 6;

        /**
         * 收货验证码
         */
        public static final int PHONE_GOODS_RECEIVE = 7;

        /**
         * 动态密码登录验证码
         */
        public static final int PHONE_LOGIN = 8;

        /**
         * 接单短信通知信息
         */
        public static final int PHONE_ORDER_RECEIVE = 9;

        /**
         * 合同签订验证码短信
         */
        public static final int PHONE_CONTRACT_SIGN = 10;

        /**
         * 合同签订成功通知短信
         */
        public static final int PHONE_CONTRACT_SIGN_OK = 11;

        /**
         * 货主发布运输计划通知
         */
        public static final int PHONE_CONTRACT_PLAN = 12;

        /**
         * 设置安全密码
         */
        public static final int SET_SAFE_PASS = 13;
    }

    /**
     * 货源、运输计划、运单状态
     */
    public static class statusType {
        public static final String[] goodsType = {"未发布", "已发布"};
        public static final String[] askpriceType = {"审核拒绝", "待审核", "审核通过"};
        public static final String[] transportType = {"未派车", "已派车"};
        public static final String[] sendCarType = {"未生成运单", "已生成运单", "已开始承运", "送达"};
        public static final String[] orderType = {"待承运", "待发货", "待确认装货磅单", "运输中", "待确认卸货磅单", "待确认磅单", "磅单已驳回", "待支付", "待评价", "已完成"};

        public static String getGoodsType(Object state) {
            if (state == null) {
                return "";
            }
            int idx = Integer.parseInt(state.toString());
            return (idx >= 0 && idx < goodsType.length) ? goodsType[idx] : "";
        }

        public static String getAskPriceType(Object state) {
            if (state == null) {
                return "";
            }
            int idx = Integer.parseInt(state.toString()) + 1;
            return (idx >= 0 && idx < askpriceType.length) ? askpriceType[idx] : "";
        }

        public static String getTransportType(Object state) {
            if (state == null) {
                return "";
            }
            int idx = Integer.parseInt(state.toString()) - 1;
            return (idx >= 0 && idx < transportType.length) ? transportType[idx] : "";
        }

        public static String getSendCarType(Object state) {
            if (state == null) {
                return "";
            }
            int idx = Integer.parseInt(state.toString());
            return (idx >= 0 && idx < sendCarType.length) ? sendCarType[idx] : "";
        }

    }

    public static class dictType {
        public static final String[] carType = {"", "平板车", "高栏车", "厢式车", "高低板", "保温车", "冷藏车", "危险品车", "集装箱车", "自卸货车", "飞翼车", "半封闭车", "敞篷车", "金杯车"};
        public static final String[] goodsType = {"", "设备", "矿产", "建材", "食品", "蔬菜", "生鲜", "药品", "化肥", "农资"};
        public static final String[] goodsWeightType = {"吨", "立方", "件", "车"};
        public static final String[] paybasisType = {"入厂磅单数据", "入厂磅单数据（固定值）", "最小磅单数量", "出厂磅单数据"};

        public static String getCarType(Object id) {
            if (id == null) {
                return "";
            }
            int idx = Integer.parseInt(id.toString());
            return (idx > 0 && idx < carType.length) ? carType[idx] : "";
        }

        public static String getPaybasisType(Object state) {
            if (state == null) {
                return "";
            }
            int idx = Integer.parseInt(state.toString());
            return (idx >= 0 && idx < paybasisType.length) ? paybasisType[idx] : "";
        }

        public static String getGoodsType(Object id) {
            if (id == null) {
                return "";
            }
            int idx = Integer.parseInt(id.toString());
            return (idx > 0 && idx < goodsType.length) ? goodsType[idx] : "";
        }

        public static String getGoodsWeightType(Object id) {
            if (id == null) {
                return "";
            }
            int idx = Integer.parseInt(id.toString());
            return (idx >= 0 && idx < goodsWeightType.length) ? goodsWeightType[idx] : "";
        }

        public static String getGoodsNumUnit(Object id) {
            if (id == null) {
                return "件";
            }
            int idx = Integer.parseInt(id.toString());
            return (idx == 0) ? "件" : "台";
        }

        public static String getPayType(Object id) {
            if (id == null) {
                return "约定";
            }
            int idx = Integer.parseInt(id.toString());
            return (idx == 1) ? "在线支付" : "现金支付";
        }
    }

    public static final class Page {

        public static final int DEFAULT_MAX = 10;

        public static final int DEFAULT_PAGE_START = 1;
    }

}
