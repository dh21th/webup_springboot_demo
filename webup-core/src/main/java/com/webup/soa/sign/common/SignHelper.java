package com.webup.soa.sign.common;

import com.webup.soa.sign.vo.WriteBack;
import com.webup.soa.utils.DateUtils;
import com.webup.soa.utils.PasswordHelper;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 签名信息的基础类
 *
 * @author Xiaobei
 * @create 2017-08-30 22:00
 */
public class SignHelper {

    private static final int minute = 1;

    private SignHelper(){}

    /**
     * 判断时间戳是否在指定的时间（1分钟）范围内
     * @param signDateTime 签章系统发起请求的时间
     * @return
     */
    private static String getSignTime(String signDateTime){
//        String dateStrForAddMinute = DateUtils.getDateStrForAddMinute(minute, null);
        String receivedDateTime = DateUtils.getSignTime();
        long signTimeMinuteInterval = DateUtils.getSignTimeMinuteInterval(signDateTime, receivedDateTime);
        return signTimeMinuteInterval<minute?signDateTime:null;
    }

    /**
     * 计算签名信息
     * @param writeBack
     * @return
     */
    public static String generateSignKey(WriteBack writeBack){
        String s = PasswordHelper.encryptSignInfo(writeBack);
        return s;
    }

    /**
     * 验证签名信息
     * @param writeBack
     * @return
     */
    public static String verifySignKey(WriteBack writeBack){
        if(writeBack!=null
                && writeBack.getSign()!=null
                && writeBack.getTimestamp() != null
                && writeBack.getId() != null
                && writeBack.getSource() != null
                && writeBack.getSignstate() != null
                && writeBack.getState() != null
                && writeBack.getUserType() != null
                && getSignTime(writeBack.getTimestamp())!=null
                && writeBack.getId()!=null)return generateSignKey(writeBack);//签名过期
        return null;
    }

}
