package com.webup.soa.base;

/**
 * Created by Legend on 2017/7/8.
 */

public enum SignStateEnum {


    nopulish(0,"未发布"),
    saveSuccess(1,"保存成功"),
    publishSuccess(2,"发布成功"),
    signSuccess(3,"签章成功"),
    //发布过程
    saving(4,"保存中"),
    publishing(5,"发布中"),
    signing(6,"签章中"),
    //申请证书过程可能的异常
    parseJsonError(7,"json转换异常"),
    convertFileError(8,"合同格式转换异常"),
    signErrorOfOrg(9,"申请证书失败：机构已经存在，机构名称和机构编码不匹配"),
    signErrorOfNet(10,"申请证书失败：通讯异常"),
    signErrorOfRequest(11,"申请证书失败：发送请求数据异常"),
    signErrorOfGetId(12,"申请证书失败"),
    //签章过程的可能的异常
    signFailure(13,"签章失败：找到关键字，但签章失败"),
    signErrorOfNoKeysFind(14,"签章失败：未找到关键字"),
    signErrorOfGetCert(15,"签章失败：获取软证书失败"),
    otherError(16,"其他异常"),

    //文档格式转换异常
    convertSuccess(17,"转换成功"),
    convertErrorOfNoFile(18,"传入的文件，找不到"),
    convertErrorOfNotOpen(19,"传入的文件，打开失败"),
    convertError(20,"转换过程异常失败"),
    convertErrorOfHavePass(21,"传入的文件有密码"),
    convertErrorOfSuffix(22,"targetFileName的后缀名错误"),
    convertErrorOfOther(23,"其他错误"),
    noThisContract(-1,"此合同不存在");

    private int value;

    private String desc;

    SignStateEnum(int value, String desc)
    {
        this.value = value;
        this.desc = desc;
    }

    public int getValue()
    {
        return value;
    }

    public String getDesc()
    {
        return desc;
    }

    public static SignStateEnum valueOf(int value)
    {
        if (nopulish.getValue() == value)
            return nopulish;
        if (saveSuccess.getValue() == value)
            return saveSuccess;
        if (publishSuccess.getValue() == value)
            return publishSuccess;
        if (signSuccess.getValue() == value)
            return signSuccess;
        if (saving.getValue() == value)
            return saving;
        if (publishing.getValue() == value)
            return publishing;
        if (signing.getValue() == value)
            return signing;
        if (parseJsonError.getValue() == value)
            return parseJsonError;
        if (convertFileError.getValue() == value)
            return convertFileError;
        if (signErrorOfOrg.getValue() == value)
            return signErrorOfOrg;
        if (signErrorOfNet.getValue() == value)
            return signErrorOfNet;
        if (signErrorOfRequest.getValue() == value)
            return signErrorOfRequest;
        if (signErrorOfGetId.getValue() == value)
            return signErrorOfGetId;
        if (signFailure.getValue() == value)
            return signFailure;
        if (signErrorOfNoKeysFind.getValue() == value)
            return signErrorOfNoKeysFind;
        if (signErrorOfGetCert.getValue() == value)
            return signErrorOfGetCert;
        if (otherError.getValue() == value)
            return otherError;
        if (convertSuccess.getValue() == value)
            return convertSuccess;
        if (convertErrorOfNoFile.getValue() == value)
            return convertErrorOfNoFile;
        if (convertErrorOfNotOpen.getValue() == value)
            return convertErrorOfNotOpen;
        if (convertError.getValue() == value)
            return convertError;
        if (convertErrorOfHavePass.getValue() == value)
            return convertErrorOfHavePass;
        if (convertErrorOfSuffix.getValue() == value)
            return convertErrorOfSuffix;
        if (convertErrorOfOther.getValue() == value)
            return convertErrorOfOther;
        if (noThisContract.getValue() == value)
            return noThisContract;
        return null;
    }
}
