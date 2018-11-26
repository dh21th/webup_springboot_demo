package com.webup.soa.yunshang.utils;

import com.github.pagehelper.util.StringUtil;

/**
 * 包商接口返回错误类型
 * Created by zmon 2017/11/22.
 */
public enum BsErrorEnum {

    bserror1("000000","成功",true),
    bserror2("100001","商户号为空",false),
    bserror3("100002","加密报文为空",false),
    bserror4("100003","交易码为空",false),
    bserror5("100004","交易码不存在",false),
    bserror6("100005","流水号为空",false),
    bserror7("100006","流水号重复",false),
    bserror8("100007","发送日期为空",false),
    bserror9("100008","发送时间为空",false),
    bserror10("100009","发送日期格式不正确",false),
    bserror11("1000010","发送时间格式不正确",false),
    bserror12("1000011","报文格式错误",false),
    bserror13("1000012","数据加密失败",false),
    bserror14("1000013","数据解密失败",false),
    bserror15("1000014","密钥生成失败",false),
    bserror16("1000015","必输项不能为空",false),
    bserror17("1000016","报文格式错误",false),
    bserror18("1000017","商户号输入错误",false),
    bserror19("1000018","根据核心企业证件号没有查询到信息",false),
    bserror20("1000019","根据供应商证件号没有查询到信息",false),
    bserror21("999999","系统异常，请联系包商银行!",false);

    private String code;

    private String desc;

    private boolean flag;

     BsErrorEnum(String code, String desc, boolean flag){
        this.code = code;
        this.desc = desc;
        this.flag = flag;
    }

    public String getCode()
    {
        return code;
    }

    public String getDesc()
    {
        return desc;
    }

    public boolean getFlag()
    {
        return flag;
    }

    public static String getDescByCode(String code){
        if(StringUtil.isEmpty(code)){
            return null;
        }
        BsErrorEnum en = getEnem(code);
        if(null != en){
            return getEnem(code).getDesc();
        }
        return null;
    }

    public static  boolean getFlagByCode(String code){
        if(StringUtil.isEmpty(code)){
            return false;
        }
        BsErrorEnum en = getEnem(code);
        if(null != en){
            return getEnem(code).getFlag();
        }
        return false;
    }

    private static BsErrorEnum getEnem(String code){
        BsErrorEnum en = null;
        if(code.equals(bserror1.getCode())){
            en = bserror1;
        }else if(code.equals(bserror2.getCode())){
            en = bserror2;
        }else if(code.equals(bserror3.getCode())){
            en = bserror3;
        }else if(code.equals(bserror4.getCode())){
            en = bserror4;
        }else if(code.equals(bserror5.getCode())){
            en = bserror5;
        }else if(code.equals(bserror6.getCode())){
            en = bserror6;
        }else if(code.equals(bserror7.getCode())){
            en = bserror7;
        }else if(code.equals(bserror8.getCode())){
            en = bserror8;
        }else if(code.equals(bserror9.getCode())){
            en = bserror9;
        }else if(code.equals(bserror10.getCode())){
            en = bserror10;
        }else if(code.equals(bserror11.getCode())){
            en = bserror11;
        }else if(code.equals(bserror12.getCode())){
            en = bserror12;
        }else if(code.equals(bserror13.getCode())){
            en = bserror13;
        }else if(code.equals(bserror14.getCode())){
            en = bserror14;
        }else if(code.equals(bserror15.getCode())){
            en = bserror15;
        }else if(code.equals(bserror16.getCode())){
            en = bserror16;
        }else if(code.equals(bserror17.getCode())){
            en = bserror17;
        }else if(code.equals(bserror18.getCode())){
            en = bserror18;
        }else if(code.equals(bserror19.getCode())){
            en = bserror19;
        }else if(code.equals(bserror20.getCode())){
            en = bserror20;
        }else{
            en = bserror21;
        }
        return en;
    }
}
