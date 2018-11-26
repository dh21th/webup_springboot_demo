package com.webup.soa.yunshang.common;//package com.elionyz.yunshang.common;
//
//import com.elionyz.yunshang.ams.pojo.UserCorpInfo;
//import org.apache.log4j.Logger;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.Calendar;
//
///**
// * 该类用于将所需信息组织成json格式并写入到文件中以便进行相应的转码和签名
// * Created by Legend on 2017/2/7.
// */
//public class ConvertJsonUtil {
//
//    private static Logger log = Logger.getLogger(ConvertJsonUtil.class);
//
//    /**
//     * 私有化构造方法
//     */
//    private ConvertJsonUtil(){}
//
//    /**
//     * PC端签章要生成的临时文件的内容
//     * 将合同文件的地址和当前状态组织成json串写入文件中（只针对合同发布之后的情况）
//     * 格式形如：{'filePath':'/usr/local/tomcat-6.0.48/webapps/uploadfile/file/2017/2/3/5439797a687b49c88b2e334615862cc2.doc','state':'0'}
//     * @param root web应用的根目录（例如：/usr/local/tomcat-6.0.48/webapps）
//     * @param sourceFilePath 上传文件在web服务器上的路径（例如：/uploadfile/photo/2016/12/25/1f06dbc36faf459d924b9af01072c47b.doc）
//     * @param state 合同需要转换的状态 2或3或4
//     * @return 返回生成的临时文件的内容
//     */
//    public static String getContractInfoOfJson(String root,Integer contractId,Integer usertype, String sourceFilePath, String companyName, String sealType, String signKeyWords, String legalman, String corpno, Short state){
//        String fileSuffix = getFileSuffix(sourceFilePath);
//        String targetFilePath = getTargetFileName(root,sourceFilePath,"pdf",state.toString());
//        sourceFilePath = root+sourceFilePath;
//        sourceFilePath = sourceFilePath.replace("/",File.separator).replace("\\",File.separator);
//        JSONObject signInfoJson = new JSONObject();//存放签章所需用到的信息
//        signInfoJson.put("companyName",companyName);//公司名称
//        signInfoJson.put("sealType",sealType);//合同签章类型（合同中心文字）
//        signInfoJson.put("legalman",legalman);//企业法人
//        signInfoJson.put("corpno",corpno);//企业统一社会信用代码
//        signInfoJson.put("signKeyWords",signKeyWords);//签章关键字
//        JSONObject json = new JSONObject();
//        json.put("signType",3);//签章来源 3 PC端，4 APP端
//        json.put("contractId",contractId);//合同id
//        json.put("usertype",usertype);//当前发起签章的用户类型 1 货主 2 物流公司 4司机
//        json.put("fileSuffix",fileSuffix);//合同文件后缀
//        json.put("sourceFilePath",sourceFilePath);//合同文件位置的全路径
//        json.put("targetFilePath",targetFilePath);//目标文件位置的全路径
//        json.put("state",state);//合同签章后的状态
//        json.put("signInfo",signInfoJson);//签章时用到的相关信息
//        return json.toString();
//    }
//
//    /**
//     * 根据合同名称和合同来源生成监听文件的文件名
//     * @param sourceFileName 上传文件在web服务器上的路径（例如：/uploadfile/photo/2016/12/25/1f06dbc36faf459d924b9af01072c47b.doc）
//     * @param state 合同需要转换的状态 0 1 2 3 4
//     * @return 生成临时的监听文件的名称
//     */
//    private static String getTempFileName(String sourceFileName, String state){
//        if(state!=""){
//            state = "_"+state;
//        }
//        if(sourceFileName.contains("/")&&sourceFileName.contains(".")){
//            int startIndex = sourceFileName.lastIndexOf("/");
//            int endIndex = sourceFileName.lastIndexOf(".");
//            sourceFileName = sourceFileName.substring(startIndex+1,endIndex);
//            sourceFileName = sourceFileName+state;
//        }
//        return sourceFileName+".txt";
//    }
//
//    /**
//     * 获取合同目标文件的全路径
//     * @param root web应用的根目录（例如：/usr/local/tomcat-6.0.48/webapps）
//     * @param sourceFilePath 上传文件在web服务器上的路径（例如：/uploadfile/photo/2016/12/25/1f06dbc36faf459d924b9af01072c47b.doc）
//     * @param state 合同需要转换的状态 0 1 2 3 4
//     * @return 目标合同文件的全路径
//     */
//    private static String getTargetFileName(String root, String sourceFilePath, String suffix, String state){
//        sourceFilePath = root+sourceFilePath;
//        sourceFilePath = sourceFilePath.replace("/",File.separator).replace("\\",File.separator);
//        int point = sourceFilePath.lastIndexOf(".");//后缀前的"."
//        String fileName = sourceFilePath.substring(0,point);//文件名
//        if("".equals(suffix)){
//            suffix = sourceFilePath.substring(point+1);//文件后缀
//        }
//        return fileName+"_s_" + state + "." + suffix;
//    }
//
//    /**
//     * 获取文件后缀
//     * @param sourceFilePath 上传文件在web服务器上的路径（例如：/uploadfile/photo/2016/12/25/1f06dbc36faf459d924b9af01072c47b.doc）
//     * @return 文件后缀 doc/pdf/xlsx等
//     */
//    private static String getFileSuffix(String sourceFilePath){
//        String fileSuffix = "";
//        int lastPointIndex = sourceFilePath.lastIndexOf(".");
//        int suffixLength = sourceFilePath.length()-lastPointIndex;
//        log.info("后缀长度为："+suffixLength);
//        if(suffixLength<=5){
//            fileSuffix = sourceFilePath.substring(lastPointIndex+1);
//        }else {
//            log.error("文件类型有误，请确认文件类型是否正确！");
//        }
//        return fileSuffix;
//    }
//
//
//}
//
