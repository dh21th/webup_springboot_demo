//package com.webup.user.common;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * 注入属性值
// *
// * @author denghua
// * @create 2017-08-29 16:20
// */
//@Component
//@Data
//public class PropUtil {
//
//    /**
//     * 文件保存根路径
//     */
//    public static String UPLOAD_PATH;
//
//    /**
//     * 合同文件保存部分路径
//     */
//    public static String CONTRACT_FILE;
//
//    /**
//     * 云商平台回写请求url
//     */
//    public static String YUNSHANG_WRITEBACK_URL;
//
//    @Value("${send-msg}")
//    private boolean checkSendMsg;
//
//    @Value("${vaildate-code}")
//    private String vaildateCode;
//
//    @Value("#{yunShangProp[uploadpath]}")
//    public void setUploadPath(String uploadPath) {
//        PropUtil.UPLOAD_PATH = uploadPath;
//    }
//
//    @Value("#{yunShangProp[contractpath]}")
//    public void setContractFile(String contractFile) {
//        PropUtil.CONTRACT_FILE = contractFile;
//    }
//
//    @Value("#{yunShangProp[yunshangWriteBackUrl]}")
//    public void setYunshangWritebackUrl(String yunshangWritebackUrl) {
//        PropUtil.YUNSHANG_WRITEBACK_URL = yunshangWritebackUrl;
//    }
//
//}
