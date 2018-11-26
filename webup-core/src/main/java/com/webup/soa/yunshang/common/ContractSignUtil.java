package com.webup.soa.yunshang.common;


import com.webup.soa.utils.DateUtils;
import com.webup.soa.utils.FileUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 云商平台合同签订类
 *
 * @author Xiaobei
 * @create 2017-08-29 15:27
 */
public class ContractSignUtil {

    private ContractSignUtil(){}

    /**
     * 根据合同内容及合同文件后缀生成合同文件并返回相关路径文件路径
     * @param content 合同内容
     * @param suffix 合同文件后缀
     * @return
     */
    public static GenerateContractResult generateContractSourceFile(String content, String suffix){
        Map<String,String> contractMap = new HashMap<>();
        String rootPath = PropUtil.UPLOAD_PATH;//合同保存根目录
        String partDir = genereteContractDirPath();// 形如：/UploadFile/contractFile/2017/8/8/
        String fileName = UUID.randomUUID().toString().replaceAll("\\-", "");// 返回一个随机UUID作为合同文件名。
        String dirpath = rootPath + partDir;
        String sourceFilePath = File.separator + partDir + fileName + CommonConst.Symbols.point + suffix;
        String targetFilePath = File.separator + partDir + fileName + CommonConst.Symbols.point + "pdf";
        //创建合同空文件
        String filePath = FileUtils.createFile(fileName, suffix, dirpath);
        content = content.replace("<currentTime/>", DateUtils.formatCurrentDate(DateUtils.DEFAULT_FORMAT_PATTERN));
        //将内容写入文件
        boolean writeFlag = FileUtils.writeFileContent(filePath, content);
        //将签章结果存入类中
        GenerateContractResult contractResult = new GenerateContractResult();
        contractResult.setSourceFilePath(sourceFilePath);
        contractResult.setTargetFilePath(targetFilePath);
        contractResult.setWriteFlag(writeFlag);
        contractResult.setRootPath(rootPath);
        return contractResult;
    }

    /**
     * 返回生成的文件部分路径
     * 形如：/UploadFile/contractFile/2017/8/8/
     * @return
     */
    private static String genereteContractDirPath(){
        String contractRootPath = CommonConst.FileUploadPath + File.separator + PropUtil.CONTRACT_FILE;//合同文件存放的根目录
        String storageFolder = FileUtils.getStorageFolder();//年月日多级目录
        String contractDirPath = contractRootPath + storageFolder + File.separator;
        return contractDirPath;
    }

    /**
     * 根据当前的用户类型和合同状态，计算签章成功后的状态
     * @param userType 当前用户类型
     * @param currentState 当前合同状态
     * @return
     */
    public static Integer generateEndStateByUserTypeAndCurrentState(Integer userType, Integer currentState){
        boolean isJia = userType==com.webup.soa.common.CommonConst.SignUserType.JIAFANG.getValue();
        boolean isJi  = userType==com.webup.soa.common.CommonConst.SignUserType.YIFANG.getValue();
        if(!isJia && !isJi){
            return null;
        }
        if(currentState==CommonConst.GoodsOrderState.DRAFT.getIndex()
                || currentState==CommonConst.GoodsOrderState.THROUGH.getIndex()){
            return isJia ? CommonConst.GoodsOrderState.SIGNED_A.getIndex() : CommonConst.GoodsOrderState.SIGNED_B.getIndex();
        }else if( isJia && currentState==CommonConst.GoodsOrderState.SIGNED_B.getIndex()
                ||  isJi && currentState==CommonConst.GoodsOrderState.SIGNED_A.getIndex() ) {
            return CommonConst.GoodsOrderState.SIGNED_ALL.getIndex();
        }
        return null;
    }
}
