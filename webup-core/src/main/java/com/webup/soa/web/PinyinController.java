package com.webup.soa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webup.soa.base.AbstractBaseController;
import com.webup.soa.base.JsonResult;
import com.webup.soa.utils.PinyinToolkit;

/**
 * 拼音助手
 * 
 * @author fanhaoyu
 * @date 2015年5月4日
 */
@Controller
@RequestMapping(value = "/common")
public class PinyinController extends AbstractBaseController{

	@ResponseBody
	@RequestMapping(value = "/getHelpCode")
	public JsonResult<String> getHelpCode(String text) {
		JsonResult<String> result = JsonResult.newResult();
		try {
			String helpCode = PinyinToolkit.cn2FirstSpell(text);
			result.setData(helpCode);
		} catch (Exception e) {
			logger.warn(this.getClass().getName(), "获取助记码失败", e);
			result.setSuccess(false);
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getPinyin")
	public JsonResult<String> getPinyin(String text) {
		JsonResult<String> result = JsonResult.newResult();
		try {
			String pinyin = PinyinToolkit.cn2Spell(text);
			result.setData(pinyin);
		} catch (Exception e) {
			logger.warn(this.getClass().getName(), "获取拼音失败", e);
			result.setSuccess(false);
		}
		return result;
	}

}
