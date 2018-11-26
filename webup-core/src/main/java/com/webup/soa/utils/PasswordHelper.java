/**
 * 
 */
package com.webup.soa.utils;

import com.webup.soa.common.CommonConst;
import com.webup.soa.sign.vo.WriteBack;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author Zhengwei
 * @version 1.2
 * @project yzys
 * @class_name: PasswordHelper
 * @description: TODO
 * @date 2017年7月5日 下午4:55:17
 * 
 */
public class PasswordHelper {
	private String algorithmName;		//加密算法
	private int hashIterations;			//散列次数

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	/**
	 * @Description: 加密
	 * @param passwrd 密码明文
	 * @param salt 盐值
	 * @return String 加密后的值
	 */
	public String encryptPassword(String passwrd, Object salt) {
		if(algorithmName==null)algorithmName="md5";
		if(hashIterations==0)hashIterations=2;
		return  new SimpleHash(algorithmName, passwrd, ByteSource.Util.bytes(salt), hashIterations).toHex();
	}

	/**
	 * 请求相关的签名信息
	 * @param writeBack
	 * @return
     */
	public static String encryptSignInfo(WriteBack writeBack){
		String salt = writeBack.getId()
				+ writeBack.getSignstate()
				+ writeBack.getUserType()
				+ CommonConst.SignSource.valueOf(writeBack.getSource()).getDesc()
				+ writeBack.getTimestamp();
		return new Md5Hash("md5", ByteSource.Util.bytes(salt), 2).toString();
	}
}
